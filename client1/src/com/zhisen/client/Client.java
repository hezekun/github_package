package com.zhisen.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import com.zhisen.dto.Protocol;

public class Client {

	public void start() throws IOException {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress("192.168.1.48", 5000));
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
		Scanner scanner=new Scanner(System.in);
		String chatContent=" ";
		new ReadThread(socket).start();//���ӳɹ���,�߳�,������,������
		while(true) {
			chatContent = scanner.nextLine();//��������,����,
			Protocol p =new Protocol(chatContent);
			objectOutputStream.writeObject(p);
		}
		
	}
		
		
		
		
		
	
}
