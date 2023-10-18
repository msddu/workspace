package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	
	/**관리자 메인 페이지
	 * @return "admin/admon-main
	 */
	@GetMapping("main")
	public String adminMain() {
		
		
		
		//forward : 위청위임
		//Thtmeleaf 
		//-prefix : classpath :/templetes/
		//-surfix : .html
		return "admin/admin-main";
	}
	
	
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		
		
		Member loginMember = service.selectOne(inputEmail);
		//이메일이 일치하는 회원이 존재하는 경우
		//model.addAttribute("searchMember", value);
		//return "admin/success";  
		if(loginMember != null) {
			
			model.addAttribute("loginMember", loginMember);
			return "admin/success";
		}
		
		
		//이메일이 일치하는 회원이 존재하지않는 경우
		//return "admin/fail";
		
		return "admin/fail"; 
		
		 
	
		
		
		
	
		
	}
	
}
