package edu.kh.collection.list.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.list.model.dto.Student;
import edu.kh.collection.list.model.service.StudentService;

public class StudentView {

	
	//필드
	private Scanner sc = new Scanner(System.in);
	private StudentService service = new StudentService();
	
	
	//alt + shift + j : 메서드 / 클래스 설명용 주석
	/**
	 * 메뉴 출력용 view 메서드
	 */
	public void displayMene() {
		
		int input = 0; //입력된 메뉴 번호 저장
		
		do {
			
			try{  //예외가 발생 할 수 있는 코드
				System.out.println();
				
				System.out.println("\n*****학생 관리 프로그램*****\n");
				System.out.println("1. 학생 추가");
				System.out.println("2. 학생 전체 조회");
				System.out.println("3. 학생 한명 조회(index)");
				System.out.println("4. 학생 1명 삭제(index)" );
				System.out.println("5. 성별 조회" );
				System.out.println("6. 같은 학년 조회" );
				System.out.println("7. 이름으로 조회" );
				System.out.println("8. 중복 확인" );
				System.out.println("9. 성적 순서로 조회하기" );
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴를 선택 >> ");
				input = sc.nextInt();   //정수가 아닌 것을 입력하면 InputMismatchException 발생 가능성 있음
				
				switch(input) {
				
				case 1: addStudent();          break;
				case 2: selectAllStudent();    break;
				case 3: selectOne();           break;
				case 4: deleteStudent();       break;
				case 5: selectGender();        break;
				case 6: selectGrade();         break;
				case 7: selectName();          break;
				case 8: duplicateValidation();    break;
				case 9: sortScore();            break;
				
				case 0: System.out.println("프로그램 종료"); break;
				
				default : System.out.println("잘못 입력");
				
				}
				
			}catch(InputMismatchException e) { //try에서 발생한 예외 처리
  				 //InputMismatchException : Scanner 입력 타입이 잘못 됨
				
				System.out.println("*메뉴 번호만 입력해주세요*");
				input = -1;  //예외 발생 시 while문 종료를 막기 위해 변경
				
				//Scanner 입력 버퍼에 남아있는
				//잘못 입력된 값을 제거하는 코드 작성
				//sc.nextLine() : 입력 버퍼에서 한줄(\n 까지) 읽어오는 기능
				sc.nextLine();
				
			}
			
		}while(input != 0);   //input == 0 이면 false가 되면서 종료
		
		
	}

	/**
	 * 학생 추가 view 메서드
	 */
	private void addStudent() {
		
		System.out.println("\n-----학생추가-----\n");
		
		System.out.print("학년: ");
		int grade = sc.nextInt();
		
		System.out.print("반: ");
		int ban = sc.nextInt();
		
		System.out.print("번호: ");
		int number = sc.nextInt();
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("성별(M/F): ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수: ");
		int score = sc.nextInt();
		
		
		//서비스 객체의 addStudent()호출(값6개 전달) 후 boolean값 반환
		boolean result = service.addStudent(grade,ban,number,name,gender,score);
		
		if(result) { //result가 true인 경우
			System.out.println(name + "학생이 추가 되었습니다");
			
		}else {
			System.out.println("추가 실패(중복된 학생 있음)");
		}

	}
	
	/**
	 * 학생 전체 조회 view 메서드
	 */
	private void selectAllStudent() {
		
		//Service에 있는 studentList를 통째로 얻어와
		//for문을 이용하여 출력하자
		
		//service로 부터 List<Student> 객체의 참조 주소를 반환 받기
		List<Student> studentList = service.selectAllStudent();
	
		for(int i = 0; i < studentList.size(); i++) {
			System.out.printf("[%d] %s \n", i, studentList.get(i));
			                            //==studentListget(i).toString
	}
	
}
	
	
	/**
	 * 학생 1명 조회 view 메서드
	 */
	private void selectOne() {
		
		System.out.println("\n-----학생 한명 조회(index)-----\n");
		
		System.out.print("조회할 학생의 index 입력: ");
		int index = sc.nextInt();	
		
		//sevice의 studentList에서 index가 일치하는 학생 1명 반환 받기
		Student std = service.selectOne(index);  //index를 전달
		
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
		}else {
			System.out.println(std); // == std.toString
		}
	
	
	}
	
	/**
	 * 학생 1명 삭제 view 메서드
	 */
	private void deleteStudent() {
		
		System.out.println("\n-----학생 한명 삭제(index)-----\n");
		
		//인덱스 번호를 입력 받아서 Service로 전달
		//List에 해당하는 인덱스 학생이 있으면 삭제 후 삭제된 학생 반환
		// -> "000학생의 정보가 삭제되었습니다." 출력
		
		//List에 해당하는 인덱스 학생이 없으면 null 반환
		// ->해당하는 학생이 없습니다.
		
		System.out.print("삭제할 학생 인덱스를 입력하세요: ");
		int index = sc.nextInt();
		Scanner sc = new Scanner(System.in);
		
		Student std  = service.deleteStudent(index);
		
		if(std == null) {
			System.out.println("일치하는 학생이 없습니다.");
		}else {
			System.err.println(std.getName() + "정보가 삭제되었습니다.");
		}
		
	}
	
	/**
	 * 성별 조회 view 메서드
	 */
	private void selectGender() {
		
		System.out.println("\n-----성별 조회-----\n");
		
		System.out.print("조회할 성별을 입력해주세요(M/F) : ");
		char gender = sc.next().toUpperCase().charAt(0);  //-> 무조건 대문자
		              //String / 대문자로 변경  / 0번째 문자 하나
		
		//제대로 입력 X
		if(gender != 'M' && gender != 'F') {
			System.out.println("잘못 입력 되었습니다(M또는 F만 입력)");
			return;
		}
		//M 또는 F를 입력한 경우
		//Service의 성별 조회 메서드 호출(입력 받은 성별 전달) 후
		//일치하는 성별만 담긴 학생 목록을 반환 받기
		
		List<Student> searchList = service.selectGender(gender);
		
		
		//만약 검색 결과가 없을 경우
		//== serchList가 비어있을경우
		//== searchList size()가 0인 경우
		
		//if(searchList.isEmpty()) ==
          if(searchList.size() == 0) {
        	  
        	  System.out.println("검색 결과가 없습니다.");
          }else { //검색 결과가 있을 경우
        	  for(Student s : searchList) {
        		  System.out.println(s);
        	  }
          }
		
	}
	
	/**
	 * 같은 학년 조회하는 view 메서드
	 */
	private void selectGrade() {
		
		System.out.println("\n-----같은 학년 조회-----\n");
		System.out.print("조회할 학년을 입력해주세요: ");
		int grade = sc.nextInt();
		
		//학년은 1~6학년 까지만 존재
		List<Student> searchGrade = service.selectGrade(grade);
		
		if(grade < 1 || grade > 6) {
			System.out.println("1~6학년만 입력해주세요");
		}
		if(searchGrade.size() == 0) {
	        System.out.println("검색 결과가 없습니다.");
			
		}else {
			for(Student g : searchGrade) {
				System.out.println(g);
			}
		}
	
	
	}
	
	private void selectName() {
		
		System.out.println("\n-----이름으로 조회-----\n");
		System.out.print("조회할 이름을 입력해주세요: ");
		String name = sc.next();
		
		List<Student> searchname = service.selectName(name);
		
		
		if(searchname.isEmpty()) {
			System.out.println("검색이 잘못되었습니다.");
			
		}
		else {
			for(Student n : searchname) {
				System.out.println(n);
			}
			
		}
	}
	
	/**
	 * 중복 확인 view 메서드
	 */
	private void duplicateValidation() {
		System.out.println("\n-----중복 확인-----\n");
		
		//학년, 반, 번호, 이름, 성별, 점수를 입력받아 
		//모두 똑같은 학생이 존재하는지 확인 
		
		System.out.print("학년: ");
		int grade = sc.nextInt();
		
		System.out.print("반: ");
		int ban = sc.nextInt();
		
		System.out.print("번호: ");
		int number = sc.nextInt();
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("성별(M/F): ");
		char gender = sc.next().charAt(0);
		
		System.out.print("점수: ");
		int score = sc.nextInt();
		
		//입력받은 값을 서비스로 전달하여 중복이면 true 아니면 false 반환 받기
		
		boolean result = service.duplicateValidation(grade, ban, number, name, gender, score);
		
		if(result) {
			System.out.println("같은 학생이 있습니다.");
		}else {
			System.out.println("같은 학생이 없습니다.");
		}
		
	}
	
	
	/**
	 * 성적 순서로 조회(정렬) view 메서드
	 */
	private void sortScore() {
		System.out.println("\n-----성적 순서로 조회(정렬)-----\n");
		
		List<Student> sortList = service.sortScore();
		
		for(Student s : sortList) {
			System.out.println(s);
		}
	}
	
	
	
	
	
	

}