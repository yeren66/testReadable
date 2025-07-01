# 测试用例可读性分析评估系统

一个用于评估测试用例可读性的在线匿名评估平台。

## 🚀 快速部署

### 部署到 Vercel

1. 运行部署脚本：
   ```bash
   ./deploy-to-vercel.sh
   ```

2. 部署到 Vercel：
   ```bash
   vercel --prod
   ```

### 或通过 GitHub 自动部署

1. 将代码推送到 GitHub
2. 在 Vercel 中连接 GitHub 仓库
3. 自动部署

## 📁 项目结构

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

## 🔧 本地开发

```bash
# 安装依赖
npm install

# 本地开发
vercel dev
```

## 📋 功能特性

- ✅ 匿名评估系统
- ✅ 测试用例可读性分析
- ✅ 数据收集 API
- ✅ 响应式设计
- ✅ 代码语法高亮

## 🛠️ 技术栈

- 前端：HTML, CSS, JavaScript
- 后端：Vercel Serverless Functions
- 部署：Vercel

---

如需帮助，请查看 `VERCEL_DEPLOYMENT_FIX.md` 文件。 
