package edu.kh.project.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

/*@Mapper 어노테이션
 * - 해당 인터페이스의 메서드명과
 * 	 mapper.xml에 작성된 태그 아이디가 같은 것 끼리 연결해주는 어노테이션
 * 
 * -sqlSessionTemplate bean을 의존성 주입 받는 코드를 별도 작성x
 * (작성 안해도 Spring이 알아서 불러와서 사용함)
 * 
 * -namespace.id 형식으로 mapper를 찾는 구문을 별도 작성x
 * (메서드 이름이 곧 id)
 * 
 * -selectOne, insert, update 메서드 구분 필요x
 * (mapper의 태그를 보고 구분)
 * 
 * ***주의사항***
 * 해당 인터페이스와 연결할 mapper.xml 파일의 
 * namespace 속성 값을 현재 인터페이스의 패키지명.인터페이스명 으로 작성해야 한다
 * (이래야 연결된다)
 * */

@Mapper
public interface MemberMapper {
	
	/**로그인
	 * @param inputMember
	 * @return
	 */
	Member login(Member inputMember);


	/**회원 가입
	 * @param inputMember
	 * @return
	 */
	int signup(Member inputMember);


	/**로그인
	 * @param memberEmail
	 * @return
	 */
	Member login(String memberEmail);


	/**이메일 중복 검사
	 * @param email
	 * @return 0또는 1
	 */
	int checkEmail(String email);


	/**닉네임 중복 검사
	 * @param nickname
	 * @return 0또는 1
	 */
	int checkNickname(String nickname);


}


