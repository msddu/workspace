package edu.kh.project.myPage.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MyPageService {

	
	/**회원 정보 수정
	 * @param updateMember
	 * @param memberAddress
	 * @return result
	 */
	int info(Member updateMember, String[] memberAddress);

	

	/**비밀 번호 수정
	 * @param currentPw
	 * @param newPw
	 * @param loginMember
	 * @return
	 */
	int changePw(String currentPw, String newPw, int memberNo);




	/** 회원 탈퇴
	 * @param memberPw
	 * @param loginMember
	 * @return result
	 */
	int secession(String memberPw, int memberNo);
	

	
}
