package edu.kh.homework.admin.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.homework.admin.model.mapper.AdminMapper;
import edu.kh.project.member.model.dto.Member;

@Transactional
@Service
public class AdminServiceImpl  implements AdminService{

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Autowired
	private AdminMapper mapper;
	
	@Override
	public Member selectOne(String inputEmail) {
		
		return mapper.selectOne(inputEmail);
	
		
		
	}
	
	
	@Override
	public int restoraion(int memberNo) {
		
		
		
		return mapper.restoration(memberNo);
	}
	
	
	@Override
	public int changeAuthority(int memberNo) {
		
		return mapper.changeAuthority(memberNo);
	}
	
	
	@Override
	public int initPw(int memberNo) {
		
		//암호화된 1234 만들기
		String encPw = bcrypt.encode("1234");
		
		
		//마이바티스 코드에서 파라미터는 1개만 가능
		Map<String, Object> map = new HashMap<>();
		map.put("encPw", encPw);
		map.put("memberNo", memberNo);
		
		
		return mapper.initPw(map);
	}
	

}