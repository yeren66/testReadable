#!/usr/bin/env node
/**
 * 部署验证脚本
 * 验证Vercel部署是否成功
 */

const https = require('https');
const http = require('http');

async function verifyDeployment(baseUrl) {
    console.log('🔍 验证部署状态...');
    console.log(`基础URL: ${baseUrl}`);
    
    const tests = [
        {
            name: '主页面',
            path: '/',
            expectedStatus: 200,
            expectedContent: 'test-case-evaluation-system'
        },
        {
            name: 'JavaScript文件',
            path: '/app.js',
            expectedStatus: 200,
            expectedContent: 'OnlineTestCaseEvaluationSystem'
        },
        {
            name: 'CSS文件',
            path: '/styles.css',
            expectedStatus: 200,
            expectedContent: '.container'
        },
        {
            name: 'API健康检查',
            path: '/api/save-evaluation',
            expectedStatus: 200,
            expectedContent: '评估数据收集服务正常运行'
        }
    ];
    
    let passedTests = 0;
    let totalTests = tests.length;
    
    for (const test of tests) {
        try {
            console.log(`\n测试: ${test.name}`);
            const result = await makeRequest(baseUrl + test.path);
            
            if (result.statusCode === test.expectedStatus) {
                console.log(`✅ 状态码正确: ${result.statusCode}`);
                
                if (test.expectedContent && result.body.includes(test.expectedContent)) {
                    console.log(`✅ 内容验证通过`);
                    passedTests++;
                } else if (!test.expectedContent) {
                    passedTests++;
                } else {
                    console.log(`❌ 内容验证失败，未找到: ${test.expectedContent}`);
                }
            } else {
                console.log(`❌ 状态码错误: 期望 ${test.expectedStatus}, 实际 ${result.statusCode}`);
            }
        } catch (error) {
            console.log(`❌ 请求失败: ${error.message}`);
        }
    }
    
    console.log(`\n📊 测试结果: ${passedTests}/${totalTests} 通过`);
    
    if (passedTests === totalTests) {
        console.log('🎉 部署验证成功！所有功能正常工作。');
        return true;
    } else {
        console.log('⚠️  部署验证失败，请检查上述错误。');
        return false;
    }
}

function makeRequest(url) {
    return new Promise((resolve, reject) => {
        const client = url.startsWith('https:') ? https : http;
        
        const req = client.get(url, (res) => {
            let body = '';
            
            res.on('data', (chunk) => {
                body += chunk;
            });
            
            res.on('end', () => {
                resolve({
                    statusCode: res.statusCode,
                    headers: res.headers,
                    body: body
                });
            });
        });
        
        req.on('error', (error) => {
            reject(error);
        });
        
        req.setTimeout(10000, () => {
            req.destroy();
            reject(new Error('请求超时'));
        });
    });
}

// 命令行使用
if (require.main === module) {
    const url = process.argv[2];
    
    if (!url) {
        console.log('使用方法: node verify-deployment.js <URL>');
        console.log('例如: node verify-deployment.js https://your-app.vercel.app');
        process.exit(1);
    }
    
    verifyDeployment(url)
        .then((success) => {
            process.exit(success ? 0 : 1);
        })
        .catch((error) => {
            console.error('验证过程出错:', error);
            process.exit(1);
        });
}

module.exports = { verifyDeployment };
