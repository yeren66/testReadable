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

        // 将数据保存到内存存储（用于演示）
        // 在生产环境中，应该使用数据库或 Vercel KV
        await saveSubmissionData(submission);

        // 同时记录到日志
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

// 简单的内存存储（仅用于演示）
// 在生产环境中应该使用数据库
let submissionStorage = [];

// 保存提交数据
async function saveSubmissionData(submission) {
    try {
        // 在实际部署中，这里应该保存到数据库
        // 由于 Vercel 函数是无状态的，这个内存存储只在单次请求中有效
        // 建议使用 Vercel KV、Supabase 或其他数据库服务

        // 为了演示，我们将数据编码到环境变量中（不推荐用于生产）
        const submissionSummary = {
            id: submission.id,
            timestamp: submission.timestamp,
            userAgent: submission.userAgent,
            ip: submission.ip,
            completedMethods: submission.data.metadata?.completedMethods || 0,
            incompleteMethods: submission.data.metadata?.incompleteMethods || 0,
            totalMethods: submission.data.metadata?.totalMethods || 0,
            totalEvaluations: getTotalEvaluations(submission.data.evaluationData)
        };

        console.log('Saved submission summary:', JSON.stringify(submissionSummary));
        return submissionSummary;
    } catch (error) {
        console.error('Error saving submission:', error);
        throw error;
    }
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
