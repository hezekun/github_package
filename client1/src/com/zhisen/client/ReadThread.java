package com.zhisen.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.zhisen.dto.Protocol;

public class ReadThread extends Thread{

	private Socket clientSocket;

	public ReadThread(Socket clientSocket) {
		super();
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		
		try {
			ObjectInputStream objectInputStream=new ObjectInputStream(this.clientSocket.getInputStream());
			while(true) {
				Protocol p =(Protocol) objectInputStream.readObject();
				System.out.println(p.getChatString());
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
