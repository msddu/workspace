package edu.kh.network.ex1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client1 {
	
	public void start() {
		
		
		int port = 8000;
		String ip = "127.0.0.1";
		
		InputStream is = null;
		OutputStream os = null;
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		
		Socket socket = null;
		
		try {
			
			socket = new Socket(ip, port);
			
			if(socket != null) {
				
				is = socket.getInputStream();
				os = socket.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				pw = new PrintWriter(os);
				
				
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}finally {
			
			try {
				if(br != null)br.close();
				if(pw != null) pw.close();
				
				if(socket != null)socket.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
	}
	
	

}
