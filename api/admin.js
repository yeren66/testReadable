export default async function handler(req, res) {
    // 简单的管理员验证（在生产环境中应该使用更安全的认证）
    const adminKey = req.headers['x-admin-key'] || req.query.key;
    const expectedKey = process.env.ADMIN_KEY || 'admin123'; // 在Vercel环境变量中设置

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

    // 返回管理界面HTML
    const adminHTML = `
    <!DOCTYPE html>
    <html lang="zh-CN">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>评分系统管理后台</title>
        <style>
            body { font-family: Arial, sans-serif; margin: 20px; background: #f5f5f5; }
            .container { max-width: 1200px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }
            .header { border-bottom: 2px solid #007bff; padding-bottom: 10px; margin-bottom: 20px; }
            .stats { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 15px; margin-bottom: 30px; }
            .stat-card { background: #f8f9fa; padding: 15px; border-radius: 6px; text-align: center; }
            .stat-number { font-size: 24px; font-weight: bold; color: #007bff; }
            .stat-label { color: #6c757d; margin-top: 5px; }
            .info { background: #e3f2fd; padding: 15px; border-radius: 6px; margin-bottom: 20px; }
            .note { background: #fff3cd; padding: 10px; border-radius: 4px; margin-top: 20px; }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1>📊 测试用例可读性评估系统 - 管理后台</h1>
                <p>管理和监控用户评分提交</p>
            </div>

            <div class="info">
                <h3>📋 系统状态</h3>
                <p><strong>API状态:</strong> ✅ 正常运行</p>
                <p><strong>最后更新:</strong> ${new Date().toLocaleString()}</p>
            </div>

            <div class="stats">
                <div class="stat-card">
                    <div class="stat-number">-</div>
                    <div class="stat-label">总提交数</div>
                </div>
                <div class="stat-card">
                    <div class="stat-number">-</div>
                    <div class="stat-label">今日提交</div>
                </div>
                <div class="stat-card">
                    <div class="stat-number">-</div>
                    <div class="stat-label">平均评分数</div>
                </div>
                <div class="stat-card">
                    <div class="stat-number">-</div>
                    <div class="stat-label">活跃用户</div>
                </div>
            </div>

            <div class="info">
                <h3>📝 数据收集说明</h3>
                <p>用户提交的评分数据会记录在Vercel函数日志中。要查看详细数据：</p>
                <ol>
                    <li>登录 <a href="https://vercel.com" target="_blank">Vercel Dashboard</a></li>
                    <li>进入项目 → Functions → submit-evaluation</li>
                    <li>查看函数调用日志</li>
                    <li>搜索 "EVALUATION SUBMISSION" 关键词</li>
                </ol>
            </div>

            <div class="note">
                <strong>💡 提示:</strong> 
                为了更好的数据管理，建议集成专门的数据库服务（如 Supabase、PlanetScale 或 Vercel KV）来存储评分数据。
                当前方案适用于小规模测试和数据收集。
            </div>
        </div>
    </body>
    </html>
    `;

    res.setHeader('Content-Type', 'text/html');
    res.status(200).send(adminHTML);
}
