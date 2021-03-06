package com.pl.firstSocket;

import com.pl.firstSocket.nettyWork.TCPServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSocketApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstSocketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        TCPServer tcpServer = new TCPServer();
        tcpServer.run();

//		/**
//		 * 设置服务器相关信息
//		 */
//
//		/**
//		 * 基于TCP协议的Socket通信，实现用户登录，服务端
//		 */
//		//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
//		try {
//			//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
//			ServerSocket serverSocket = new ServerSocket(6844);//1024-65535的某个端口
//			Socket socket = null;
//			//记录客户端数量
//			int count = 0;
//			System.out.println("服务器即将启动，等待客户端连接");
//			//循环侦听等待客户端请求
//			while (true) {
//				socket = serverSocket.accept();
//				ServerThread st = new ServerThread(socket);
//				st.start();
//				count++;
//				System.out.println("客户端数量为：" + count);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
