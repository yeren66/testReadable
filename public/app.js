// 测试用例可读性分析评估系统
class TestCaseEvaluationSystem {
    constructor() {
        this.testMethods = [];
        this.currentMethodIndex = 0;
        this.evaluationData = {};
        this.testCaseFiles = {};
        
        this.init();
    }

    async init() {
        await this.loadTestCaseStructure();
        this.setupEventListeners();
        this.loadEvaluationData();
        this.displayCurrentMethod();
        this.updateStats();
    }

    // 加载测试用例结构
    async loadTestCaseStructure() {
        try {
            // 使用嵌入在HTML中的测试方法数据
            if (window.TEST_METHODS_DATA && Array.isArray(window.TEST_METHODS_DATA)) {
                this.testMethods = window.TEST_METHODS_DATA;
                console.log('已加载测试方法数据:', this.testMethods.length, '个方法');
            } else {
                throw new Error('未找到嵌入的测试方法数据 (window.TEST_METHODS_DATA)');
            }

            // 使用嵌入在HTML中的测试用例数据
            if (window.TEST_CASES_DATA && typeof window.TEST_CASES_DATA === 'object') {
                this.testCaseFiles = {};

                // 数据格式: {"Method_A": {"method_id": "test_content", ...}, ...}
                for (const toolName of Object.keys(window.TEST_CASES_DATA)) {
                    const toolData = window.TEST_CASES_DATA[toolName];

                    // 遍历每个工具的方法数据
                    for (const methodId of Object.keys(toolData)) {
                        if (!this.testCaseFiles[methodId]) {
                            this.testCaseFiles[methodId] = {};
                        }
                        this.testCaseFiles[methodId][toolName] = toolData[methodId];
                    }
                }

                console.log('已加载测试用例数据:', Object.keys(this.testCaseFiles).length, '个方法的测试用例');
                console.log('可用的工具:', Object.keys(window.TEST_CASES_DATA));
                console.log('示例方法数据:', Object.keys(this.testCaseFiles).slice(0, 3));
            } else {
                throw new Error('未找到嵌入的测试用例数据 (window.TEST_CASES_DATA)');
            }

        } catch (error) {
            console.error('加载测试用例结构失败:', error);
            this.showError('无法加载测试用例结构: ' + error.message);
        }
    }



    // 设置事件监听器
    setupEventListeners() {
        // 导航按钮
        document.getElementById('prevBtn').addEventListener('click', () => this.previousMethod());
        document.getElementById('nextBtn').addEventListener('click', () => this.nextMethod());
        
        // 操作按钮
        document.getElementById('submitBtn').addEventListener('click', () => this.submitEvaluation());
        document.getElementById('exportBtn').addEventListener('click', () => this.exportResults());
        document.getElementById('resetBtn').addEventListener('click', () => this.resetEvaluations());
        
        // 键盘导航
        document.addEventListener('keydown', (e) => {
            if (e.key === 'ArrowLeft' && !document.getElementById('prevBtn').disabled) {
                this.previousMethod();
            } else if (e.key === 'ArrowRight' && !document.getElementById('nextBtn').disabled) {
                this.nextMethod();
            }
        });
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
        

    }

    // 显示测试用例
    displayTestCases(method) {
        const container = document.getElementById('testCasesContainer');
        container.innerHTML = '';

        // 动态获取可用的工具列表并随机打乱顺序
        const availableTools = [];
        if (this.testCaseFiles[method.id]) {
            const methodData = this.testCaseFiles[method.id];
            const toolNames = Object.keys(methodData);

            console.log(`方法 ${method.id} 的原始工具数据:`, toolNames);

            // 固定的工具映射关系 - 基于数据中实际的工具名称
            const fixedToolMapping = {
                'Method_A': { displayName: '方法 A (EvoSuite)', badge: 'method-a', anonymousName: 'Tool_1' },
                'Method_B': { displayName: '方法 B (ChatUniTest)', badge: 'method-b', anonymousName: 'Tool_2' },
                'Method_C': { displayName: '方法 C (HITS)', badge: 'method-c', anonymousName: 'Tool_3' },
                'Method_D': { displayName: '方法 D (TestAgent)', badge: 'method-d', anonymousName: 'Tool_4' }
            };

            // 保存每个方法的工具映射关系，用于正确的评分统计
            if (!this.methodToolMappings) {
                this.methodToolMappings = {};
            }
            this.methodToolMappings[method.id] = {};

            // 按固定顺序处理工具 - 确保A、B、C、D的顺序
            const orderedToolNames = ['Method_A', 'Method_B', 'Method_C', 'Method_D'].filter(toolName =>
                toolNames.includes(toolName)
            );

            orderedToolNames.forEach(originalToolName => {
                const mapping = fixedToolMapping[originalToolName];
                if (mapping) {
                    // 保存匿名标识到原始工具名的映射
                    this.methodToolMappings[method.id][mapping.anonymousName] = originalToolName;

                    availableTools.push({
                        name: mapping.anonymousName,  // 使用匿名标识作为内部名称
                        originalName: originalToolName,  // 保存原始名称
                        displayName: mapping.displayName,
                        badge: mapping.badge
                    });
                }
            });
        }

        console.log(`方法 ${method.id} 的工具映射:`, this.methodToolMappings[method.id]);

        availableTools.forEach(tool => {
            const testCaseContent = this.testCaseFiles[method.id][tool.originalName];
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

    // 数组随机打乱函数
    shuffleArray(array) {
        const shuffled = [...array];
        for (let i = shuffled.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]];
        }
        return shuffled;
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
            Prism.highlightAllUnder(card);
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
                });
            });
        });
        
        // 加载已有评分
        this.loadExistingScores(card, methodId, toolName);
    }

    // 保存评分
    saveEvaluation(methodId, toolName, criterion, score) {
        if (!this.evaluationData[methodId]) {
            this.evaluationData[methodId] = {};
        }
        if (!this.evaluationData[methodId][toolName]) {
            this.evaluationData[methodId][toolName] = {};
        }

        this.evaluationData[methodId][toolName][criterion] = score;

        // 保存评分数据和工具映射到localStorage
        localStorage.setItem('testCaseEvaluations', JSON.stringify(this.evaluationData));
        localStorage.setItem('methodToolMappings', JSON.stringify(this.methodToolMappings || {}));
    }

    // 加载评估数据
    loadEvaluationData() {
        // 加载评分数据
        const saved = localStorage.getItem('testCaseEvaluations');
        if (saved) {
            try {
                this.evaluationData = JSON.parse(saved);
            } catch (error) {
                console.error('加载评估数据失败:', error);
                this.evaluationData = {};
            }
        }

        // 加载工具映射数据
        const savedMappings = localStorage.getItem('methodToolMappings');
        if (savedMappings) {
            try {
                this.methodToolMappings = JSON.parse(savedMappings);
            } catch (error) {
                console.error('加载工具映射数据失败:', error);
                this.methodToolMappings = {};
            }
        } else {
            this.methodToolMappings = {};
        }
    }

    // 加载已有评分
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

    // 更新总分
    updateTotalScore(card, methodId, toolName) {
        const methodData = this.evaluationData[methodId];
        if (!methodData || !methodData[toolName]) return;
        
        const toolData = methodData[toolName];
        const scores = Object.values(toolData);
        
        if (scores.length === 4) { // 所有四个维度都已评分
            const total = scores.reduce((sum, score) => sum + score, 0);
            const totalElement = card.querySelector(`[data-method="${methodId}"][data-tool="${toolName}"] .total-value`);
            if (totalElement) {
                totalElement.textContent = `${total}/12`;
                totalElement.parentElement.style.background = this.getScoreColor(total);
            }
        }
    }

    // 根据分数获取颜色
    getScoreColor(score) {
        if (score >= 10) return '#d4edda'; // 绿色
        if (score >= 7) return '#fff3cd';  // 黄色
        return '#f8d7da'; // 红色
    }

    // HTML转义
    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }

    // 显示错误信息
    showError(message) {
        const container = document.getElementById('testCasesContainer');
        container.innerHTML = `
            <div class="loading-message">
                <i class="fas fa-exclamation-triangle" style="color: #dc3545;"></i>
                <p style="color: #dc3545;">${message}</p>
            </div>
        `;
    }

    // 导航方法
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

    // 更新统计信息
    updateStats() {
        const evaluationStatus = this.getEvaluationStatus();
        const totalMethods = this.testMethods.length;
        let evaluatedMethods = 0;
        let totalEvaluations = 0;

        this.testMethods.forEach(method => {
            const methodData = this.evaluationData[method.id];
            const toolMapping = this.methodToolMappings?.[method.id] || {};
            const expectedTools = Object.keys(toolMapping);

            if (methodData && expectedTools.length > 0) {
                // 检查是否所有工具都已完成评分（每个工具需要4个评分维度）
                const allToolsEvaluated = expectedTools.every(tool => {
                    const toolData = methodData[tool];
                    return toolData && Object.keys(toolData).length === 4;
                });

                if (allToolsEvaluated) {
                    evaluatedMethods++;
                }

                // 计算总评分数
                expectedTools.forEach(tool => {
                    const toolData = methodData[tool];
                    if (toolData) {
                        totalEvaluations += Object.keys(toolData).length;
                    }
                });
            }
        });

        const progress = totalMethods > 0 ? Math.round((evaluatedMethods / totalMethods) * 100) : 0;

        document.getElementById('totalMethods').textContent = totalMethods;
        document.getElementById('evaluatedMethods').textContent = evaluatedMethods;
        document.getElementById('progressPercent').textContent = `${progress}%`;

        // 更新底部统计栏
        this.updateStatsBar(evaluationStatus, progress, totalEvaluations);
    }

    // 更新底部统计栏
    updateStatsBar(evaluationStatus, progressPercent, totalEvaluations) {
        const overallProgressElement = document.getElementById('overallProgress');
        const completedCountElement = document.getElementById('completedCount');
        const incompleteCountElement = document.getElementById('incompleteCount');
        const notStartedCountElement = document.getElementById('notStartedCount');
        const totalEvaluationsElement = document.getElementById('totalEvaluations');

        if (overallProgressElement) {
            overallProgressElement.textContent = `${progressPercent}%`;
        }
        if (completedCountElement) {
            completedCountElement.textContent = evaluationStatus.completed.length;
        }
        if (incompleteCountElement) {
            incompleteCountElement.textContent = evaluationStatus.incomplete.length;
        }
        if (notStartedCountElement) {
            notStartedCountElement.textContent = evaluationStatus.notStarted.length;
        }
        if (totalEvaluationsElement) {
            totalEvaluationsElement.textContent = totalEvaluations;
        }
    }



    // 检查评分状态
    getEvaluationStatus() {
        const notStarted = [];      // 未开始评分的方法
        const incomplete = [];      // 部分完成的方法
        const completed = [];       // 完全完成的方法

        for (const method of this.testMethods) {
            const methodData = this.evaluationData[method.id];
            if (!methodData) {
                notStarted.push(method.id);
                continue;
            }

            // 检查该方法的所有工具是否都已评分
            const toolMapping = this.methodToolMappings[method.id];
            if (!toolMapping) {
                notStarted.push(method.id);
                continue;
            }

            let hasIncompleteEvaluation = false;
            let hasAnyEvaluation = false;

            for (const toolId in toolMapping) {
                const toolData = methodData[toolId];
                if (!toolData || Object.keys(toolData).length === 0) {
                    hasIncompleteEvaluation = true;
                    continue;
                }

                hasAnyEvaluation = true;

                // 检查是否所有评分维度都已完成
                const requiredCriteria = ['naming', 'layout', 'assertion', 'migration'];
                for (const criterion of requiredCriteria) {
                    if (!toolData[criterion] || toolData[criterion] === 0) {
                        hasIncompleteEvaluation = true;
                        break;
                    }
                }
                // 不要在这里break，需要检查所有工具
            }

            if (!hasAnyEvaluation) {
                notStarted.push(method.id);
            } else if (hasIncompleteEvaluation) {
                incomplete.push(method.id);
            } else {
                completed.push(method.id);
            }
        }

        return {
            notStarted,
            incomplete,
            completed,
            totalUnevaluated: notStarted.length + incomplete.length
        };
    }

    // 检查未评分的方法（向后兼容）
    checkUnevaluatedMethods() {
        const status = this.getEvaluationStatus();
        return [...status.notStarted, ...status.incomplete];
    }

    // 提交评分到后台
    async submitEvaluation() {
        const submitBtn = document.getElementById('submitBtn');

        // 检查是否有评分数据
        if (Object.keys(this.evaluationData).length === 0) {
            alert('请先完成一些评分再提交！');
            return;
        }

        // 检查评分状态
        const evaluationStatus = this.getEvaluationStatus();
        const unevaluatedMethods = [...evaluationStatus.notStarted, ...evaluationStatus.incomplete];

        if (unevaluatedMethods.length > 0) {
            let message = `评分状态统计：\n`;
            message += `• 已完成: ${evaluationStatus.completed.length} 个方法\n`;
            message += `• 部分完成: ${evaluationStatus.incomplete.length} 个方法\n`;
            message += `• 未开始: ${evaluationStatus.notStarted.length} 个方法\n\n`;

            message += `还有 ${unevaluatedMethods.length} 个方法未完成评分：\n\n`;

            if (unevaluatedMethods.length <= 3) {
                // 如果未评分方法少于等于3个，列出具体方法名
                message += unevaluatedMethods.map(name => `• ${name}`).join('\n');
            } else {
                // 如果超过3个，只显示前3个并说明总数
                message += unevaluatedMethods.slice(0, 3).map(name => `• ${name}`).join('\n');
                message += `\n... 还有 ${unevaluatedMethods.length - 3} 个方法`;
            }

            message += '\n\n是否继续提交已完成的评分？';

            if (!confirm(message)) {
                return;
            }
        }

        // 禁用按钮并显示加载状态
        const originalText = submitBtn.innerHTML;
        submitBtn.disabled = true;
        submitBtn.innerHTML = '<i class="fas fa-spinner fa-spin"></i> 提交中...';

        try {
            const submissionData = {
                evaluationData: this.evaluationData,
                methodToolMappings: this.methodToolMappings || {},
                metadata: {
                    totalMethods: this.testMethods.length,
                    completedMethods: evaluationStatus.completed.length,
                    incompleteMethods: evaluationStatus.incomplete.length,
                    notStartedMethods: evaluationStatus.notStarted.length,
                    evaluatedMethods: Object.keys(this.evaluationData).length, // 已开始评分的方法数
                    unevaluatedMethods: unevaluatedMethods.length, // 未完成评分的方法数
                    timestamp: new Date().toISOString(),
                    userAgent: navigator.userAgent
                }
            };

            // 检测环境并使用正确的API端点
            const apiUrl = window.location.hostname === 'localhost' && window.location.port === '3000'
                ? '/api/submit-evaluation'  // 本地测试服务器
                : '/api/submit-evaluation'; // Vercel部署环境

            const response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(submissionData)
            });

            if (!response.ok) {
                throw new Error(`HTTP ${response.status}: ${response.statusText}`);
            }

            const result = await response.json();

            if (result.success) {
                const completionRate = (evaluationStatus.completed.length / this.testMethods.length * 100).toFixed(1);
                const startedRate = ((evaluationStatus.completed.length + evaluationStatus.incomplete.length) / this.testMethods.length * 100).toFixed(1);

                let statusMessage = `✅ ${result.message}\n\n`;
                statusMessage += `提交ID: ${result.submissionId}\n`;
                statusMessage += `提交时间: ${new Date(result.timestamp).toLocaleString()}\n\n`;
                statusMessage += `📊 评分统计:\n`;
                statusMessage += `• 完全完成: ${evaluationStatus.completed.length}/${this.testMethods.length} (${completionRate}%)\n`;
                statusMessage += `• 部分完成: ${evaluationStatus.incomplete.length}/${this.testMethods.length}\n`;
                statusMessage += `• 未开始: ${evaluationStatus.notStarted.length}/${this.testMethods.length}\n`;
                statusMessage += `• 总体进度: ${startedRate}%`;

                alert(statusMessage);

                // 保存到本地历史记录
                this.saveToLocalHistory(result, evaluationStatus, submissionData);

                // 提交成功后可以选择清除本地数据
                if (confirm('提交成功！是否清除本地评分数据？')) {
                    this.resetEvaluations();
                }
            } else {
                throw new Error(result.error || '提交失败');
            }

        } catch (error) {
            console.error('提交评分失败:', error);
            alert(`❌ 提交失败: ${error.message}\n\n请检查网络连接或稍后重试。`);
        } finally {
            // 恢复按钮状态
            submitBtn.disabled = false;
            submitBtn.innerHTML = originalText;
        }
    }

    // 保存到本地历史记录
    saveToLocalHistory(response, evaluationStatus, submissionData) {
        try {
            const historyEntry = {
                id: response.submissionId,
                timestamp: response.timestamp,
                completedMethods: evaluationStatus.completed.length,
                incompleteMethods: evaluationStatus.incomplete.length,
                notStartedMethods: evaluationStatus.notStarted.length,
                totalMethods: this.testMethods.length,
                totalEvaluations: Object.values(submissionData.evaluationData).reduce((sum, methodData) => {
                    return sum + Object.values(methodData).reduce((methodSum, toolData) => {
                        return methodSum + Object.keys(toolData).length;
                    }, 0);
                }, 0),
                submissionData: submissionData // 保存完整的提交数据
            };

            // 获取现有历史记录
            const history = JSON.parse(localStorage.getItem('submissionHistory') || '[]');

            // 添加新记录
            history.push(historyEntry);

            // 保存回localStorage（限制最多保存50条记录）
            if (history.length > 50) {
                history.shift(); // 移除最旧的记录
            }

            localStorage.setItem('submissionHistory', JSON.stringify(history));

            console.log('已保存到本地历史记录:', historyEntry.id);
        } catch (error) {
            console.error('保存本地历史记录失败:', error);
        }
    }

    // 导出结果
    exportResults() {
        // 检查评分状态并提醒未完成的题目
        const evaluationStatus = this.getEvaluationStatus();
        const unevaluatedMethods = [...evaluationStatus.notStarted, ...evaluationStatus.incomplete];

        if (unevaluatedMethods.length > 0) {
            // 获取题号（基于方法在数组中的索引+1）
            const getQuestionNumber = (methodName) => {
                const index = this.testMethods.findIndex(method => method.id === methodName);
                return index !== -1 ? index + 1 : '未知';
            };

            let message = `📊 评分状态统计：\n`;
            message += `• 已完成: ${evaluationStatus.completed.length} 题\n`;
            message += `• 部分完成: ${evaluationStatus.incomplete.length} 题\n`;
            message += `• 未开始: ${evaluationStatus.notStarted.length} 题\n\n`;

            if (evaluationStatus.notStarted.length > 0) {
                message += `❌ 未开始的题目：\n`;
                const notStartedNumbers = evaluationStatus.notStarted.map(name => `第${getQuestionNumber(name)}题`);
                if (notStartedNumbers.length <= 10) {
                    message += notStartedNumbers.join('、') + '\n\n';
                } else {
                    message += notStartedNumbers.slice(0, 10).join('、') + `... 等${notStartedNumbers.length}题\n\n`;
                }
            }

            if (evaluationStatus.incomplete.length > 0) {
                message += `⚠️ 部分完成的题目：\n`;
                const incompleteNumbers = evaluationStatus.incomplete.map(name => `第${getQuestionNumber(name)}题`);
                if (incompleteNumbers.length <= 10) {
                    message += incompleteNumbers.join('、') + '\n\n';
                } else {
                    message += incompleteNumbers.slice(0, 10).join('、') + `... 等${incompleteNumbers.length}题\n\n`;
                }
            }

            message += `是否继续导出当前已完成的评分结果？`;

            if (!confirm(message)) {
                return;
            }
        }

        const results = {
            timestamp: new Date().toISOString(),
            totalMethods: this.testMethods.length,
            evaluationData: this.evaluationData,
            methodToolMappings: this.methodToolMappings, // 包含工具映射信息
            summary: this.generateSummaryReport(),
            evaluationStatus: {
                completed: evaluationStatus.completed.length,
                incomplete: evaluationStatus.incomplete.length,
                notStarted: evaluationStatus.notStarted.length,
                completedQuestions: evaluationStatus.completed.map(name => {
                    const index = this.testMethods.findIndex(method => method.id === name);
                    return index !== -1 ? index + 1 : '未知';
                }),
                incompleteQuestions: evaluationStatus.incomplete.map(name => {
                    const index = this.testMethods.findIndex(method => method.id === name);
                    return index !== -1 ? index + 1 : '未知';
                }),
                notStartedQuestions: evaluationStatus.notStarted.map(name => {
                    const index = this.testMethods.findIndex(method => method.id === name);
                    return index !== -1 ? index + 1 : '未知';
                })
            },
            note: "methodToolMappings shows the mapping from anonymous tool names (Tool_1, Tool_2, etc.) to original tool names (Method_A, Method_B, etc.) for each method. evaluationStatus shows question numbers for different completion states."
        };

        const blob = new Blob([JSON.stringify(results, null, 2)], { type: 'application/json' });
        const url = URL.createObjectURL(blob);
        const a = document.createElement('a');
        a.href = url;
        a.download = `test_case_evaluation_${new Date().toISOString().split('T')[0]}.json`;
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
        URL.revokeObjectURL(url);

        // 显示导出成功信息，包含完成状态
        let successMessage = '✅ 评估结果已导出！\n\n';
        successMessage += `📊 本次导出包含：\n`;
        successMessage += `• 已完成评分: ${evaluationStatus.completed.length} 题\n`;
        successMessage += `• 部分完成评分: ${evaluationStatus.incomplete.length} 题\n`;
        successMessage += `• 总计: ${evaluationStatus.completed.length + evaluationStatus.incomplete.length}/${this.testMethods.length} 题`;

        alert(successMessage);
    }

    // 生成汇总报告
    generateSummaryReport() {
        // 按原始工具名称统计，而不是按匿名标识
        const originalToolStats = {};

        this.testMethods.forEach(method => {
            const methodData = this.evaluationData[method.id];
            const toolMapping = this.methodToolMappings?.[method.id] || {};

            if (methodData) {
                // 遍历每个匿名工具标识
                Object.keys(toolMapping).forEach(anonymousTool => {
                    const originalToolName = toolMapping[anonymousTool];
                    const toolData = methodData[anonymousTool];

                    if (toolData && Object.keys(toolData).length === 4) {
                        if (!originalToolStats[originalToolName]) {
                            originalToolStats[originalToolName] = [];
                        }

                        const toolScores = Object.values(toolData);
                        const totalScore = toolScores.reduce((sum, score) => sum + score, 0);
                        originalToolStats[originalToolName].push(totalScore);
                    }
                });
            }
        });

        // 计算每个原始工具的统计信息
        const summary = {};
        Object.keys(originalToolStats).forEach(originalTool => {
            const scores = originalToolStats[originalTool];
            if (scores.length > 0) {
                summary[originalTool] = {
                    count: scores.length,
                    average: (scores.reduce((sum, score) => sum + score, 0) / scores.length).toFixed(2),
                    min: Math.min(...scores),
                    max: Math.max(...scores)
                };
            } else {
                summary[originalTool] = { count: 0, average: 0, min: 0, max: 0 };
            }
        });

        return summary;
    }

    // 重置评估
    resetEvaluations() {
        if (confirm('确定要重置所有评分吗？此操作不可撤销。')) {
            this.evaluationData = {};
            this.methodToolMappings = {};
            localStorage.removeItem('testCaseEvaluations');
            localStorage.removeItem('methodToolMappings');
            this.displayCurrentMethod();
            this.updateStats();
            alert('所有评分已重置！');
        }
    }
}

// 模态框控制函数
function openCriteriaModal() {
    document.getElementById('criteriaModal').style.display = 'block';
}

function closeCriteriaModal() {
    document.getElementById('criteriaModal').style.display = 'none';
}

// 点击模态框外部关闭
window.onclick = function(event) {
    const modal = document.getElementById('criteriaModal');
    if (event.target === modal) {
        modal.style.display = 'none';
    }
}

// 初始化系统
document.addEventListener('DOMContentLoaded', () => {
    new TestCaseEvaluationSystem();
});
