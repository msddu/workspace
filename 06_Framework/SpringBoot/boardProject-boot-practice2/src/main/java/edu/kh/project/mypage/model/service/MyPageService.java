package edu.kh.project.mypage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	/** 회원정보 수정 
	 * @param updateMember
	 * @param memberAddress
	 * @return
	 */
	int info(Member updateMember, String[] memberAddress);

}
