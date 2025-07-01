# 🚀 Vercel 部署说明

## ✅ 问题已修复

我已经修复了 Vercel 部署的运行时错误问题：

### 🔧 修复内容：
1. **删除了有问题的 `vercel.json` 文件** - 让 Vercel 自动检测项目类型
2. **使用标准的 `public/` 目录结构** - 符合 Vercel 最佳实践
3. **简化了配置** - 减少出错可能性

### 📁 当前项目结构：
```
readable/
├── public/
│   ├── index.html         # 主页面
│   ├── app.js            # 主要功能代码
│   └── styles.css        # 样式文件
├── api/
│   └── save-evaluation.js # API 端点
└── package.json          # 项目配置
```

## 🚀 部署步骤

### 方法一：使用部署脚本（推荐）
```bash
./deploy-to-vercel.sh
vercel --prod
```

### 方法二：直接部署
```bash
vercel --prod
```

### 方法三：通过 GitHub 自动部署
1. 推送代码到 GitHub
2. 在 Vercel 中连接仓库
3. 自动部署

## 🎯 关键要点

- **无需 `vercel.json`** - Vercel 会自动检测静态站点
- **API 函数自动工作** - `api/` 目录中的文件自动成为 serverless 函数
- **静态文件在 `public/`** - 这是 Vercel 的标准做法

## ✅ 预期结果

部署成功后，您将获得：
- 主页面：`https://your-app.vercel.app/`
- API 端点：`https://your-app.vercel.app/api/save-evaluation`

现在应该不会再出现运行时错误了！
