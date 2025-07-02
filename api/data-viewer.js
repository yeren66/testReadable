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
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type, X-Admin-Key');

    if (req.method === 'OPTIONS') {
        res.status(200).end();
        return;
    }

    // 返回数据查看器HTML
    const viewerHTML = `
    <!DOCTYPE html>
    <html lang="zh-CN">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>评分数据查看器</title>
        <style>
            body { font-family: Arial, sans-serif; margin: 20px; background: #f5f5f5; }
            .container { max-width: 1200px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }
            .header { border-bottom: 2px solid #007bff; padding-bottom: 10px; margin-bottom: 20px; }
            .instructions { background: #e3f2fd; padding: 15px; border-radius: 6px; margin-bottom: 20px; }
            .log-viewer { background: #f8f9fa; padding: 15px; border-radius: 6px; margin: 20px 0; }
            .log-entry { background: white; padding: 10px; margin: 10px 0; border-radius: 4px; border-left: 4px solid #007bff; }
            .log-entry pre { margin: 0; white-space: pre-wrap; word-wrap: break-word; }
            .btn { background: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin: 5px; }
            .btn:hover { background: #0056b3; }
            .btn-success { background: #28a745; }
            .btn-success:hover { background: #218838; }
            .alert { padding: 12px; border-radius: 4px; margin: 10px 0; }
            .alert-info { background: #d1ecf1; border-left: 4px solid #17a2b8; }
            .alert-warning { background: #fff3cd; border-left: 4px solid #ffc107; }
            .alert-success { background: #d4edda; border-left: 4px solid #28a745; }
            .code { background: #f8f9fa; padding: 2px 6px; border-radius: 3px; font-family: monospace; }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h1>📊 评分数据查看器</h1>
                <p>实时查看用户提交的评分数据</p>
            </div>

            <div class="instructions">
                <h3>📋 使用说明</h3>
                <p>由于 Vercel 函数的无状态特性，提交的数据主要记录在函数日志中。以下是查看数据的几种方法：</p>
                
                <div class="alert alert-info">
                    <h4>🔍 方法 1: Vercel Dashboard（最直接）</h4>
                    <ol>
                        <li>访问 <a href="https://vercel.com/dashboard" target="_blank">Vercel Dashboard</a></li>
                        <li>选择您的项目</li>
                        <li>点击 "Functions" 标签</li>
                        <li>选择 "submit-evaluation" 函数</li>
                        <li>点击 "Logs" 标签</li>
                        <li>搜索 <span class="code">EVALUATION SUBMISSION</span> 关键词</li>
                    </ol>
                </div>

                <div class="alert alert-info">
                    <h4>💻 方法 2: Vercel CLI</h4>
                    <pre><code>npm install -g vercel
vercel login
vercel logs --follow</code></pre>
                    <p>然后在应用中提交数据，实时查看日志输出</p>
                </div>

                <div class="alert alert-warning">
                    <h4>⚠️ 当前限制</h4>
                    <p>由于 Vercel 函数是无状态的，无法在函数间持久化数据。每次函数调用都是独立的，无法访问之前的提交记录。</p>
                </div>
            </div>

            <div class="log-viewer">
                <h3>📝 模拟日志查看器</h3>
                <p>以下是提交数据在 Vercel 日志中的格式示例：</p>
                
                <div class="log-entry">
                    <strong>示例日志条目：</strong>
                    <pre>=== EVALUATION SUBMISSION ===
Submission ID: eval_abc123_def456
Timestamp: 2025-01-01T12:00:00.000Z
User Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)...
IP: 192.168.1.1
Total Methods: 99
Started Methods: 5
Completed Methods: 3
Incomplete Methods: 2
Not Started Methods: 94
Completion Rate: 3.0%
Progress Rate: 5.1%
Total Evaluations: 60
Full Data: {
  "id": "eval_abc123_def456",
  "timestamp": "2025-01-01T12:00:00.000Z",
  "data": {
    "evaluationData": { ... },
    "methodToolMappings": { ... },
    "metadata": { ... }
  }
}
=== END SUBMISSION ===</pre>
                </div>
            </div>

            <div class="alert alert-success">
                <h4>💡 推荐的数据持久化方案</h4>
                <p>为了更好地管理和查看数据，建议集成以下服务之一：</p>
                <ul>
                    <li><strong>Vercel KV:</strong> 与 Vercel 深度集成的键值存储</li>
                    <li><strong>Supabase:</strong> 开源的 Firebase 替代品，提供实时数据库</li>
                    <li><strong>PlanetScale:</strong> 无服务器 MySQL 平台</li>
                    <li><strong>MongoDB Atlas:</strong> 云端 MongoDB 服务</li>
                    <li><strong>Airtable:</strong> 简单易用的在线数据库</li>
                </ul>
            </div>

            <div style="text-align: center; margin-top: 30px;">
                <button class="btn" onclick="window.open('https://vercel.com/dashboard', '_blank')">
                    打开 Vercel Dashboard
                </button>
                <button class="btn btn-success" onclick="window.location.href='/api/admin?key=admin123'">
                    返回管理后台
                </button>
            </div>
        </div>
    </body>
    </html>
    `;

    res.setHeader('Content-Type', 'text/html');
    res.status(200).send(viewerHTML);
}
