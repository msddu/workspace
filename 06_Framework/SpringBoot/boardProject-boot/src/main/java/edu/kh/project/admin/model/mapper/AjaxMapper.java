package edu.kh.project.admin.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AjaxMapper {

	String selectMemberNo(int memberNo);
	

	String selectEmail(String inputEmail);


	/**회원 번호로 회원정보 조회
	 * @param no
	 * @return member
	 */
	Member selectMember(int no);


	/**일부 일치하는 이메일 모두 조회
	 * @param keyword
	 * @return emailList
	 */
	List<String> selectEmailList(String keyword);


	/**회원 전체 조회
	 * @return memberList
	 */
	List<Member> selectAll();


	/**회원 탈퇴 여부 변경
	 * @param paramMap
	 * @return result
	 */
	int updateFlag(Map<String, Object> paramMap);
	
	
	

	

}
