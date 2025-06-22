#!/bin/bash

echo "=== Vercel 404 快速修复脚本 ==="

# 检查是否在正确的目录
if [ ! -f "index.html" ]; then
    echo "❌ 错误: 请在deploy目录中运行此脚本"
    exit 1
fi

echo "🔍 检查当前文件..."
ls -la | grep -E "(index|vercel|app_online|styles)"

# 删除可能有问题的vercel.json文件
if [ -f "vercel.json" ]; then
    echo "🗑️  删除vercel.json文件..."
    rm vercel.json
    echo "✅ vercel.json已删除"
else
    echo "ℹ️  vercel.json文件不存在"
fi

# 确保关键文件存在
echo "🔍 检查关键文件..."

if [ ! -f "index.html" ]; then
    if [ -f "index_with_data.html" ]; then
        cp index_with_data.html index.html
        echo "✅ 从index_with_data.html创建了index.html"
    else
        echo "❌ 错误: 找不到index.html或index_with_data.html"
        exit 1
    fi
else
    echo "✅ index.html存在"
fi

if [ ! -f "app_online.js" ]; then
    echo "❌ 错误: app_online.js文件不存在"
    exit 1
else
    echo "✅ app_online.js存在"
fi

if [ ! -f "styles.css" ]; then
    echo "❌ 错误: styles.css文件不存在"
    exit 1
else
    echo "✅ styles.css存在"
fi

if [ ! -d "api" ] || [ ! -f "api/save-evaluation.js" ]; then
    echo "❌ 错误: api/save-evaluation.js文件不存在"
    exit 1
else
    echo "✅ api/save-evaluation.js存在"
fi

# 检查Git状态
if git status &>/dev/null; then
    echo "📝 提交更改到Git..."
    git add .
    git commit -m "Fix 404: Remove vercel.json and ensure proper file structure"
    
    if [ $? -eq 0 ]; then
        echo "✅ 更改已提交"
        
        # 推送到远程仓库
        echo "🚀 推送到远程仓库..."
        git push
        
        if [ $? -eq 0 ]; then
            echo "✅ 更改已推送到远程仓库"
            echo ""
            echo "🎉 修复完成！"
            echo "📋 接下来的步骤:"
            echo "1. 等待Vercel自动重新部署（通常需要1-2分钟）"
            echo "2. 访问您的Vercel URL测试是否修复"
            echo "3. 如果仍有问题，请检查Vercel项目设置"
        else
            echo "❌ 推送失败，请手动推送更改"
        fi
    else
        echo "ℹ️  没有需要提交的更改"
    fi
else
    echo "ℹ️  不是Git仓库，请手动部署更改"
fi

echo ""
echo "🔧 如果404问题仍然存在，请尝试:"
echo "1. 在Vercel控制台检查项目设置"
echo "2. 确保Framework Preset设置为'Other'"
echo "3. 确保Build Command和Output Directory为空"
echo "4. 手动触发重新部署"
