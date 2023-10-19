package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.mapper.MemberMapper;



@Service
public class MemberServiceImpl implements MemberService{

	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public Member login(Member inputMember) {
		
		Member loginMember = mapper.login(inputMember);
		
		
		if(loginMember == null) {
			return null;
		}
		
		if(!bcrypt.matches(inputMember.getMemberPw(), inputMember.getMemberPw())) {
			return null;
		}
		
		loginMember.setMemberPw(null);
	
		return loginMember;
	}



	
}