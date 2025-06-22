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