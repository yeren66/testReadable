#!/usr/bin/env python3
"""
部署脚本 - 准备线上部署文件
"""

import os
import shutil
import json
from pathlib import Path

def prepare_deployment():
    """准备部署文件"""
    print("=== 准备线上部署文件 ===")
    
    # 1. 生成最新数据
    print("1. 生成最新的评估数据...")
    os.system("python3 generate_data.py")
    
    # 2. 创建部署目录
    deploy_dir = Path("deploy")
    if deploy_dir.exists():
        shutil.rmtree(deploy_dir)
    deploy_dir.mkdir()
    
    print("2. 复制部署文件...")
    
    # 复制必要文件
    files_to_copy = [
        "index_with_data.html",
        "app_online.js", 
        "styles.css",
        "vercel.json",
        "package.json",
        "README.md",
        "DEPLOYMENT.md"
    ]
    
    for file in files_to_copy:
        if Path(file).exists():
            shutil.copy2(file, deploy_dir / file)
            print(f"  ✓ {file}")
        else:
            print(f"  ✗ {file} (文件不存在)")
    
    # 复制API目录
    api_dir = Path("api")
    if api_dir.exists():
        shutil.copytree(api_dir, deploy_dir / "api")
        print("  ✓ api/")
    
    # 3. 创建.gitignore
    gitignore_content = """
# Dependencies
node_modules/
.npm

# Environment variables
.env
.env.local
.env.production

# Vercel
.vercel

# Python
__pycache__/
*.pyc
*.pyo

# Local development
test_resource/
data/
web_test_resource/

# IDE
.vscode/
.idea/
*.swp
*.swo

# OS
.DS_Store
Thumbs.db
"""
    
    with open(deploy_dir / ".gitignore", "w") as f:
        f.write(gitignore_content.strip())
    print("  ✓ .gitignore")
    
    # 4. 创建部署说明
    deployment_info = {
        "name": "test-case-evaluation-system",
        "description": "测试用例可读性分析评估系统",
        "version": "1.0.0",
        "deployment_date": "2025-01-20",
        "total_methods": get_method_count(),
        "features": [
            "匿名化评估",
            "四种测试生成方法",
            "实时数据收集",
            "响应式设计",
            "自动数据同步"
        ],
        "deployment_steps": [
            "1. 将deploy目录内容推送到GitHub仓库",
            "2. 连接Vercel到GitHub仓库",
            "3. 配置环境变量（如需要）",
            "4. 部署到生产环境"
        ]
    }
    
    with open(deploy_dir / "deployment-info.json", "w", encoding="utf-8") as f:
        json.dump(deployment_info, f, ensure_ascii=False, indent=2)
    print("  ✓ deployment-info.json")
    
    # 5. 创建快速部署脚本
    deploy_script = """#!/bin/bash
# 快速部署脚本

echo "=== 测试用例评估系统部署 ==="

# 检查是否安装了git
if ! command -v git &> /dev/null; then
    echo "错误: 请先安装Git"
    exit 1
fi

# 初始化Git仓库（如果还没有）
if [ ! -d ".git" ]; then
    echo "初始化Git仓库..."
    git init
    git branch -M main
fi

# 添加所有文件
echo "添加文件到Git..."
git add .

# 提交
echo "提交更改..."
git commit -m "Deploy: Test Case Evaluation System $(date)"

# 推送到GitHub（需要用户手动设置remote）
echo ""
echo "接下来的步骤:"
echo "1. 在GitHub创建新仓库"
echo "2. 运行: git remote add origin https://github.com/yourusername/your-repo.git"
echo "3. 运行: git push -u origin main"
echo "4. 在Vercel中连接GitHub仓库并部署"
echo ""
echo "部署完成后，您将获得一个可访问的URL"
"""
    
    with open(deploy_dir / "deploy.sh", "w") as f:
        f.write(deploy_script)
    os.chmod(deploy_dir / "deploy.sh", 0o755)
    print("  ✓ deploy.sh")
    
    print("\n=== 部署准备完成 ===")
    print(f"部署文件已准备在: {deploy_dir.absolute()}")
    print("\n下一步:")
    print("1. cd deploy")
    print("2. 按照 DEPLOYMENT.md 中的说明进行部署")
    print("3. 或运行 ./deploy.sh 获取快速部署指导")
    
    return True

def get_method_count():
    """获取测试方法数量"""
    try:
        with open("data/methods.json", "r", encoding="utf-8") as f:
            methods = json.load(f)
            return len(methods)
    except:
        return 0

def create_vercel_deployment_guide():
    """创建Vercel部署指南"""
    guide = """
# Vercel 部署快速指南

## 方法一：通过Vercel网站部署

1. 访问 https://vercel.com
2. 使用GitHub账号登录
3. 点击 "New Project"
4. 选择您的GitHub仓库
5. 保持默认设置，点击 "Deploy"
6. 等待部署完成

## 方法二：通过CLI部署

```bash
# 安装Vercel CLI
npm i -g vercel

# 登录Vercel
vercel login

# 部署
vercel

# 生产环境部署
vercel --prod
```

## 配置数据收集

### 选项1：使用Vercel KV (推荐)
1. 在Vercel项目设置中启用KV存储
2. 更新 api/save-evaluation.js 使用KV存储

### 选项2：使用外部数据库
1. 设置环境变量
2. 修改API代码连接数据库

## 获取评估数据

部署后，评估数据将通过以下方式收集：
- Vercel函数日志（默认）
- 配置的数据库
- 导出API端点

访问 https://your-project.vercel.app 开始收集评估数据！
"""
    
    with open("deploy/VERCEL_GUIDE.md", "w", encoding="utf-8") as f:
        f.write(guide.strip())

if __name__ == "__main__":
    prepare_deployment()
    create_vercel_deployment_guide()
    print("\n🚀 准备就绪！现在可以部署到Vercel了！")
