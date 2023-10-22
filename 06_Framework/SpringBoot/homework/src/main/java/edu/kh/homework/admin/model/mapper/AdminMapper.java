package edu.kh.homework.admin.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	Member selectOne(String inputEmail);

	
	
	
	/**회원 탈퇴 복구
	 * @param memberNo
	 * @return result
	 */
	int restoration(int memberNo);




	/**권한 변경
	 * @param memberNo
	 * @return result
	 */
	int changeAuthority(int memberNo);




	/**비밀번호 초기화
	 * @param map
	 * @return
	 */
	int initPw(Map<String, Object> map);









	

	
}
