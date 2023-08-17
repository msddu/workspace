package edu.kh.network.ex1.server;

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


public class Server1 {

	public void start() {
		
		
//		int port = 8000;
//		
//		
//		ServerSocket serverSocket = null;
//		Socket clientSocket = null;
//		
//		
//		InputStream is = null;
//		OutputStream os = null;
//		
//		
//		BufferedReader br = null;
//		PrintWriter pw = null;
//		
//	
//		try {
//			
//			serverSocket = new ServerSocket(port);
//			
//			clientSocket = serverSocket.accept();
//			
//			
//			is = clientSocket.getInputStream();
//			os = clientSocket.getOutputStream();
//			
//			br = new BufferedReader(new InputStreamReader(is));
//			pw = new PrintWriter(os);
//			
//			//서버 -> 클라이언트
//			
//			Date now = new Date();
//			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			
//			String message = sdf.format(now);
//			
//			pw.println(message);
//			pw.flush();
//			
//			//서버 <- 클라이언트
//			
//			String clientmessage = br.readLine();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}finally {
//			
//			try {
//				if(br != null) br.close();
//				if(pw != null) pw.close();
//				
//				if(serverSocket != null) serverSocket.close();
//				if(clientSocket != null) clientSocket.close();
//				
//				   
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
//		}
		
		
		
		
		int port = 8000;
		ServerSocket serverSocket = null;
		Socket clientsocket = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		try {
			
			serverSocket = new ServerSocket(port);
			clientsocket = serverSocket.accept();
			
			is = clientsocket.getInputStream();
			os = clientsocket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			pw = new PrintWriter(os);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		
	}
	
	
	

}
