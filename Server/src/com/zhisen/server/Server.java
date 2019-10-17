package com.zhisen.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import com.zhisen.dto.Protocol;
import com.zhisen.server.ReadThread;

public class Server {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.1.48", 5000));
		Map<Socket, Map<String, Object>> socketMap = new HashMap<Socket, Map<String, Object>>();

		while (true) {

			Socket socket = serverSocket.accept();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			Map<String, Object> ioMap = new HashMap<String, Object>();
			ioMap.put("in", in);
			ioMap.put("out", out);
			socketMap.put(socket, ioMap);
			new ReadThread(socketMap, socket, in).start();
		}

	}
}