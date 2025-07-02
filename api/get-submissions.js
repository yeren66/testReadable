export default async function handler(req, res) {
    // 简单的管理员验证
    const adminKey = req.headers['x-admin-key'] || req.query.key;
    const expectedKey = process.env.ADMIN_KEY || 'admin123';

    if (adminKey !== expectedKey) {
        return res.status(401).json({ 
            error: 'Unauthorized. Please provide valid admin key.' 
        });
    }

    // 设置CORS头
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type, X-Admin-Key');

    if (req.method === 'OPTIONS') {
        res.status(200).end();
        return;
    }

    if (req.method !== 'GET') {
        return res.status(405).json({ error: 'Method not allowed' });
    }

    try {
        // 由于 Vercel 函数是无状态的，我们无法直接访问之前的提交数据
        // 这里返回一个说明和建议
        const response = {
            success: true,
            message: '数据存储说明',
            explanation: {
                current_status: '当前系统将数据记录在 Vercel 函数日志中',
                data_access: '要查看提交数据，请访问 Vercel Dashboard → Functions → submit-evaluation → Logs',
                search_keyword: '搜索 "EVALUATION SUBMISSION" 关键词查看详细数据',
                limitations: 'Vercel 函数是无状态的，无法在函数间共享内存数据',
                recommendations: [
                    '集成 Vercel KV 存储服务',
                    '使用 Supabase 数据库',
                    '集成 PlanetScale MySQL',
                    '使用 MongoDB Atlas',
                    '集成 Firebase Firestore'
                ]
            },
            mock_data: {
                total_submissions: '查看 Vercel 日志',
                recent_submissions: '查看 Vercel 日志',
                completion_stats: '查看 Vercel 日志'
            },
            vercel_logs_access: {
                step1: '登录 https://vercel.com',
                step2: '选择您的项目',
                step3: '点击 Functions 标签',
                step4: '选择 submit-evaluation 函数',
                step5: '查看 Logs 标签',
                step6: '搜索 "EVALUATION SUBMISSION"'
            }
        };

        res.status(200).json(response);

    } catch (error) {
        console.error('Error in get-submissions:', error);
        res.status(500).json({
            success: false,
            error: 'Internal server error'
        });
    }
}
