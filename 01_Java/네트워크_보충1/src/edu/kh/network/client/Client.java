package edu.kh.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public void start() {
		
		int port = 8500;
		String ip = "127.0.0.1";
		
		//클라이언트 -> 참조변수 5개
		
		
		//서버와 연결된 소켓
		Socket clientsocket = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			//Server Socket을 찾아가 연결해달라고 부탁
			clientsocket = new Socket(ip, port);
			
			is = clientsocket.getInputStream();
			os = clientsocket.getOutputStream();
			
			br  = new BufferedReader(new InputStreamReader(is));
			pw  = new PrintWriter(os);
			
			//서버 메시지 읽어오기
			String serverMessage = br.readLine();
			System.out.println(serverMessage);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("전달할 메시지: ");
			String message = sc.nextLine();
			
			pw.println(message);
			pw.flush();
			
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			//메모리 누수 관리
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(clientsocket != null) clientsocket.close();
				
				
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
