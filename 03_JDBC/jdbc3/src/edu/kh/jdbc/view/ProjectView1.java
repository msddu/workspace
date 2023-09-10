package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.model.service.ProjectService1;


public class ProjectView1 {

	private Scanner sc = new Scanner(System.in);
	
	private	ProjectService1 service1 = new ProjectService1();
	
	
	
	public void displayMenu() {
		int input = -1;
		do {
			try {
				System.out.println("1. 회원 가입");
				System.out.println("2. 로그인");
				System.out.println("3. 회원 정보 수정"); // 닉네임, 전화번호 UPDATE
				System.out.println("4. 회원 탈퇴"); // MEMBER_DEL_FL = 'Y' UPDATE
				System.out.println("5. MEMBER 테이블 전체 조회");
				System.out.println("6. 게시글 작성하기"); // BOARD 테이블에 INSERT
				
				
				
				System.out.println("7. 게시글 목록 조회");
				System.out.println("8. 게시글 상세조회"); 
				System.out.println("9. 게시글 삭제");
				
				System.out.println("10. 게시글 수정");
				
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 >> ");
				input = sc.nextInt();
			
				
				switch(input) {
				
					case 1 : insertMember(); break;
					case 2 : selectMember(); break;
					case 0 : System.out.println("프로그램 종료" ); break;
			
				}
			
			
			


			
		}catch(InputMismatchException e) {
			e.printStackTrace();
			
			System.out.println("잘못된인식");
		
			
		}
		
	}while(input != 0);
	
	
	
}
	private void insertMember() {
		
System.out.println("\n***** 회원 가입 *****\n");
		
		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("닉네임 : ");
		String nickname = sc.next();
		
		System.out.print("휴대폰 번호(- 제외) : ");
		String tel = sc.next();
		sc.nextLine(); // 입력 버퍼 개행문자 제거
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		
		Member member = new Member(email, pw, nickname, tel, address);
		
		int result = service1.insertMember(member);
		
		if(result > 0 ) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
		
	}
	
	
	private void selectMember() {
		
		System.out.println("\n*****  MEMBER 테이블 전체 조회 *****\n ");
		
		
		System.out.println("내림순(1), 오름차순(2)");
		int sort = sc.nextInt();
		
		List<Member> memberList = service1.selectMember(sort);
		
		if(memberList.isEmpty()) {
			System.out.println("조회결과가 없습니다.");
			
		}else {
			for(Member mem : memberList) {
				System.out.println(mem);
			}
		}
	        
		
		
	

	}
	
	
}