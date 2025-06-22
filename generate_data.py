#!/usr/bin/env python3
"""
生成测试用例评估系统所需的数据文件
"""

import json
import shutil
import random
from pathlib import Path

def anonymize_test_cases(file_structure, methods):
    """匿名化测试用例，随机分配工具标识"""
    tools = list(file_structure.keys())
    anonymized = {}

    # 为每个方法创建匿名化的测试用例
    for method in methods:
        # 获取该方法的所有测试用例
        test_cases = []
        for tool in tools:
            if method in file_structure[tool] and file_structure[tool][method]:
                test_cases.append({
                    'original_tool': tool,
                    'content': file_structure[tool][method]
                })

        # 随机打乱测试用例顺序并分配匿名标识
        random.shuffle(test_cases)

        # 分配匿名标识 (Method_A, Method_B, Method_C, Method_D)
        anonymous_labels = ['Method_A', 'Method_B', 'Method_C', 'Method_D']

        for i, test_case in enumerate(test_cases):
            if i < len(anonymous_labels):
                label = anonymous_labels[i]
                if label not in anonymized:
                    anonymized[label] = {}
                anonymized[label][method] = test_case['content']

    return anonymized

def generate_file_structure():
    """生成测试用例文件结构"""
    test_resource_path = Path("test_resource")

    if not test_resource_path.exists():
        print("错误: test_resource 目录不存在")
        return False

    # 工具目录 - 现在包含所有四个工具
    tools = ["ChatUniTest_Test", "TestAgent_Test", "EvoSuite_Test", "HITS_Test"]

    # 收集每个工具的测试方法
    tool_methods = {}
    file_structure = {}

    for tool in tools:
        tool_path = test_resource_path / tool
        if tool_path.exists():
            file_structure[tool] = {}
            tool_methods[tool] = set()

            for java_file in tool_path.glob("*.java"):
                method_name = java_file.stem
                tool_methods[tool].add(method_name)

                # 读取文件内容
                try:
                    with open(java_file, 'r', encoding='utf-8') as f:
                        content = f.read()
                    file_structure[tool][method_name] = content
                except Exception as e:
                    print(f"警告: 无法读取文件 {java_file}: {e}")
                    file_structure[tool][method_name] = None

            print(f"工具 {tool}: 找到 {len(tool_methods[tool])} 个测试方法")
        else:
            print(f"警告: 工具目录 {tool} 不存在")
            file_structure[tool] = {}
            tool_methods[tool] = set()

    # 找到所有工具都有的测试方法（交集）
    if tool_methods:
        common_methods = set.intersection(*tool_methods.values())
        print(f"所有工具都有的测试方法: {len(common_methods)} 个")

        # 移除缺失的方法
        missing_methods = set()
        for tool in tools:
            all_methods = tool_methods[tool]
            missing_in_tool = all_methods - common_methods
            if missing_in_tool:
                missing_methods.update(missing_in_tool)

        if missing_methods:
            print(f"移除缺失的测试方法: {len(missing_methods)} 个")
            for method in sorted(missing_methods):
                print(f"  - {method}")
    else:
        common_methods = set()

    # 只保留所有工具都有的方法
    filtered_file_structure = {}
    for tool in tools:
        filtered_file_structure[tool] = {}
        for method in common_methods:
            if method in file_structure[tool]:
                filtered_file_structure[tool][method] = file_structure[tool][method]

    # 生成方法列表
    methods_list = []
    for method in sorted(common_methods):
        if '_' in method:
            project, method_name = method.split('_', 1)
            methods_list.append({
                'id': method,
                'project': project,
                'methodName': method_name,
                'fullName': method
            })

    # 保存数据文件
    data_dir = Path("data")
    data_dir.mkdir(exist_ok=True)

    # 保存方法列表
    with open(data_dir / "methods.json", 'w', encoding='utf-8') as f:
        json.dump(methods_list, f, ensure_ascii=False, indent=2)

    # 保存文件结构（匿名化）
    anonymized_structure = anonymize_test_cases(filtered_file_structure, common_methods)
    with open(data_dir / "test_cases.json", 'w', encoding='utf-8') as f:
        json.dump(anonymized_structure, f, ensure_ascii=False, indent=2)

    print(f"成功生成数据文件:")
    print(f"- 总共 {len(methods_list)} 个测试方法")
    print(f"- 数据文件保存在 data/ 目录")

    return True

def copy_test_files():
    """复制测试文件到web可访问的位置"""
    test_resource_path = Path("test_resource")
    web_test_path = Path("web_test_resource")
    
    if web_test_path.exists():
        shutil.rmtree(web_test_path)
    
    if test_resource_path.exists():
        shutil.copytree(test_resource_path, web_test_path)
        print(f"测试文件已复制到 {web_test_path}")
        return True
    else:
        print("错误: test_resource 目录不存在")
        return False

def generate_index_with_data():
    """生成包含数据的index.html文件"""
    # 读取原始index.html
    with open("index.html", 'r', encoding='utf-8') as f:
        html_content = f.read()
    
    # 读取生成的数据
    try:
        with open("data/methods.json", 'r', encoding='utf-8') as f:
            methods_data = json.load(f)
        
        with open("data/test_cases.json", 'r', encoding='utf-8') as f:
            test_cases_data = json.load(f)
    except FileNotFoundError:
        print("错误: 数据文件不存在，请先运行 generate_file_structure()")
        return False
    
    # 在HTML中嵌入数据
    data_script = f"""
    <script>
        // 嵌入的测试数据
        window.TEST_METHODS_DATA = {json.dumps(methods_data, ensure_ascii=False)};
        window.TEST_CASES_DATA = {json.dumps(test_cases_data, ensure_ascii=False)};
    </script>
    """
    
    # 在</head>之前插入数据脚本
    html_content = html_content.replace('</head>', f'{data_script}\n</head>')
    
    # 保存新的index.html
    with open("index_with_data.html", 'w', encoding='utf-8') as f:
        f.write(html_content)
    
    print("已生成 index_with_data.html，包含嵌入的测试数据")
    return True

def update_app_js():
    """更新app.js以使用嵌入的数据和匿名化功能"""
    with open("app.js", 'r', encoding='utf-8') as f:
        js_content = f.read()

    # 替换loadTestCaseStructure方法
    new_load_method = '''    // 加载测试用例结构
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

                console.log(`已加载 ${this.testMethods.length} 个测试方法（匿名化）`);
            } else {
                throw new Error('未找到嵌入的测试数据');
            }

        } catch (error) {
            console.error('加载测试用例结构失败:', error);
            this.showError('无法加载测试用例结构，请确保数据文件正确生成。');
        }
    }'''

    # 查找并替换loadTestCaseStructure方法
    import re
    pattern = r'(    // 加载测试用例结构\s+async loadTestCaseStructure\(\) \{.*?^\s{4}\})'

    if re.search(pattern, js_content, re.MULTILINE | re.DOTALL):
        js_content = re.sub(pattern, new_load_method, js_content, flags=re.MULTILINE | re.DOTALL)

        # 移除preloadTestCaseFiles方法调用
        js_content = js_content.replace('await this.preloadTestCaseFiles();', '// 数据已嵌入，无需预加载')

        # 更新工具显示配置
        old_tools_config = '''        const tools = [
            { name: 'ChatUniTest_Test', displayName: 'ChatUniTest', badge: 'chatunitest' },
            { name: 'TestAgent_Test', displayName: 'TestAgent', badge: 'testagent' },
            { name: 'EvoSuite_Test', displayName: 'EvoSuite', badge: 'evosuite' },
            { name: 'HITS_Test', displayName: 'HITS', badge: 'hits' }
        ];'''

        new_tools_config = '''        const tools = [
            { name: 'Method_A', displayName: '方法 A', badge: 'method-a' },
            { name: 'Method_B', displayName: '方法 B', badge: 'method-b' },
            { name: 'Method_C', displayName: '方法 C', badge: 'method-c' },
            { name: 'Method_D', displayName: '方法 D', badge: 'method-d' }
        ];'''

        js_content = js_content.replace(old_tools_config, new_tools_config)

        # 保存更新的app.js
        with open("app_with_data.js", 'w', encoding='utf-8') as f:
            f.write(js_content)

        print("已生成 app_with_data.js，使用匿名化数据")
        return True
    else:
        print("错误: 无法找到loadTestCaseStructure方法")
        return False

def main():
    """主函数"""
    print("=== 测试用例评估系统数据生成器 ===")
    
    # 1. 生成文件结构数据
    print("\n1. 生成文件结构数据...")
    if not generate_file_structure():
        return
    
    # 2. 复制测试文件
    print("\n2. 复制测试文件...")
    copy_test_files()
    
    # 3. 生成包含数据的HTML文件
    print("\n3. 生成包含数据的HTML文件...")
    if not generate_index_with_data():
        return
    
    # 4. 更新JavaScript文件
    print("\n4. 更新JavaScript文件...")
    if not update_app_js():
        return
    
    print("\n=== 生成完成 ===")
    print("请使用以下文件启动评估系统:")
    print("- index_with_data.html (主页面)")
    print("- app_with_data.js (JavaScript逻辑)")
    print("- styles.css (样式文件)")
    print("\n注意: 请在HTTP服务器环境下运行，不要直接用浏览器打开文件")

if __name__ == "__main__":
    main()
