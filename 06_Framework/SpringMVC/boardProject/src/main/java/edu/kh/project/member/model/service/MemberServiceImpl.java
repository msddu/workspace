package edu.kh.project.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dao.MemberDAO;
import edu.kh.project.member.model.dto.Member;

@Service //bean등록 + 비즈니스 로직 처리 역할 명시
		 //->비즈니스 로직 : 응답에 필요한 데이터를 만드는 과정
	     //	   -데이터 가공, DAO 호출, 트랜잭션 제어 등
public class MemberServiceImpl implements MemberService{
	
	@Autowired	//등록된 bean 의존성 주입
	private MemberDAO dao;
	
	@Autowired //등록된 bean 의존성 주입(DI)
	private BCryptPasswordEncoder bcrypt;
	
	
	//bcrypt.encode(평문) -> 암호화
	@Override
	public Member login(Member inputMember) {
		
		//암호화 확인
//		String temp = bcrypt.encode(inputMember.getMemberPw());
//		System.out.println("입력된 비밀번호 : " +inputMember.getMemberPw());
//		System.out.println("암호화된 비밀번호: " + temp);
		
		
		//DB -> 암호화된 비밀번호
		//입력된 비밀번호 -> 평문 비밀번호(암호화X)
		
		/*BCrypt 암호화 사용 시 비밀번호 비교 방법!!!*/
		//1) DB에서 아이디가 일치하는 회원의 회원정보 + 비밀번호 조회(mapper.xml)
		//2) Service에서 bcrypt.matches(평문, 암호화) 메서드를 이용해 입력된 비밀번호와 DB에서 조회한 비밀번호를 비교
		//   일치 -> true
		//   아니면 -> false
		
		
		
		//---------------------------------------------------------------------
		
		//현재 클래스가 bean으로 등록되어 의존성 주입 되었나 확인
		//System.out.println(inputMember);
		
		
		//이제 Connection 따로 얻어올 필요 없음!
		//-> Connection 역할을 하는 SqlSessionTemplate이 Bean으로 등록됨
		Member loginMember = dao.login(inputMember);
		
		
		
		// DB 조회 결과가 없을 경우
		if(loginMember == null)  return null;
		
		// 입력된 비밀번호와 DB에 저장된 암호화 비밀번호가 일치하지 않으면
		if(!bcrypt.matches(inputMember.getMemberPw(), loginMember.getMemberPw())) {
			return null;
		}
		
		//로그인된 회원 정보에서 비밀번호 제거 후 리턴
		loginMember.setMemberPw(null);
		
		return loginMember;
	}
	
	@Override
	public int signup(Member inputMember, String[] memberAddress) {
		
		//memberAddress가공
		
		//주소를 입력하지 않은 경우
		if(inputMember.getMemberAddress().equals(",,")) {
			inputMember.setMemberAddress(null);
			
		}else {//입력 한 경우
			
			//memberAddres배열 요소의 값을 하나의 문자열 반환
			//(단, 요소 사이 구분자는 "^^^")
			String addr = String.join("^^^",memberAddress);
			inputMember.setMemberAddress(addr);
		}
			
		// ->주소 입력x == null
		// ->주소 입력o == "A^^^B^^^C"
		
		//------------------------------------------------------------------------------------
		//비밀번호 암호화 진행
		String encPw = bcrypt.encode(inputMember.getMemberPw());
		inputMember.setMemberPw(encPw);
		//------------------------------------------------------------------------------------
		
		//DAO 호출
		return dao.signup(inputMember);
	}
}
