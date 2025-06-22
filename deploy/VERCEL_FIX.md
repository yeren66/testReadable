# Vercel 部署错误修复

## 🔧 问题描述
在Vercel部署时遇到错误：
```
The `functions` property cannot be used in conjunction with the `builds` property. Please remove one of them.
```

## ✅ 解决方案
已修复 `vercel.json` 配置文件，移除了不兼容的 `builds` 和 `functions` 属性。

### 修复前的配置（错误）：
```json
{
  "version": 2,
  "builds": [...],
  "functions": {...},
  "routes": [...]
}
```

### 修复后的配置（正确）：
```json
{
  "rewrites": [
    {
      "source": "/",
      "destination": "/index_with_data.html"
    },
    {
      "source": "/app.js",
      "destination": "/app_online.js"
    }
  ],
  "headers": [
    {
      "source": "/api/(.*)",
      "headers": [
        {
          "key": "Access-Control-Allow-Origin",
          "value": "*"
        },
        {
          "key": "Access-Control-Allow-Methods",
          "value": "GET, POST, OPTIONS"
        },
        {
          "key": "Access-Control-Allow-Headers",
          "value": "Content-Type"
        }
      ]
    }
  ]
}
```

## 🚀 现在可以正常部署

### 部署步骤：
1. 确保使用修复后的 `vercel.json` 文件
2. 推送代码到GitHub
3. 在Vercel中重新部署

### 自动检测功能：
- ✅ Vercel会自动检测 `api/` 目录中的Serverless函数
- ✅ 静态文件会自动托管
- ✅ 路由重写会正确工作

## 📋 验证部署

部署成功后，验证以下功能：
1. 主页面加载：`https://your-app.vercel.app/`
2. API端点工作：`https://your-app.vercel.app/api/save-evaluation`
3. 数据提交功能正常

## 🔍 如果仍有问题

如果部署仍有问题，可以尝试：
1. 删除 `vercel.json` 文件，让Vercel使用默认配置
2. 检查 `api/save-evaluation.js` 文件是否正确
3. 查看Vercel控制台的部署日志

---

**修复完成！现在可以正常部署到Vercel了。**
