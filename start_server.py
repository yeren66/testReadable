#!/usr/bin/env python3
"""
启动测试用例评估系统的HTTP服务器
"""

import http.server
import socketserver
import webbrowser
import os
import sys
from pathlib import Path

def start_server(port=8080):
    """启动HTTP服务器"""
    
    # 检查必要文件是否存在
    required_files = [
        "index_with_data.html",
        "app_with_data.js", 
        "styles.css"
    ]
    
    missing_files = []
    for file in required_files:
        if not Path(file).exists():
            missing_files.append(file)
    
    if missing_files:
        print("错误: 以下必要文件不存在:")
        for file in missing_files:
            print(f"  - {file}")
        print("\n请先运行 'python3 generate_data.py' 生成必要文件")
        return False
    
    # 创建自定义请求处理器
    class CustomHTTPRequestHandler(http.server.SimpleHTTPRequestHandler):
        def end_headers(self):
            # 添加CORS头部，允许跨域请求
            self.send_header('Access-Control-Allow-Origin', '*')
            self.send_header('Access-Control-Allow-Methods', 'GET, POST, OPTIONS')
            self.send_header('Access-Control-Allow-Headers', 'Content-Type')
            super().end_headers()
        
        def do_GET(self):
            # 如果请求根路径，重定向到index_with_data.html
            if self.path == '/':
                self.path = '/index_with_data.html'
            elif self.path == '/app.js':
                # 重定向到app_with_data.js
                self.path = '/app_with_data.js'
            
            return super().do_GET()
        
        def log_message(self, format, *args):
            # 简化日志输出
            print(f"[{self.address_string()}] {format % args}")
    
    try:
        # 尝试启动服务器
        with socketserver.TCPServer(("", port), CustomHTTPRequestHandler) as httpd:
            print(f"=== 测试用例评估系统服务器 ===")
            print(f"服务器启动成功!")
            print(f"地址: http://localhost:{port}")
            print(f"主页: http://localhost:{port}/index_with_data.html")
            print(f"\n按 Ctrl+C 停止服务器")
            print("=" * 40)
            
            # 自动打开浏览器
            try:
                webbrowser.open(f"http://localhost:{port}")
                print("已自动打开浏览器")
            except Exception as e:
                print(f"无法自动打开浏览器: {e}")
                print(f"请手动访问: http://localhost:{port}")
            
            # 启动服务器
            httpd.serve_forever()
            
    except OSError as e:
        if e.errno == 48:  # Address already in use
            print(f"错误: 端口 {port} 已被占用")
            print(f"请尝试使用其他端口: python3 start_server.py --port 8081")
        else:
            print(f"启动服务器失败: {e}")
        return False
    except KeyboardInterrupt:
        print("\n服务器已停止")
        return True

def main():
    """主函数"""
    import argparse
    
    parser = argparse.ArgumentParser(description='启动测试用例评估系统')
    parser.add_argument('--port', type=int, default=8080, help='服务器端口 (默认: 8080)')
    parser.add_argument('--generate', action='store_true', help='先生成数据文件再启动服务器')
    
    args = parser.parse_args()
    
    # 如果指定了generate参数，先生成数据
    if args.generate:
        print("正在生成数据文件...")
        import subprocess
        result = subprocess.run([sys.executable, 'generate_data.py'], 
                              capture_output=True, text=True)
        if result.returncode != 0:
            print("生成数据文件失败:")
            print(result.stderr)
            return
        print("数据文件生成完成\n")
    
    # 启动服务器
    start_server(args.port)

if __name__ == "__main__":
    main()
