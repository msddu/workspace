package edu.kh.project.memberpr.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.memberpr.model.mapper.MemberPrMapper;

@Service
public class MemberPrServiceImpl implements MemberPrService{

		@Autowired
		private BCryptPasswordEncoder bcrypt;
	
		
		@Autowired
		private MemberPrMapper mapper;
	
		@Override
		public Member login(Member inputMember) {
		
			
			Member loginMember = mapper.login(inputMember);
			
			if(loginMember == null) {
				return null;
			}
			if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
				return null;
			}
			
			loginMember.setMemberPw(null);
			
			return	loginMember;
		}
		
		
	}

