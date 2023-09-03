package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.model.service.MemberService;

public class MemberView {
	
	private Scanner sc = new Scanner(System.in);
	private MemberService service = new MemberService();

	/**
	 * 메뉴 출력용 메서드
	 */
	public void displayMenu() {
		
		int input = -1;
		
		do {
			try {
				
				System.out.println("\n---Member 테이블로 JDBC 연습하기---\n");
				System.out.println("1. 회원 가입(INSERT)");
				System.out.println("2. 회원 정보 수정(UPDATE)");
				System.out.println("3. 회원 탈퇴(DELETE)");
				System.out.println("4. 비밀번호 변경(UPDATE)");
				System.out.println("5. 회원 가입 두번째 (INSERT)");
				System.out.println("0. 종료");
				
				System.out.print("메뉴선택>>");
				
				input = sc.nextInt();
				
				
				switch(input) {
				
				case 1 : insertMember();  break;
				case 2 : updateMember();  break;
				case 3 : deleteMember();  break;
				case 4 : updatePw();  	  break;
				case 5 : insertMember2();  break;
				case 0 : System.out.println("\n프로그램 종료\n"); break;
				default : System.out.println("\n메뉴에 작성된 번호만 입력하세요\n");
				
				}
				
			}catch(InputMismatchException e) {
				System.out.println("\n[잘못된 입력입니다]\n");
				sc.nextLine();
			
			}
			
		}while(input != 0);
		
	}
	
	/**
	 * 회원가입 화면
	 */
	private void insertMember() {
		System.out.println("\n*****회원가입*****\n");
		
		System.out.print("이메일: ");
		String email = sc.next();
		
		System.out.print("비밀번호: ");
		String pw = sc.next();
		
		System.out.print("닉네임: ");
		String nickname = sc.next();
		
		System.out.print("휴대폰번호(-제외)");
		String tel = sc.next();
		
		sc.nextLine(); //입력 버퍼 개행문자 제거
		
		System.out.print("주소: ");
		String adress  = sc.nextLine();
		
		//입력받은 값을 Member 객체에 저장하기
		Member member = new Member(email, pw, nickname, tel, adress);
		
		//서비스로 member를 전달한 후 수행 결과 반환받기
		//->DML(INSERT,UPDATE,DELETE)결과는 성공한 행의 수(int)로 반환
		
		int result = service.insertMember(member); //1 또는 0
		
		if(result > 0) {
			System.out.println("회원가입 성공!!!");
		}else {
			System.out.println("회원가입 실패...");
		}
		
		
	}
	
	
	private void updateMember() {
		
		//이메일, 비밀번호가 일치하는 회원의 
		//닉네임, 전화번호, 주소를 수정
		//(아이디 중복 없다고 가정)
		
		System.out.println("\n*****회원 정보 수정*****\n");
		
		System.out.print("이메일: ");
		String email = sc.next();
		
		System.out.print("비밀번호: ");
		String pw = sc.next();
		
		System.out.print("수정할 닉네임: ");
		String nickname = sc.next();
		
		System.out.print("수정할 휴대폰번호(-제외)");
		String tel = sc.next();
		
		sc.nextLine(); //입력 버퍼 개행문자 제거
		
		System.out.print("수정할 주소: ");
		String adress  = sc.nextLine();
		
		
		//Member 객체를 생성하여 입력받은 값을 대입
		Member member = new Member(email, pw, nickname, tel, adress);
		
		//회원 정보 수정 서비스 호출(member전달)후
		//결과(수정 된 행의 개수(int)) 반환 받기
		
		int result = service.updateMember(member);
		
		//result == 1 : 수정 성공(이메일, 비밀번호 모두 일치)
		//result == 0 : 수정 실패(이메일 또는 비밀번호 불일치)
		
		if(result > 0) {
			System.out.println("회원 정보 수정 완료!");
		}else {
			System.out.println("아이디 또는 비밀번호 불일치...");
		}
		
		
	}
	
	
	/**
	 * 회원 탈퇴 화면
	 */
	private void deleteMember() {
		
		//이메일 , 비밀번호가 일치하는 회원 탈퇴(DELETE)
		//이메일, 비밀번호 일치 -> 탈퇴 성공
		//불일치 -> 이메일 또는 비밀번호 불일치 출력
		System.out.println("\n*****회원 탈퇴*****\n");
		
		System.out.print("이메일: ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		
		Member member = new Member();
		member.setMemberEmail(email);
		member.setMemberPw(pw);
		
		//삭제 서비스 호출(성공1, 실패0 반환)
		int result = service.deleteMember(member);
		
		if(result > 0) {
			System.out.println("회원 탈퇴 성공");
		}else {
			System.out.println("회원 탈퇴 실패");
		}
	}
	
	
	
	
	private void updatePw() {
		//이메일, 비밀번호, 새 비밀번호를 입력받아
		//이메일, 비밀번호가 일치하는 회원의 비밀번호를
		//새 비밀번호로 변경
		//메서드 이름: updatePw()
		//hint : Member객체 하나라 안됌
		// 		(비밀번호 두개)
		
		
		System.out.println("\n*****비밀번호 변경*****\n");
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("새 비밀번호 : ");
		String npw = sc.next();
		
		
		//member객체 생성
		Member member = new Member(email, pw, npw);
		
		//서비스 호출
		int result = service.updatePw(member);
		
		if(result > 0) {
			System.out.println("변경 성공");
		}else {
			System.out.println("변경 실패");
		}
	}
	
	
	
	private void insertMember2() {

		System.out.println("\n*****회원가입*****\n");
		
	
		System.out.print("이메일: ");
		String email = sc.next();
		
		System.out.print("비밀번호: ");
		String pw = sc.next();
		
		System.out.print("닉네임: ");
		String nickname = sc.next();
		
		System.out.print("휴대폰번호(-제외)");
		String tel = sc.next();
		
		sc.nextLine(); //입력 버퍼 개행문자 제거
		
		System.out.print("주소: ");
		String adress  = sc.nextLine();
		
		//입력받은 값을 Member 객체에 저장하기
		Member member = new Member(email, pw, nickname, tel, adress);
		
		
		
	}
	
	

}
