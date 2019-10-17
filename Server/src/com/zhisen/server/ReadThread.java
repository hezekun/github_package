package com.zhisen.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import com.zhisen.dto.Protocol;

public class ReadThread extends Thread {

	private Map<Socket, Map<String, Object>> socketMap;
	private Socket socket;
	private ObjectInputStream objIn;

	public ReadThread(Map<Socket, Map<String, Object>> socketMap, Socket socket, ObjectInputStream objIn) {
		super();
		this.socketMap = socketMap;
		this.socket = socket;
		this.objIn = objIn;
	}

	@Override
	public void run() {

		while (true) {
			Protocol p;
			try {
				p = (Protocol) objIn.readObject();
				for (Socket client : this.socketMap.keySet()) {
					if (!this.socket.equals(client)) {
						ObjectOutputStream objectOutputStream = (ObjectOutputStream) this.socketMap.get(client)
								.get("out");
						objectOutputStream.writeObject(p);
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				this.socketMap.remove(this.socket);
				return ;
			}

		}

	}

}
