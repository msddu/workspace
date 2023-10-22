package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;

import edu.kh.project.member.model.service.MemberService;

@Controller
@RequestMapping("main")
@SessionAttributes({"loginMember"})
public class MemberController {
	
	
	@Autowired
	private MemberService service;
	
	@PostMapping("login")
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		Member loginMember = service.login(inputMember);
		
		
		if(loginMember != null) {
			ra.addFlashAttribute("message" , "로그인 성공");
		}
		
		if(loginMember == null) {
			ra.addFlashAttribute("message" , "로그인실패");
			
		}
		
		model.addAttribute("loginMember", loginMember);
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
}