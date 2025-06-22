// 在线版本的评估系统 - 支持数据提交到服务器
class OnlineTestCaseEvaluationSystem {
    constructor() {
        this.testMethods = [];
        this.currentMethodIndex = 0;
        this.evaluationData = {};
        this.testCaseFiles = {};
        this.isOnline = true;
        this.apiEndpoint = '/api/save-evaluation';
        
        this.init();
    }

    async init() {
        await this.loadTestCaseStructure();
        this.setupEventListeners();
        this.loadEvaluationData();
        this.displayCurrentMethod();
        this.updateStats();
        this.showOnlineNotice();
    }

    showOnlineNotice() {
        // 显示在线版本提示
        const notice = document.createElement('div');
        notice.className = 'online-notice';
        notice.innerHTML = `
            <div class="notice-content">
                <i class="fas fa-cloud"></i>
                <span>在线评估系统 - 您的评分将自动保存到服务器</span>
            </div>
        `;
        document.body.appendChild(notice);
    }

    // 加载测试用例结构
    async loadTestCaseStructure() {
        try {
            // 使用嵌入的数据
            if (window.TEST_METHODS_DATA && window.TEST_CASES_DATA) {
                this.testMethods = window.TEST_METHODS_DATA;
                this.testCaseFiles = {};
                
                // 转换测试用例数据格式（匿名化）
                for (const method of this.testMethods) {
                    this.testCaseFiles[method.id] = {};
                    
                    const anonymousTools = ['Method_A', 'Method_B', 'Method_C', 'Method_D'];
                    for (const tool of anonymousTools) {
                        this.testCaseFiles[method.id][tool] = window.TEST_CASES_DATA[tool]?.[method.id] || null;
                    }
                }
                
                console.log(`已加载 ${this.testMethods.length} 个测试方法（在线匿名化版本）`);
            } else {
                throw new Error('未找到嵌入的测试数据');
            }
            
        } catch (error) {
            console.error('加载测试用例结构失败:', error);
            this.showError('无法加载测试用例结构，请确保数据文件正确生成。');
        }
    }

    // 设置事件监听器
    setupEventListeners() {
        // 导航按钮
        document.getElementById('prevBtn').addEventListener('click', () => this.previousMethod());
        document.getElementById('nextBtn').addEventListener('click', () => this.nextMethod());
        
        // 操作按钮 - 在线版本
        document.getElementById('exportBtn').addEventListener('click', () => this.submitEvaluation());
        document.getElementById('resetBtn').addEventListener('click', () => this.resetEvaluations());
        
        // 更新按钮文本
        document.getElementById('exportBtn').innerHTML = '<i class="fas fa-cloud-upload-alt"></i> 提交评估';
        
        // 键盘导航
        document.addEventListener('keydown', (e) => {
            if (e.key === 'ArrowLeft' && !document.getElementById('prevBtn').disabled) {
                this.previousMethod();
            } else if (e.key === 'ArrowRight' && !document.getElementById('nextBtn').disabled) {
                this.nextMethod();
            }
        });

        // 页面关闭前提醒
        window.addEventListener('beforeunload', (e) => {
            if (this.hasUnsavedData()) {
                e.preventDefault();
                e.returnValue = '您有未提交的评估数据，确定要离开吗？';
            }
        });
    }

    // 检查是否有未保存的数据
    hasUnsavedData() {
        return Object.keys(this.evaluationData).length > 0;
    }

    // 保存评分（在线版本 - 自动同步）
    saveEvaluation(methodId, toolName, criterion, score) {
        if (!this.evaluationData[methodId]) {
            this.evaluationData[methodId] = {};
        }
        if (!this.evaluationData[methodId][toolName]) {
            this.evaluationData[methodId][toolName] = {};
        }
        
        this.evaluationData[methodId][toolName][criterion] = score;
        
        // 保存到localStorage（本地备份）
        localStorage.setItem('testCaseEvaluations_online', JSON.stringify(this.evaluationData));
        
        // 自动同步到服务器（防抖）
        this.debouncedSync();
    }

    // 防抖同步
    debouncedSync() {
        clearTimeout(this.syncTimeout);
        this.syncTimeout = setTimeout(() => {
            this.syncToServer();
        }, 2000); // 2秒后同步
    }

    // 同步到服务器
    async syncToServer() {
        try {
            const response = await fetch(this.apiEndpoint, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    type: 'auto_sync',
                    evaluationData: this.evaluationData,
                    progress: this.getProgress()
                })
            });

            if (response.ok) {
                console.log('数据已自动同步到服务器');
                this.showSyncStatus('success');
            } else {
                console.warn('自动同步失败');
                this.showSyncStatus('error');
            }
        } catch (error) {
            console.error('同步错误:', error);
            this.showSyncStatus('error');
        }
    }

    // 显示同步状态
    showSyncStatus(status) {
        const statusElement = document.getElementById('syncStatus') || this.createSyncStatusElement();
        
        if (status === 'success') {
            statusElement.innerHTML = '<i class="fas fa-check-circle"></i> 已同步';
            statusElement.className = 'sync-status success';
        } else {
            statusElement.innerHTML = '<i class="fas fa-exclamation-triangle"></i> 同步失败';
            statusElement.className = 'sync-status error';
        }
        
        setTimeout(() => {
            statusElement.style.opacity = '0';
        }, 3000);
    }

    createSyncStatusElement() {
        const statusElement = document.createElement('div');
        statusElement.id = 'syncStatus';
        statusElement.className = 'sync-status';
        document.body.appendChild(statusElement);
        return statusElement;
    }

    // 提交最终评估
    async submitEvaluation() {
        if (Object.keys(this.evaluationData).length === 0) {
            alert('您还没有进行任何评分，无法提交。');
            return;
        }

        const confirmed = confirm('确定要提交最终评估结果吗？提交后将无法修改。');
        if (!confirmed) return;

        try {
            const results = {
                type: 'final_submission',
                timestamp: new Date().toISOString(),
                totalMethods: this.testMethods.length,
                evaluationData: this.evaluationData,
                summary: this.generateSummaryReport(),
                progress: this.getProgress(),
                userInfo: {
                    userAgent: navigator.userAgent,
                    language: navigator.language,
                    timezone: Intl.DateTimeFormat().resolvedOptions().timeZone
                }
            };

            const response = await fetch(this.apiEndpoint, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(results)
            });

            if (response.ok) {
                const result = await response.json();
                alert(`评估结果已成功提交！\n提交ID: ${result.submissionId}\n感谢您的参与！`);
                
                // 清除本地数据
                localStorage.removeItem('testCaseEvaluations_online');
                this.evaluationData = {};
                this.updateStats();
                
                // 显示感谢页面
                this.showThankYouPage();
            } else {
                throw new Error('提交失败');
            }
        } catch (error) {
            console.error('提交评估失败:', error);
            alert('提交失败，请检查网络连接后重试。您的数据已保存在本地。');
        }
    }

    // 显示感谢页面
    showThankYouPage() {
        const container = document.querySelector('.container');
        container.innerHTML = `
            <div class="thank-you-page">
                <div class="thank-you-content">
                    <i class="fas fa-check-circle"></i>
                    <h1>感谢您的参与！</h1>
                    <p>您的评估数据已成功提交。</p>
                    <p>您的贡献对我们的研究非常重要。</p>
                    <button onclick="location.reload()" class="restart-btn">
                        <i class="fas fa-redo"></i> 重新开始评估
                    </button>
                </div>
            </div>
        `;
    }

    // 获取进度信息
    getProgress() {
        const totalMethods = this.testMethods.length;
        let evaluatedMethods = 0;
        let totalScores = 0;
        let completedEvaluations = 0;

        this.testMethods.forEach(method => {
            const methodData = this.evaluationData[method.id];
            if (methodData) {
                const tools = Object.keys(methodData);
                let methodCompleted = false;
                
                tools.forEach(tool => {
                    const toolScores = Object.keys(methodData[tool]);
                    if (toolScores.length === 4) {
                        completedEvaluations++;
                        totalScores += Object.values(methodData[tool]).reduce((sum, score) => sum + score, 0);
                    }
                });
                
                if (tools.some(tool => Object.keys(methodData[tool]).length === 4)) {
                    evaluatedMethods++;
                }
            }
        });

        return {
            totalMethods,
            evaluatedMethods,
            completedEvaluations,
            averageScore: completedEvaluations > 0 ? (totalScores / completedEvaluations).toFixed(2) : 0,
            progressPercent: Math.round((evaluatedMethods / totalMethods) * 100)
        };
    }

    // 加载评估数据
    loadEvaluationData() {
        const saved = localStorage.getItem('testCaseEvaluations_online');
        if (saved) {
            try {
                this.evaluationData = JSON.parse(saved);
            } catch (error) {
                console.error('加载评估数据失败:', error);
                this.evaluationData = {};
            }
        }
    }

    // 重置评估
    resetEvaluations() {
        if (confirm('确定要重置所有评分吗？此操作不可撤销。')) {
            this.evaluationData = {};
            localStorage.removeItem('testCaseEvaluations_online');
            this.displayCurrentMethod();
            this.updateStats();
            alert('所有评分已重置！');
        }
    }

    // 显示当前方法
    displayCurrentMethod() {
        if (this.testMethods.length === 0) return;

        const currentMethod = this.testMethods[this.currentMethodIndex];

        // 更新方法信息
        document.getElementById('currentMethodName').textContent = `测试方法: ${currentMethod.fullName}`;
        document.getElementById('methodProject').textContent = currentMethod.project;
        document.getElementById('methodName').textContent = currentMethod.methodName;

        // 更新导航状态
        document.getElementById('prevBtn').disabled = this.currentMethodIndex === 0;
        document.getElementById('nextBtn').disabled = this.currentMethodIndex === this.testMethods.length - 1;
        document.getElementById('currentPosition').textContent =
            `${this.currentMethodIndex + 1} / ${this.testMethods.length}`;

        // 显示测试用例
        this.displayTestCases(currentMethod);

        // 更新评估汇总
        this.updateEvaluationSummary(currentMethod);
    }

    // 显示测试用例
    displayTestCases(method) {
        const container = document.getElementById('testCasesContainer');
        container.innerHTML = '';

        const tools = [
            { name: 'Method_A', displayName: '方法 A', badge: 'method-a' },
            { name: 'Method_B', displayName: '方法 B', badge: 'method-b' },
            { name: 'Method_C', displayName: '方法 C', badge: 'method-c' },
            { name: 'Method_D', displayName: '方法 D', badge: 'method-d' }
        ];

        tools.forEach(tool => {
            const testCaseContent = this.testCaseFiles[method.id]?.[tool.name];
            if (testCaseContent) {
                const card = this.createTestCaseCard(method, tool, testCaseContent);
                container.appendChild(card);
            }
        });

        // 如果没有任何测试用例，显示提示信息
        if (container.children.length === 0) {
            container.innerHTML = `
                <div class="loading-message">
                    <i class="fas fa-exclamation-triangle"></i>
                    <p>该方法暂无可用的测试用例</p>
                </div>
            `;
        }
    }

    // 创建测试用例卡片
    createTestCaseCard(method, tool, content) {
        const card = document.createElement('div');
        card.className = 'test-case-card';
        card.innerHTML = `
            <div class="test-case-header">
                <div class="test-case-title">
                    <span class="method-badge ${tool.badge}">${tool.displayName}</span>
                    ${method.fullName}.java
                </div>
            </div>
            <div class="test-case-content">
                <div class="code-container">
                    <div class="code-header">
                        <i class="fas fa-code"></i> 测试用例代码
                    </div>
                    <div class="code-content">
                        <pre class="line-numbers"><code class="language-java">${this.escapeHtml(content)}</code></pre>
                    </div>
                </div>
                <div class="evaluation-panel">
                    <div class="evaluation-title">
                        <i class="fas fa-star"></i> 评分
                    </div>
                    <div class="evaluation-grid">
                        ${this.createEvaluationItems(method.id, tool.name)}
                    </div>
                </div>
            </div>
        `;

        // 设置评分按钮事件
        this.setupEvaluationButtons(card, method.id, tool.name);

        // 语法高亮
        setTimeout(() => {
            if (window.Prism) {
                Prism.highlightAllUnder(card);
            }
        }, 0);

        return card;
    }

    // 创建评估项目
    createEvaluationItems(methodId, toolName) {
        const criteria = [
            { id: 'naming', name: '命名直观性', range: [1, 2, 3] },
            { id: 'layout', name: '代码布局', range: [1, 2, 3] },
            { id: 'assertion', name: '断言质量', range: [1, 2, 3] },
            { id: 'migration', name: '迁移成本', range: [1, 2, 3] }
        ];

        return criteria.map(criterion => `
            <div class="evaluation-item">
                <h4>${criterion.name} (${criterion.range[0]}-${criterion.range[criterion.range.length-1]}分)</h4>
                <div class="score-buttons" data-method="${methodId}" data-tool="${toolName}" data-criterion="${criterion.id}">
                    ${criterion.range.map(score =>
                        `<button class="score-btn" data-score="${score}">${score}</button>`
                    ).join('')}
                </div>
            </div>
        `).join('') + `
            <div class="evaluation-item">
                <div class="total-score" data-method="${methodId}" data-tool="${toolName}">
                    总分: <span class="total-value">未评分</span>
                </div>
            </div>
        `;
    }

    // 设置评分按钮事件
    setupEvaluationButtons(card, methodId, toolName) {
        const scoreButtons = card.querySelectorAll('.score-buttons');

        scoreButtons.forEach(buttonGroup => {
            const buttons = buttonGroup.querySelectorAll('.score-btn');
            const criterion = buttonGroup.dataset.criterion;

            buttons.forEach(button => {
                button.addEventListener('click', () => {
                    // 移除同组其他按钮的选中状态
                    buttons.forEach(btn => btn.classList.remove('selected'));
                    // 选中当前按钮
                    button.classList.add('selected');

                    // 保存评分
                    this.saveEvaluation(methodId, toolName, criterion, parseInt(button.dataset.score));

                    // 更新总分
                    this.updateTotalScore(card, methodId, toolName);

                    // 更新统计信息
                    this.updateStats();
                    this.updateEvaluationSummary(this.testMethods[this.currentMethodIndex]);
                });
            });
        });

        // 加载已有评分
        this.loadExistingScores(card, methodId, toolName);
    }

    // 其他必要方法
    previousMethod() {
        if (this.currentMethodIndex > 0) {
            this.currentMethodIndex--;
            this.displayCurrentMethod();
        }
    }

    nextMethod() {
        if (this.currentMethodIndex < this.testMethods.length - 1) {
            this.currentMethodIndex++;
            this.displayCurrentMethod();
        }
    }

    updateStats() {
        const totalMethods = this.testMethods.length;
        let evaluatedMethods = 0;

        this.testMethods.forEach(method => {
            const methodData = this.evaluationData[method.id];
            if (methodData) {
                const tools = Object.keys(methodData);
                if (tools.some(tool => Object.keys(methodData[tool]).length === 4)) {
                    evaluatedMethods++;
                }
            }
        });

        const progress = totalMethods > 0 ? Math.round((evaluatedMethods / totalMethods) * 100) : 0;

        document.getElementById('totalMethods').textContent = totalMethods;
        document.getElementById('evaluatedMethods').textContent = evaluatedMethods;
        document.getElementById('progressPercent').textContent = `${progress}%`;
    }

    updateEvaluationSummary(method) {
        const summaryElement = document.getElementById('evaluationSummary');
        const methodData = this.evaluationData[method.id];

        if (!methodData) {
            summaryElement.style.display = 'none';
            return;
        }

        const tools = ['Method_A', 'Method_B', 'Method_C', 'Method_D'];
        const averages = {};

        tools.forEach(tool => {
            const toolData = methodData[tool];
            if (toolData && Object.keys(toolData).length === 4) {
                const scores = Object.values(toolData);
                averages[tool] = (scores.reduce((sum, score) => sum + score, 0) / scores.length).toFixed(1);
            } else {
                averages[tool] = '-';
            }
        });

        document.getElementById('methodAAvg').textContent = averages['Method_A'];
        document.getElementById('methodBAvg').textContent = averages['Method_B'];
        document.getElementById('methodCAvg').textContent = averages['Method_C'];
        document.getElementById('methodDAvg').textContent = averages['Method_D'];

        summaryElement.style.display = 'block';
    }

    loadExistingScores(card, methodId, toolName) {
        const methodData = this.evaluationData[methodId];
        if (!methodData || !methodData[toolName]) return;

        const toolData = methodData[toolName];

        Object.keys(toolData).forEach(criterion => {
            const score = toolData[criterion];
            const buttonGroup = card.querySelector(`[data-criterion="${criterion}"]`);
            if (buttonGroup) {
                const button = buttonGroup.querySelector(`[data-score="${score}"]`);
                if (button) {
                    button.classList.add('selected');
                }
            }
        });

        this.updateTotalScore(card, methodId, toolName);
    }

    updateTotalScore(card, methodId, toolName) {
        const methodData = this.evaluationData[methodId];
        if (!methodData || !methodData[toolName]) return;

        const toolData = methodData[toolName];
        const scores = Object.values(toolData);

        if (scores.length === 4) {
            const total = scores.reduce((sum, score) => sum + score, 0);
            const totalElement = card.querySelector(`[data-method="${methodId}"][data-tool="${toolName}"] .total-value`);
            if (totalElement) {
                totalElement.textContent = `${total}/12`;
                totalElement.parentElement.style.background = this.getScoreColor(total);
            }
        }
    }

    getScoreColor(score) {
        if (score >= 10) return '#d4edda';
        if (score >= 7) return '#fff3cd';
        return '#f8d7da';
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    showError(message) {
        const container = document.getElementById('testCasesContainer');
        container.innerHTML = `
            <div class="loading-message">
                <i class="fas fa-exclamation-triangle" style="color: #dc3545;"></i>
                <p style="color: #dc3545;">${message}</p>
            </div>
        `;
    }

    generateSummaryReport() {
        const tools = ['Method_A', 'Method_B', 'Method_C', 'Method_D'];
        const summary = {};

        tools.forEach(tool => {
            const scores = [];
            this.testMethods.forEach(method => {
                const methodData = this.evaluationData[method.id];
                if (methodData && methodData[tool] && Object.keys(methodData[tool]).length === 4) {
                    const toolScores = Object.values(methodData[tool]);
                    scores.push(toolScores.reduce((sum, score) => sum + score, 0));
                }
            });

            if (scores.length > 0) {
                summary[tool] = {
                    count: scores.length,
                    average: (scores.reduce((sum, score) => sum + score, 0) / scores.length).toFixed(2),
                    min: Math.min(...scores),
                    max: Math.max(...scores)
                };
            } else {
                summary[tool] = { count: 0, average: 0, min: 0, max: 0 };
            }
        });

        return summary;
    }
}

// 在线版本的样式
const onlineStyles = `
.online-notice {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    color: white;
    padding: 10px;
    text-align: center;
    z-index: 1000;
    font-size: 14px;
}

.notice-content {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
}

.sync-status {
    position: fixed;
    bottom: 20px;
    right: 20px;
    padding: 10px 15px;
    border-radius: 6px;
    font-size: 14px;
    z-index: 1000;
    transition: opacity 0.3s ease;
}

.sync-status.success {
    background: #d4edda;
    color: #155724;
    border: 1px solid #c3e6cb;
}

.sync-status.error {
    background: #f8d7da;
    color: #721c24;
    border: 1px solid #f5c6cb;
}

.thank-you-page {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
}

.thank-you-content {
    background: white;
    padding: 60px;
    border-radius: 12px;
    text-align: center;
    box-shadow: 0 10px 30px rgba(0,0,0,0.3);
}

.thank-you-content i {
    font-size: 64px;
    color: #28a745;
    margin-bottom: 20px;
}

.thank-you-content h1 {
    color: #333;
    margin-bottom: 20px;
}

.thank-you-content p {
    color: #666;
    margin-bottom: 15px;
    font-size: 16px;
}

.restart-btn {
    background: #667eea;
    color: white;
    border: none;
    padding: 12px 24px;
    border-radius: 6px;
    font-size: 16px;
    cursor: pointer;
    margin-top: 20px;
    transition: background 0.3s ease;
}

.restart-btn:hover {
    background: #5a67d8;
}
`;

// 添加在线样式
const styleSheet = document.createElement('style');
styleSheet.textContent = onlineStyles;
document.head.appendChild(styleSheet);

// 初始化在线系统
document.addEventListener('DOMContentLoaded', () => {
    new OnlineTestCaseEvaluationSystem();
});
