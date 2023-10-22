package edu.kh.project.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.mypage.model.service.MyPageService;

@Controller
@RequestMapping("myPage")
@SessionAttributes({"loginMember"})
public class MyPageController {
	 
	@Autowired
	private MyPageService service;
	
	
	/**회원정보 수정
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @param updateMember : 수정된 회원정보 담길 객체
	 * @param loginMember : 현재 로그인된 회원 객체
	 * @return
	 */
	@PostMapping("info")
	public String info(RedirectAttributes ra, Member updateMember, 
						@SessionAttribute("loginMember") Member loginMember , String[] memberAddress) {
		
		
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		int result = service.info(updateMember, memberAddress);
		
		if(result > 0) {
			ra.addFlashAttribute("message" , "회원정보 수정 성공");
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
		}
		else {
			ra.addFlashAttribute("message" , "회원정보 수정 실패");
		}
		
		
		return "redirect:info";
		
		
	}

}
