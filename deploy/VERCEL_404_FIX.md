# Vercel 404 错误修复指南

## 🔍 问题描述
部署成功但访问网站时出现404错误，这通常是由以下原因造成的：

## 🛠️ 解决方案

### 方法一：检查Vercel项目设置（推荐）

1. **登录Vercel控制台**
   - 访问 [vercel.com](https://vercel.com)
   - 进入您的项目

2. **检查项目设置**
   - 进入 Settings → General
   - 确认以下设置：
     - **Framework Preset**: Other
     - **Build Command**: (留空)
     - **Output Directory**: (留空)
     - **Install Command**: (留空)

3. **重新部署**
   - 进入 Deployments 页面
   - 点击最新部署右侧的三个点
   - 选择 "Redeploy"

### 方法二：删除vercel.json文件

有时vercel.json配置可能导致路由问题：

1. **删除vercel.json**
   ```bash
   rm vercel.json
   ```

2. **重新提交和部署**
   ```bash
   git add .
   git commit -m "Remove vercel.json to fix 404"
   git push
   ```

### 方法三：创建简单的vercel.json

如果需要保留配置文件，使用最简单的配置：

```json
{
  "rewrites": [
    {
      "source": "/app.js",
      "destination": "/app_online.js"
    }
  ]
}
```

### 方法四：检查文件结构

确保deploy目录包含以下文件：
```
deploy/
├── index.html          ✅ 必须存在
├── app_online.js       ✅ 必须存在
├── styles.css          ✅ 必须存在
└── api/
    └── save-evaluation.js ✅ 必须存在
```

### 方法五：使用public目录

如果上述方法都不行，尝试使用public目录：

1. **创建public目录**
   ```bash
   mkdir public
   ```

2. **移动文件到public目录**
   ```bash
   cp index.html public/
   cp app_online.js public/
   cp styles.css public/
   ```

3. **更新vercel.json**
   ```json
   {
     "rewrites": [
       {
         "source": "/app.js",
         "destination": "/app_online.js"
       }
     ]
   }
   ```

## 🔍 调试步骤

### 1. 检查部署日志
- 在Vercel控制台查看部署日志
- 确认所有文件都被正确上传

### 2. 检查函数日志
- 进入 Functions 页面
- 查看是否有错误信息

### 3. 测试特定文件
尝试直接访问：
- `https://your-app.vercel.app/index.html`
- `https://your-app.vercel.app/styles.css`
- `https://your-app.vercel.app/app_online.js`

### 4. 检查浏览器控制台
- 按F12打开开发者工具
- 查看Console和Network标签页的错误信息

## 🚀 快速修复脚本

创建一个快速修复脚本：

```bash
#!/bin/bash
echo "=== Vercel 404 快速修复 ==="

# 删除可能有问题的配置文件
rm -f vercel.json

# 确保index.html存在
if [ ! -f "index.html" ]; then
    cp index_with_data.html index.html
    echo "✅ 创建了index.html"
fi

# 提交更改
git add .
git commit -m "Fix 404: Remove vercel.json and ensure index.html exists"
git push

echo "✅ 修复完成，请等待Vercel自动重新部署"
```

## 📋 常见原因和解决方案

| 问题 | 原因 | 解决方案 |
|------|------|----------|
| 404 on root | 缺少index.html | 确保根目录有index.html |
| 404 on all pages | 错误的vercel.json配置 | 删除或简化vercel.json |
| 部署成功但404 | 项目设置错误 | 检查Framework Preset设置 |
| API 404 | API目录结构错误 | 确保api/目录存在 |

## 🎯 推荐的修复顺序

1. **首先尝试**: 删除vercel.json文件
2. **然后检查**: Vercel项目设置
3. **最后尝试**: 使用public目录结构

## 📞 如果仍然有问题

1. 检查Vercel状态页面
2. 尝试创建新的Vercel项目
3. 联系Vercel支持

---

**大多数404问题都可以通过删除vercel.json文件解决！**
