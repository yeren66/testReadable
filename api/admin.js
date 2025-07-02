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
            .access-guide { margin-top: 15px; }
            .method-card { background: white; padding: 15px; margin: 10px 0; border-radius: 6px; border-left: 4px solid #007bff; }
            .method-card h5 { margin-top: 0; color: #007bff; }
            .method-card pre { background: #f8f9fa; padding: 10px; border-radius: 4px; margin: 10px 0; }
            .method-card code { background: #f8f9fa; padding: 2px 6px; border-radius: 3px; font-family: monospace; }
            .data-status { background: #f8f9fa; padding: 15px; border-radius: 6px; margin: 20px 0; }
            .status-success { background: #d4edda; border-left: 4px solid #28a745; }
            .status-info { background: #d1ecf1; border-left: 4px solid #17a2b8; }
            .status-warning { background: #fff3cd; border-left: 4px solid #ffc107; }
            .refresh-btn { background: #28a745; color: white; padding: 8px 16px; border: none; border-radius: 4px; cursor: pointer; margin-left: 10px; }
            .refresh-btn:hover { background: #218838; }
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
                <p><strong>快速操作:</strong>
                    <a href="/api/data-viewer?key=admin123" target="_blank" style="color: #007bff; text-decoration: none;">📊 查看数据</a> |
                    <a href="https://vercel.com/dashboard" target="_blank" style="color: #007bff; text-decoration: none;">🔧 Vercel Dashboard</a>
                </p>
            </div>

            <div class="stats">
                <div class="stat-card">
                    <div class="stat-number" id="totalSubmissions">加载中...</div>
                    <div class="stat-label">总提交数</div>
                </div>
                <div class="stat-card">
                    <div class="stat-number" id="todaySubmissions">加载中...</div>
                    <div class="stat-label">今日提交</div>
                </div>
                <div class="stat-card">
                    <div class="stat-number" id="avgEvaluations">加载中...</div>
                    <div class="stat-label">平均评分数</div>
                </div>
                <div class="stat-card">
                    <div class="stat-number" id="activeUsers">加载中...</div>
                    <div class="stat-label">活跃用户</div>
                </div>
            </div>

            <div class="info">
                <h3>📝 数据访问指南</h3>
                <div class="access-guide">
                    <h4>🔍 查看提交数据的方法：</h4>
                    <div class="method-card">
                        <h5>方法 1: Vercel Dashboard（推荐）</h5>
                        <ol>
                            <li>访问 <a href="https://vercel.com/dashboard" target="_blank">Vercel Dashboard</a></li>
                            <li>选择您的项目</li>
                            <li>点击 "Functions" 标签</li>
                            <li>选择 "submit-evaluation" 函数</li>
                            <li>点击 "Logs" 标签</li>
                            <li>搜索 <code>"EVALUATION SUBMISSION"</code> 关键词</li>
                        </ol>
                    </div>

                    <div class="method-card">
                        <h5>方法 2: Vercel CLI</h5>
                        <pre><code>vercel logs --follow</code></pre>
                        <p>然后在应用中提交数据，实时查看日志输出</p>
                    </div>
                </div>
            </div>

            <div class="data-status" id="dataStatus">
                <h3>📊 数据状态</h3>
                <p>正在检查数据访问状态...</p>
            </div>

            <div class="note">
                <strong>💡 升级建议:</strong>
                <p>当前系统使用 Vercel 函数日志记录数据，适用于研究和测试。如需更强大的数据管理功能，建议集成：</p>
                <ul>
                    <li><strong>Vercel KV:</strong> 键值存储，与 Vercel 深度集成</li>
                    <li><strong>Supabase:</strong> 开源 Firebase 替代品，提供实时数据库</li>
                    <li><strong>PlanetScale:</strong> 无服务器 MySQL 平台</li>
                    <li><strong>MongoDB Atlas:</strong> 云端 MongoDB 服务</li>
                </ul>
            </div>
        </div>

        <script>
            // 加载数据状态
            async function loadDataStatus() {
                try {
                    const response = await fetch('/api/get-submissions?key=admin123');
                    const data = await response.json();

                    if (data.success) {
                        updateDataStatus(data);
                    } else {
                        showDataError('无法加载数据状态');
                    }
                } catch (error) {
                    console.error('Error loading data:', error);
                    showDataError('数据加载失败: ' + error.message);
                }
            }

            function updateDataStatus(data) {
                const statusDiv = document.getElementById('dataStatus');
                statusDiv.className = 'data-status status-info';
                statusDiv.innerHTML = \`
                    <h3>📊 数据状态 <button class="refresh-btn" onclick="loadDataStatus()">刷新</button></h3>
                    <p><strong>当前状态:</strong> \${data.explanation.current_status}</p>
                    <p><strong>数据访问:</strong> \${data.explanation.data_access}</p>
                    <p><strong>搜索关键词:</strong> <code>\${data.explanation.search_keyword}</code></p>

                    <h4>🔧 系统限制</h4>
                    <p>\${data.explanation.limitations}</p>

                    <h4>💡 推荐的数据存储方案</h4>
                    <ul>
                        \${data.explanation.recommendations.map(rec => \`<li>\${rec}</li>\`).join('')}
                    </ul>
                \`;

                // 更新统计卡片
                document.getElementById('totalSubmissions').textContent = '查看日志';
                document.getElementById('todaySubmissions').textContent = '查看日志';
                document.getElementById('avgEvaluations').textContent = '查看日志';
                document.getElementById('activeUsers').textContent = '查看日志';
            }

            function showDataError(message) {
                const statusDiv = document.getElementById('dataStatus');
                statusDiv.className = 'data-status status-warning';
                statusDiv.innerHTML = \`
                    <h3>⚠️ 数据状态 <button class="refresh-btn" onclick="loadDataStatus()">重试</button></h3>
                    <p>\${message}</p>
                    <p>请检查网络连接或稍后重试。</p>
                \`;

                // 更新统计卡片
                document.getElementById('totalSubmissions').textContent = '无法加载';
                document.getElementById('todaySubmissions').textContent = '无法加载';
                document.getElementById('avgEvaluations').textContent = '无法加载';
                document.getElementById('activeUsers').textContent = '无法加载';
            }

            // 页面加载时自动加载数据
            document.addEventListener('DOMContentLoaded', loadDataStatus);
        </script>
    </body>
    </html>
    `;

    res.setHeader('Content-Type', 'text/html');
    res.status(200).send(adminHTML);
}
