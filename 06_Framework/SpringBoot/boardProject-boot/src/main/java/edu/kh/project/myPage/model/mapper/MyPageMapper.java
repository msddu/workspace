package edu.kh.project.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	int info(Member updateMember);

	/**비밀번호 암호화 조회
	 * @param memberNo
	 * @return encPw
	 */
	String selectMemberPw(int memberNo);
	
	
	

	/**비밀번호 변경
	 * @param map
	 * @return result
	 */
	int changePw(Map<String, Object> map);

	
	
	int secession(int memberNo);
	
	

	/**프로필 이미지 수정
	 * @param loginMember
	 * @return result
	 */
	int profile(Member loginMember);

	
	
	

}
