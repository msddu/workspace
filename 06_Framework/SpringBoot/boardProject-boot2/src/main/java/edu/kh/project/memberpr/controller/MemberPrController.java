package edu.kh.project.memberpr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.memberpr.model.service.MemberPrService;

@Controller
@RequestMapping("main")
@SessionAttributes({"loginMember"})
public class MemberPrController {

	@Autowired
	private MemberPrService service;
	
	
	
	@PostMapping("login")
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		
		
		Member loginMember = service.login(inputMember);
		
		//로그인 실패
		if(loginMember == null) {
			ra.addFlashAttribute("message" , "로그인 실패...");
		}
		//로그인 성공
		model.addAttribute("loginMember", loginMember);
		
		return "redirect:/";
		
	}
	
	
	
	
	
}
