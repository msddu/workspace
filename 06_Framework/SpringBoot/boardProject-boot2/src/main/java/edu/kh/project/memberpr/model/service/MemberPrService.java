package edu.kh.project.memberpr.model.service;

import edu.kh.project.member.model.dto.Member;

public interface MemberPrService {

	/**로그인 서비스
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);

}
