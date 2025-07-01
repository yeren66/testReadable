#!/bin/bash

echo "🚀 Vercel 部署脚本 - 修复 404 错误"
echo "=================================="

# 检查必要文件
echo "📋 检查必要文件..."

if [ ! -f "public/index.html" ]; then
    echo "❌ 缺少 public/index.html 文件"
    exit 1
fi

if [ ! -f "public/app.js" ]; then
    echo "❌ 缺少 public/app.js 文件"
    exit 1
fi

if [ ! -f "public/styles.css" ]; then
    echo "❌ 缺少 public/styles.css 文件"
    exit 1
fi

if [ ! -f "api/save-evaluation.js" ]; then
    echo "❌ 缺少 api/save-evaluation.js 文件"
    exit 1
fi

echo "✅ 所有必要文件都存在"

# 删除可能有问题的配置文件
echo "🧹 清理可能有问题的配置文件..."
rm -f vercel.json
echo "✅ 已删除 vercel.json"

# 确保 package.json 正确
echo "📦 检查 package.json..."
if [ ! -f "package.json" ]; then
    echo "❌ 缺少 package.json 文件"
    exit 1
fi

# 提交更改到 git（如果是 git 仓库）
if [ -d ".git" ]; then
    echo "📝 提交更改到 Git..."
    git add .
    git commit -m "Fix Vercel 404: Remove vercel.json and ensure proper file structure" || echo "没有新的更改需要提交"
    echo "✅ Git 提交完成"
else
    echo "ℹ️  不是 Git 仓库，跳过 Git 操作"
fi

echo ""
echo "🎯 部署说明："
echo "1. 确保您已安装 Vercel CLI: npm i -g vercel"
echo "2. 运行: vercel --prod"
echo "3. 或者通过 GitHub 连接自动部署"
echo ""
echo "🔧 如果仍然出现 404，请检查 Vercel 项目设置："
echo "   - Framework Preset: Other"
echo "   - Build Command: (留空)"
echo "   - Output Directory: (留空)"
echo "   - Install Command: (留空)"
echo ""
echo "✅ 准备完成！现在可以部署到 Vercel 了。"
