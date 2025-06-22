// Vercel Serverless Function to collect evaluation data
export default async function handler(req, res) {
  // Enable CORS
  res.setHeader('Access-Control-Allow-Origin', '*');
  res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
  res.setHeader('Access-Control-Allow-Headers', 'Content-Type');

  if (req.method === 'OPTIONS') {
    res.status(200).end();
    return;
  }

  if (req.method === 'POST') {
    try {
      const evaluationData = req.body;
      
      // Add timestamp and unique ID
      const submissionData = {
        id: generateUniqueId(),
        timestamp: new Date().toISOString(),
        userAgent: req.headers['user-agent'] || 'unknown',
        ip: req.headers['x-forwarded-for'] || req.connection.remoteAddress || 'unknown',
        data: evaluationData
      };

      // In a real deployment, you would save this to a database
      // For now, we'll log it and return success
      console.log('Evaluation submission:', JSON.stringify(submissionData, null, 2));
      
      // You can integrate with services like:
      // - Vercel KV (Redis)
      // - PlanetScale (MySQL)
      // - Supabase (PostgreSQL)
      // - MongoDB Atlas
      // - Google Sheets API
      // - Airtable API
      
      res.status(200).json({
        success: true,
        message: '评估数据已成功提交',
        submissionId: submissionData.id
      });
      
    } catch (error) {
      console.error('Error saving evaluation:', error);
      res.status(500).json({
        success: false,
        message: '保存评估数据时出错',
        error: error.message
      });
    }
  } else if (req.method === 'GET') {
    // Endpoint to check if the service is working
    res.status(200).json({
      status: 'ok',
      message: '评估数据收集服务正常运行',
      timestamp: new Date().toISOString()
    });
  } else {
    res.status(405).json({ message: 'Method not allowed' });
  }
}

function generateUniqueId() {
  return Date.now().toString(36) + Math.random().toString(36).substr(2);
}
