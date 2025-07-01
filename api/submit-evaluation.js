export default async function handler(req, res) {
    // 设置CORS头
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'POST, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

    // 处理预检请求
    if (req.method === 'OPTIONS') {
        res.status(200).end();
        return;
    }

    // 只允许POST请求
    if (req.method !== 'POST') {
        return res.status(405).json({ 
            success: false, 
            error: 'Method not allowed' 
        });
    }

    try {
        const submissionData = req.body;
        
        // 验证数据完整性
        if (!submissionData || !submissionData.evaluationData || !submissionData.methodToolMappings) {
            return res.status(400).json({ 
                success: false, 
                error: 'Invalid submission data' 
            });
        }

        // 添加提交时间戳和唯一ID
        const submission = {
            id: generateSubmissionId(),
            timestamp: new Date().toISOString(),
            userAgent: req.headers['user-agent'] || 'Unknown',
            ip: req.headers['x-forwarded-for'] || req.connection.remoteAddress || 'Unknown',
            data: submissionData
        };

        // 将数据保存到环境变量或外部存储
        // 这里我们使用console.log记录，在Vercel中可以通过函数日志查看
        console.log('=== EVALUATION SUBMISSION ===');
        console.log('Submission ID:', submission.id);
        console.log('Timestamp:', submission.timestamp);
        console.log('User Agent:', submission.userAgent);
        console.log('IP:', submission.ip);
        console.log('Total Methods:', submissionData.metadata?.totalMethods || 'Unknown');
        console.log('Started Methods:', Object.keys(submissionData.evaluationData).length);
        console.log('Completed Methods:', submissionData.metadata?.completedMethods || 'Unknown');
        console.log('Incomplete Methods:', submissionData.metadata?.incompleteMethods || 'Unknown');
        console.log('Not Started Methods:', submissionData.metadata?.notStartedMethods || 'Unknown');
        console.log('Completion Rate:', submissionData.metadata?.totalMethods && submissionData.metadata?.completedMethods ?
            `${(submissionData.metadata.completedMethods / submissionData.metadata.totalMethods * 100).toFixed(1)}%` : 'Unknown');
        console.log('Progress Rate:', submissionData.metadata?.totalMethods &&
            (submissionData.metadata?.completedMethods !== undefined) &&
            (submissionData.metadata?.incompleteMethods !== undefined) ?
            `${((submissionData.metadata.completedMethods + submissionData.metadata.incompleteMethods) / submissionData.metadata.totalMethods * 100).toFixed(1)}%` : 'Unknown');
        console.log('Total Evaluations:', getTotalEvaluations(submissionData.evaluationData));
        console.log('Full Data:', JSON.stringify(submission, null, 2));
        console.log('=== END SUBMISSION ===');

        // 返回成功响应
        res.status(200).json({
            success: true,
            submissionId: submission.id,
            message: '评分提交成功！感谢您的参与。',
            timestamp: submission.timestamp
        });

    } catch (error) {
        console.error('Error processing submission:', error);
        res.status(500).json({
            success: false,
            error: 'Internal server error'
        });
    }
}

// 生成唯一的提交ID
function generateSubmissionId() {
    const timestamp = Date.now().toString(36);
    const randomStr = Math.random().toString(36).substring(2, 8);
    return `eval_${timestamp}_${randomStr}`;
}

// 计算总评分数量
function getTotalEvaluations(evaluationData) {
    let total = 0;
    Object.values(evaluationData).forEach(methodData => {
        Object.values(methodData).forEach(toolData => {
            if (toolData && typeof toolData === 'object') {
                total += Object.keys(toolData).length;
            }
        });
    });
    return total;
}
