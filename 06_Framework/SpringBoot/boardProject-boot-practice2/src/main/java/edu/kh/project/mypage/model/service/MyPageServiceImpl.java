package edu.kh.project.mypage.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.mypage.model.mapper.MyPageMapper;

@Service
@Transactional
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageMapper mapper;
	
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		
		//주소 가공
		//주소가 입력되지 않았다면
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null);
		}else {
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}
		
		
		return mapper.info(updateMember);
	}
}
