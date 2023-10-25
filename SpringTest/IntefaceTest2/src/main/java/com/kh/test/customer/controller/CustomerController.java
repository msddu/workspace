package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.customer.model.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {

	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("updateMember")
	public String updateMember(int inputNo, String inputName, int inputTel, String inputAddress) {
		
		int result = service.updateMember(inputNo,inputName,inputTel,inputAddress);
		
		if(result > 0 ) {
			return "result";
		}
		
		return "result";
		
	}
	
	
}
