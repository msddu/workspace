package edu.kh.io.run;

import java.security.Provider.Service;

import edu.kh.io.model.service.IOService;

public class IORun {
	
	public static void main(String[] args) {
		
		
		IOService service = new IOService();
		
		//service.byteOutput();
		service.charInput();
		
		
	}

}
