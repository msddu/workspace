package com.kh.test.customer.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.customer.model.service.CustomerService;

@Controller
@RequestMapping("index")
public class CustomerController {

	
	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("updateMember")
	public String updateMember(String customer_name, String customer_tel, String customer_address) {
		
		int result = service.updateMember(customer_name,customer_tel,customer_address);
		
		return "result";
		
	}
	
}
