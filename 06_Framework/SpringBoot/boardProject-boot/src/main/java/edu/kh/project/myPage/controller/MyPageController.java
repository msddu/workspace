package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.kh.project.myPage.model.service.MyPageService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
@Slf4j
public class MyPageController {

	@Autowired
	private MyPageService service;
	
	
	//마이 페이지 화면전환 (forward)
	
	@GetMapping("info")  // /myPage/info
	public String info() {
		
		//templets/myPage/myPage-info.html
		return "myPage/myPage-info";
	}
	
	@GetMapping("profile")  // /myPage/profile
	public String profile() {
		
		//templets/myPage/myPage-profile.html
		return "myPage/myPage-profile";
	}
	
	
	@GetMapping("changePw")  // /myPage/changePw
	public String changePw() {
		
		//templets/myPage/myPage-changePw.html
		return "myPage/myPage-changePw";
	}
	
	
	@GetMapping("secession")  // /myPage/info
	public String secession() {
		
		//templets/myPage/myPage-info.html
		return "myPage/myPage-secession";
	}
	
	
	
	
}
