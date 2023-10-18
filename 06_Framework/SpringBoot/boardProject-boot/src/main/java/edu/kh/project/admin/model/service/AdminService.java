package edu.kh.project.admin.model.service;

import edu.kh.project.member.model.dto.Member;

public interface AdminService {

	
	
	
	/**이메일 일치하는 회원 조회
	 * @param inputEmail
	 * @return
	 */
	Member selectOne(String inputEmail);
	

}
