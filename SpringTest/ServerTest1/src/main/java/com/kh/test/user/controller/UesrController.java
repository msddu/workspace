package com.kh.test.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.user.model.dto.User;
import com.kh.test.user.model.service.UserService;




@RequestMapping("/")
@Controller
public class UesrController {

	@Autowired
	private UserService service;
	
	@GetMapping("selectMember")
	public String selectMember(String inputId, Model model) {
		
		User loginMember = service.selectMember(inputId);
		
		if(loginMember != null) {
			
			model.addAttribute("selectMember",loginMember);
			return "searchSuccess";
		}
		
		
		return "searchFail";
	}
	
	
	
	
}
