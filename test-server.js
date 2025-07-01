const http = require('http');
const fs = require('fs');
const path = require('path');
const url = require('url');

const PORT = 3000;

// MIME types
const mimeTypes = {
    '.html': 'text/html',
    '.js': 'text/javascript',
    '.css': 'text/css',
    '.json': 'application/json',
    '.png': 'image/png',
    '.jpg': 'image/jpg',
    '.gif': 'image/gif',
    '.ico': 'image/x-icon',
    '.svg': 'image/svg+xml'
};

function generateSubmissionId() {
    return 'sub_' + Date.now() + '_' + Math.random().toString(36).substr(2, 9);
}

function getTotalEvaluations(evaluationData) {
    let total = 0;
    for (const methodName in evaluationData) {
        const methodData = evaluationData[methodName];
        for (const toolId in methodData) {
            if (methodData[toolId] && typeof methodData[toolId] === 'object') {
                total += Object.keys(methodData[toolId]).length;
            }
        }
    }
    return total;
}

const server = http.createServer((req, res) => {
    const parsedUrl = url.parse(req.url, true);
    const pathname = parsedUrl.pathname;

    // CORS headers
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type, X-Admin-Key');

    if (req.method === 'OPTIONS') {
        res.writeHead(200);
        res.end();
        return;
    }

    // API endpoints
    if (pathname === '/api/submit-evaluation' && req.method === 'POST') {
        let body = '';
        req.on('data', chunk => {
            body += chunk.toString();
        });
        
        req.on('end', () => {
            try {
                const submissionData = JSON.parse(body);
                
                // Validate required fields
                if (!submissionData.evaluationData || !submissionData.methodToolMappings) {
                    res.writeHead(400, { 'Content-Type': 'application/json' });
                    res.end(JSON.stringify({ 
                        success: false, 
                        error: '缺少必要的评分数据' 
                    }));
                    return;
                }

                const submission = {
                    id: generateSubmissionId(),
                    timestamp: new Date().toISOString(),
                    userAgent: req.headers['user-agent'] || 'Unknown',
                    ip: req.headers['x-forwarded-for'] || req.connection.remoteAddress || 'Unknown',
                    data: submissionData
                };

                // Log submission details
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

                res.writeHead(200, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify({
                    success: true,
                    submissionId: submission.id,
                    message: '评分提交成功！感谢您的参与。',
                    timestamp: submission.timestamp
                }));

            } catch (error) {
                console.error('Error processing submission:', error);
                res.writeHead(400, { 'Content-Type': 'application/json' });
                res.end(JSON.stringify({ 
                    success: false, 
                    error: '数据格式错误' 
                }));
            }
        });
        return;
    }

    // Admin endpoint
    if (pathname === '/api/admin' && req.method === 'GET') {
        const adminKey = req.headers['x-admin-key'] || parsedUrl.query.key;
        const expectedKey = 'admin123';

        if (adminKey !== expectedKey) {
            res.writeHead(401, { 'Content-Type': 'application/json' });
            res.end(JSON.stringify({ error: 'Unauthorized. Please provide valid admin key.' }));
            return;
        }

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
                .info { background: #e3f2fd; padding: 15px; border-radius: 6px; margin-bottom: 20px; }
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
                    <p><strong>测试服务器:</strong> 运行在端口 ${PORT}</p>
                </div>
            </div>
        </body>
        </html>
        `;

        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(adminHTML);
        return;
    }

    // Serve static files
    let filePath = path.join(__dirname, 'public', pathname === '/' ? 'index.html' : pathname);
    
    fs.readFile(filePath, (err, content) => {
        if (err) {
            if (err.code === 'ENOENT') {
                res.writeHead(404, { 'Content-Type': 'text/html' });
                res.end('<h1>404 Not Found</h1>');
            } else {
                res.writeHead(500);
                res.end('Server Error');
            }
        } else {
            const ext = path.extname(filePath);
            const contentType = mimeTypes[ext] || 'application/octet-stream';
            
            res.writeHead(200, { 'Content-Type': contentType });
            res.end(content);
        }
    });
});

server.listen(PORT, () => {
    console.log(`Test server running at http://localhost:${PORT}/`);
    console.log(`Admin panel: http://localhost:${PORT}/api/admin?key=admin123`);
});
