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
            // 模拟从test_resource目录读取文件结构
            // 在实际部署时，需要预处理生成文件列表
            const methods = [
                'chart_compareTo', 'chart_createWindPlot', 'chart_getHeight', 'chart_getLeft',
                'chart_getPaint', 'chart_getRadius', 'chart_getType', 'chart_getY',
                'chart_isBaseline', 'chart_isLeft', 'chart_isMultiple', 'chart_isTopOrBottom',
                'chart_isVerticalCenter', 'chart_javascriptEscape', 'chart_overlaps',
                'chart_setPaint', 'chart_setPoint', 'chart_transform', 'chart_trimWidth',
                'chart_windowActivated', 'cli_clone', 'cli_createClass', 'cli_createObject',
                'cli_createURL', 'cli_getArgList', 'cli_getDescription', 'cli_getLeftPadding',
                'cli_getLongOptSeparator', 'cli_getMissingOptions', 'cli_getOptionComparator',
                'cli_getValueClass', 'cli_getValueSeparator', 'cli_getValues', 'cli_getWidth',
                'cli_hasArgName', 'cli_hasLongOpt', 'cli_hasValueSeparator', 'cli_hashCode',
                'cli_isValueCode', 'cli_iterator', 'cli_numberOfArgs', 'cli_optionalArg',
                'cli_setOptionComparator', 'cli_type', 'cli_withArgName',
                'csv_getAllowDuplicateHeaderNames', 'csv_getCharacterPosition', 'csv_getComment',
                'csv_getCommentMarker', 'csv_getDelimiter', 'csv_getEscapeCharacter',
                'csv_getHeaderComments', 'csv_getIgnoreHeaderCase', 'csv_getNullString',
                'csv_getQuoteCharacter', 'csv_getTrailerComment', 'csv_getTrailingDelimiter',
                'csv_hasComment', 'csv_hasHeaderComment', 'csv_hasTrailerComment',
                'csv_isEscapeCharacterSet', 'csv_isMapped', 'csv_isNullStringSet',
                'csv_isQuoteCharacterSet', 'csv_newFormat', 'csv_setAutoFlush',
                'csv_setQuoteMode', 'csv_toList', 'csv_valueOf', 'csv_withDelimiter',
                'csv_withFirstRecordAsHeader', 'csv_withNullString',
                'gson_createExceptionForUnexpectedIllegalAccess', 'gson_disableHtmlEscaping',
                'gson_disableJdkUnsafe', 'gson_getAccessibleObjectDescription', 'gson_getType',
                'gson_isAnonymousOrNonStaticLocal', 'gson_isJavaType', 'gson_isPrimitive',
                'gson_isString', 'gson_setFieldNamingPolicy', 'gson_setLongSerializationPolicy',
                'gson_setObjectToNumberStrategy', 'gson_setVersion', 'gson_unwrap',
                'gson_withExclusionStrategy', 'gson_withSpaceAfterSeparators',
                'lang_availableLocaleSet', 'lang_binaryToByte', 'lang_booleanValue',
                'lang_byteToBinary', 'lang_byteToHex', 'lang_byteValue', 'lang_getHostName',
                'lang_hexDigitMsb0ToBinary', 'lang_hexDigitMsb0ToInt', 'lang_hexDigitToBinary',
                'lang_intArrayToLong', 'lang_intToBinary', 'lang_intToHex', 'lang_intToHexDigit',
                'lang_intToHexDigitMsb0', 'lang_isFalse', 'lang_isInfinite',
                'lang_isJavaVersionAtLeast', 'lang_isTrue', 'lang_longToHex', 'lang_setTrue',
                'lang_toBoolean', 'ruler_absencePatterns', 'ruler_anythingButNumbersMatch',
                'ruler_entries', 'ruler_existencePatterns', 'ruler_findPattern', 'ruler_getBytes',
                'ruler_getId', 'ruler_getKey', 'ruler_getMultiBytes', 'ruler_getNameState',
                'ruler_getNextState', 'ruler_getParser', 'ruler_getPattern', 'ruler_is',
                'ruler_isGreaterThan', 'ruler_lessThanOrEqualTo', 'ruler_prefixMatch', 'ruler_singular'
            ];

            this.testMethods = methods.map(method => {
                const [project, methodName] = method.split('_', 2);
                return {
                    id: method,
                    project: project,
                    methodName: methodName,
                    fullName: `${project}_${methodName}`
                };
            });

            // 预加载所有测试用例文件
            await this.preloadTestCaseFiles();
            
        } catch (error) {
            console.error('加载测试用例结构失败:', error);
            this.showError('无法加载测试用例结构，请确保test_resource目录存在且包含测试文件。');
        }
    }

    // 预加载测试用例文件
    async preloadTestCaseFiles() {
        const tools = ['ChatUniTest_Test', 'TestAgent_Test', 'EvoSuite_Test', 'HITS_Test'];
        
        for (const method of this.testMethods) {
            this.testCaseFiles[method.id] = {};
            
            for (const tool of tools) {
                try {
                    const response = await fetch(`test_resource/${tool}/${method.id}.java`);
                    if (response.ok) {
                        this.testCaseFiles[method.id][tool] = await response.text();
                    } else {
                        this.testCaseFiles[method.id][tool] = null;
                    }
                } catch (error) {
                    console.warn(`无法加载 ${tool}/${method.id}.java:`, error);
                    this.testCaseFiles[method.id][tool] = null;
                }
            }
        }
    }

    // 设置事件监听器
    setupEventListeners() {
        // 导航按钮
        document.getElementById('prevBtn').addEventListener('click', () => this.previousMethod());
        document.getElementById('nextBtn').addEventListener('click', () => this.nextMethod());
        
        // 操作按钮
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
                    this.updateEvaluationSummary(this.testMethods[this.currentMethodIndex]);
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
        
        // 保存到localStorage
        localStorage.setItem('testCaseEvaluations', JSON.stringify(this.evaluationData));
    }

    // 加载评估数据
    loadEvaluationData() {
        const saved = localStorage.getItem('testCaseEvaluations');
        if (saved) {
            try {
                this.evaluationData = JSON.parse(saved);
            } catch (error) {
                console.error('加载评估数据失败:', error);
                this.evaluationData = {};
            }
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

    // 更新评估汇总
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

    // 导出结果
    exportResults() {
        const results = {
            timestamp: new Date().toISOString(),
            totalMethods: this.testMethods.length,
            evaluationData: this.evaluationData,
            summary: this.generateSummaryReport()
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
        
        alert('评估结果已导出！');
    }

    // 生成汇总报告
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

    // 重置评估
    resetEvaluations() {
        if (confirm('确定要重置所有评分吗？此操作不可撤销。')) {
            this.evaluationData = {};
            localStorage.removeItem('testCaseEvaluations');
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
