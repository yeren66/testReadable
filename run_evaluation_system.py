#!/usr/bin/env python3
"""
一键启动测试用例可读性分析评估系统
"""

import os
import sys
import subprocess
import webbrowser
import time
from pathlib import Path

def check_requirements():
    """检查系统要求"""
    print("检查系统要求...")
    
    # 检查Python版本
    if sys.version_info < (3, 6):
        print("错误: 需要Python 3.6或更高版本")
        return False
    
    # 检查test_resource目录
    if not Path("test_resource").exists():
        print("错误: test_resource目录不存在")
        print("请确保将测试用例文件放在test_resource目录中")
        return False
    
    # 检查是否有测试文件
    test_dirs = ["ChatUniTest_Test", "TestAgent_Test"]
    found_dirs = []
    for test_dir in test_dirs:
        if Path(f"test_resource/{test_dir}").exists():
            found_dirs.append(test_dir)
    
    if not found_dirs:
        print("警告: 未找到任何测试用例目录")
        print("请确保test_resource目录包含以下子目录之一:")
        for test_dir in test_dirs:
            print(f"  - {test_dir}")
    else:
        print(f"找到测试目录: {', '.join(found_dirs)}")
    
    return True

def setup_system():
    """设置系统"""
    print("\n设置评估系统...")
    
    try:
        # 生成数据文件
        print("生成数据文件...")
        result = subprocess.run([sys.executable, 'generate_data.py'], 
                              capture_output=True, text=True, timeout=60)
        
        if result.returncode != 0:
            print("生成数据文件失败:")
            print(result.stderr)
            return False
        
        print("数据文件生成成功")
        return True
        
    except subprocess.TimeoutExpired:
        print("生成数据文件超时")
        return False
    except Exception as e:
        print(f"设置系统失败: {e}")
        return False

def start_server(port=12315):
    """启动服务器"""
    print(f"\n启动评估系统服务器 (端口: {port})...")
    
    try:
        # 启动服务器进程
        process = subprocess.Popen([sys.executable, 'start_server.py', '--port', str(port)],
                                 stdout=subprocess.PIPE, 
                                 stderr=subprocess.PIPE,
                                 text=True)
        
        # 等待服务器启动
        time.sleep(2)
        
        # 检查进程是否还在运行
        if process.poll() is None:
            print(f"服务器启动成功!")
            print(f"访问地址: http://localhost:{port}")
            
            # 尝试打开浏览器
            try:
                webbrowser.open(f"http://localhost:{port}")
                print("已自动打开浏览器")
            except:
                print("请手动打开浏览器访问上述地址")
            
            print("\n=== 评估系统使用说明 ===")
            print("1. 使用左右导航按钮或键盘方向键切换测试方法")
            print("2. 为每个测试用例的四个维度进行评分 (1-3分)")
            print("3. 点击右下角'?'按钮查看详细评分标准")
            print("4. 使用'导出结果'按钮保存评估数据")
            print("5. 按 Ctrl+C 停止服务器")
            print("=" * 40)
            
            # 等待用户中断
            try:
                process.wait()
            except KeyboardInterrupt:
                print("\n正在停止服务器...")
                process.terminate()
                process.wait()
                print("服务器已停止")
            
            return True
        else:
            # 获取错误信息
            stdout, stderr = process.communicate()
            print("服务器启动失败:")
            if stderr:
                print(stderr)
            if stdout:
                print(stdout)
            return False
            
    except Exception as e:
        print(f"启动服务器失败: {e}")
        return False

def main():
    """主函数"""
    print("=" * 50)
    print("    测试用例可读性分析评估系统")
    print("=" * 50)
    
    # 1. 检查系统要求
    if not check_requirements():
        print("\n系统要求检查失败，请解决上述问题后重试")
        return
    
    # 2. 设置系统
    if not setup_system():
        print("\n系统设置失败，请检查错误信息")
        return
    
    # 3. 启动服务器
    port = 12315
    
    # 如果默认端口被占用，尝试其他端口
    # for attempt_port in [8081, 8082, 8083, 8084]:
    #     try:
    #         import socket
    #         with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    #             s.bind(('localhost', attempt_port))
    #             port = attempt_port
    #             break
    #     except OSError:
    #         continue
    
    if not start_server(port):
        print("\n启动服务器失败")
        return
    
    print("\n感谢使用测试用例可读性分析评估系统!")

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("\n\n程序被用户中断")
    except Exception as e:
        print(f"\n程序运行出错: {e}")
        import traceback
        traceback.print_exc()
