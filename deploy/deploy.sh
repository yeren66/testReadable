#!/bin/bash
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
