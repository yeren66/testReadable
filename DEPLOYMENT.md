# 测试用例评估系统 - 线上部署指南

## 🚀 GitHub + Vercel 部署方案

### 前置准备

1. **GitHub 账号** - 用于代码托管
2. **Vercel 账号** - 用于部署（可用GitHub账号登录）
3. **生成的评估数据** - 运行 `python3 generate_data.py` 生成

### 📁 部署文件结构

```
readable/
├── index_with_data.html      # 主页面（包含数据）
├── app_with_data.js         # 离线版JavaScript
├── app_online.js            # 在线版JavaScript（新增）
├── styles.css               # 样式文件
├── vercel.json              # Vercel配置
├── api/
│   └── save-evaluation.js   # 数据收集API
├── package.json             # 项目配置（需创建）
└── README.md                # 项目说明
```

### 🔧 部署步骤

#### 1. 创建 package.json

```json
{
  "name": "test-case-evaluation-system",
  "version": "1.0.0",
  "description": "测试用例可读性分析评估系统",
  "main": "index_with_data.html",
  "scripts": {
    "dev": "vercel dev",
    "build": "echo 'Static site, no build needed'",
    "deploy": "vercel --prod"
  },
  "keywords": ["evaluation", "test-cases", "research"],
  "author": "Your Name",
  "license": "MIT"
}
```

#### 2. 准备GitHub仓库

```bash
# 初始化Git仓库
git init

# 添加文件
git add .

# 提交
git commit -m "Initial commit: Test Case Evaluation System"

# 连接到GitHub仓库
git remote add origin https://github.com/yourusername/test-evaluation-system.git

# 推送到GitHub
git push -u origin main
```

#### 3. 部署到Vercel

**方法一：通过Vercel网站**
1. 访问 [vercel.com](https://vercel.com)
2. 用GitHub账号登录
3. 点击 "New Project"
4. 选择您的GitHub仓库
5. 点击 "Deploy"

**方法二：通过Vercel CLI**
```bash
# 安装Vercel CLI
npm i -g vercel

# 登录
vercel login

# 部署
vercel

# 生产环境部署
vercel --prod
```

### 🔧 配置说明

#### vercel.json 配置

```json
{
  "version": 2,
  "name": "test-case-evaluation-system",
  "builds": [
    {
      "src": "index_with_data.html",
      "use": "@vercel/static"
    }
  ],
  "routes": [
    {
      "src": "/",
      "dest": "/index_with_data.html"
    },
    {
      "src": "/app.js",
      "dest": "/app_online.js"
    }
  ]
}
```

### 📊 数据收集方案

#### 当前方案：简单日志收集
- 评估数据通过API发送到Vercel函数
- 数据记录在Vercel函数日志中
- 可通过Vercel控制台查看日志

#### 推荐的数据存储方案

**1. Vercel KV (Redis) - 推荐**
```javascript
import { kv } from '@vercel/kv';

export default async function handler(req, res) {
  if (req.method === 'POST') {
    const data = req.body;
    const id = generateUniqueId();
    
    await kv.set(`evaluation:${id}`, data);
    
    res.json({ success: true, id });
  }
}
```

**2. Supabase (PostgreSQL)**
```javascript
import { createClient } from '@supabase/supabase-js';

const supabase = createClient(
  process.env.SUPABASE_URL,
  process.env.SUPABASE_ANON_KEY
);

export default async function handler(req, res) {
  const { data, error } = await supabase
    .from('evaluations')
    .insert([req.body]);
    
  if (error) throw error;
  res.json({ success: true });
}
```

**3. Google Sheets API**
```javascript
import { GoogleSpreadsheet } from 'google-spreadsheet';

export default async function handler(req, res) {
  const doc = new GoogleSpreadsheet(process.env.GOOGLE_SHEET_ID);
  await doc.useServiceAccountAuth({
    client_email: process.env.GOOGLE_SERVICE_ACCOUNT_EMAIL,
    private_key: process.env.GOOGLE_PRIVATE_KEY,
  });
  
  await doc.loadInfo();
  const sheet = doc.sheetsByIndex[0];
  await sheet.addRow(req.body);
  
  res.json({ success: true });
}
```

### 🔐 环境变量配置

在Vercel控制台设置环境变量：

```
# 如果使用Supabase
SUPABASE_URL=your_supabase_url
SUPABASE_ANON_KEY=your_supabase_key

# 如果使用Google Sheets
GOOGLE_SHEET_ID=your_sheet_id
GOOGLE_SERVICE_ACCOUNT_EMAIL=your_service_email
GOOGLE_PRIVATE_KEY=your_private_key
```

### 📈 数据导出

#### 方法一：通过Vercel函数日志
1. 登录Vercel控制台
2. 进入项目 → Functions → save-evaluation
3. 查看函数日志
4. 复制JSON数据

#### 方法二：创建导出API
```javascript
// api/export-data.js
export default async function handler(req, res) {
  // 需要管理员密钥验证
  if (req.query.key !== process.env.ADMIN_KEY) {
    return res.status(401).json({ error: 'Unauthorized' });
  }
  
  // 从数据库获取所有数据
  const data = await getAllEvaluations();
  
  res.setHeader('Content-Type', 'application/json');
  res.setHeader('Content-Disposition', 'attachment; filename=evaluations.json');
  res.json(data);
}
```

### 🔍 监控和分析

#### 实时监控
- Vercel Analytics：访问统计
- Vercel Logs：错误监控
- 自定义事件追踪

#### 数据分析
```javascript
// 在前端添加分析代码
function trackEvaluationProgress(methodIndex, totalMethods) {
  fetch('/api/analytics', {
    method: 'POST',
    body: JSON.stringify({
      event: 'evaluation_progress',
      progress: methodIndex / totalMethods,
      timestamp: Date.now()
    })
  });
}
```

### 🛡️ 安全考虑

1. **CORS配置**：限制允许的域名
2. **速率限制**：防止恶意提交
3. **数据验证**：验证提交的数据格式
4. **匿名化**：不收集个人身份信息

### 📱 移动端优化

系统已支持响应式设计，在移动设备上也能正常使用。

### 🚀 部署后的URL

部署成功后，您将获得类似以下的URL：
- `https://your-project-name.vercel.app`
- 可以绑定自定义域名

### 📞 技术支持

如需帮助，可以：
1. 查看Vercel文档
2. 检查GitHub Issues
3. 联系项目维护者

---

**部署完成后，评估者只需访问您提供的URL即可开始评估，所有数据将自动收集到您指定的存储系统中。**
