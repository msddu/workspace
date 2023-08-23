package edu.kh.network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	public void start() {
		
		
		int port = 8500;
		
		//서버 -> 참조변수 6개
		
		
		//서버가 클라이언트를 기다리는 소켓
		ServerSocket serversocket = null;
		
		//클라이언트와 연결된 소켓
		Socket clientsocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			//클라이언트 연결을 port에서 기다리는 소켓
			serversocket = new ServerSocket(port);
			
			System.out.println("[server]");
			System.out.println("클라이언트의 접속을 기다리는 중입니다.");
			
			
			//클라이언트 연결시 접속 허용 + 연결된 소켓 생성
			clientsocket = serversocket.accept();
			
			System.out.println("[클라이언트 접속 성공]");
			
			is = clientsocket.getInputStream();
			os = clientsocket.getOutputStream();
			
			br  = new BufferedReader(new InputStreamReader(is));
			pw  = new PrintWriter(os);
			
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
			
			String message = sdf.format(now) + "[접속성공]";
			pw.println(message);
			pw.flush();
			
			String clientMessge = br.readLine();
			System.out.println(clientMessge);
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			//메모리 누수 관리
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(clientsocket != null) clientsocket.close();
				if(serversocket != null) serversocket.close();
				
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
}
