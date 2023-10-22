package edu.kh.homework.admin.model.service;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	
	
	
	/**이메일 일치하는 회원 조회
	 * @param inputEmail
	 * @return
	 */
	Member selectOne(String inputEmail);

	
	
	
	/**회원 탈퇴 복구
	 * @param memberNo
	 * @return result
	 */
	int restoraion(int memberNo);




	/**권한 변경
	 * @param memberNo
	 * @return result
	 */
	int changeAuthority(int memberNo);




	/**비밀번호 초기화
	 * @param memberNo
	 * @return
	 */
	int initPw(int memberNo);
	
	




	

}
