package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;

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
		
		
		
		//forward : 요청위임
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
	
	
	/** 회원 복구
	 * @param memberNo : 회원 번호
	 * @param memberEmail : 회원 이메일
	 * @param ra: 리다이렉트 시 데이터 전달
	 * @return
	 */
	@PostMapping("restoration")
	public String restoration(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		int result = service.restoraion(memberNo);
		
		
		if(result > 0) {
			ra.addFlashAttribute("message", "복구 성공");
		}
		else {
			ra.addFlashAttribute("message", "복구 실패");
		}
		
		return "redirect:selectMember?inputEmail=" + memberEmail;
		
	}
	
	@PostMapping("changeAuthority")
	public String changeAuthority(int memberNo, String memberEmail, RedirectAttributes ra){
		
		int result = service.changeAuthority(memberNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "변경 성공");
		}
		else {
			ra.addFlashAttribute("message", "변경 실패");
		}
		
		return  "redirect:selectMember?inputEmail=" + memberEmail;
		
	}
	
	
	
	/**비밀번호를 "1234"로 초기화
	 * @param memberNo
	 * @param memberEmail
	 * @return
	 */
	@PostMapping("initPw")
	public String initPw(int memberNo, String memberEmail, RedirectAttributes ra) {
		
		
		int result = service.initPw(memberNo);
		
		if(result > 0) {
			ra.addFlashAttribute("message", "비밀번호 초기화 성공");
		}
		
		
		
		return "redirect:selectMember?inputEmail=" + memberEmail;
		
	}
	
	
	
}
