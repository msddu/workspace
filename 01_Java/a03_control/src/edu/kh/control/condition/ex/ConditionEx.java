package edu.kh.control.condition.ex;

import java.util.Scanner;

//실행 기능 담당 클래스
public class ConditionEx {
	
	public void test1() {
		System.out.println("test1() 수행");
		
	}
	
	public void test2() {
		System.out.println("test2()수행");
	
	}
	
	
	//if 예제 1
	public void ex1() {
		
		//입력 받은 수가 양수인지 아닌지 검사
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력:");
		int input = sc.nextInt();
		
		if(input > 0) {
			System.out.println("양수입니다");
		    System.out.println("ex1 종료");
	
		}
		
		if(input <= 0) {
			
			System.out.println("양수가 아닙니다.");
			System.out.println("끝!");
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
    //if 예제 2 - (if - else)
	//if: 조건식이 true인경우 수행
	//else: 조건식이 false인 경우 수행
	
	public void ex2(){
	
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("정수 입력:");
	int input = sc.nextInt();
	
	if(input > 0) {
		System.out.println("양수입니다");
	
	}
	
	else {//else는 조건식을 따로 정의하지 않는다.
		
		System.out.println("양수가 아닙니다");
	}
	
	}
	
	//if 예제 3 - 중첩 if문
	public void ex3() {
	//음수, 양수, 0 구분하기	
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력:");
		int input = sc.nextInt();
		
		if(input > 0) {
		  System.out.println("양수입니다.");
		} else {
			
			if(input == 0) {
				System.out.println("0입니다.");
			}else {
				System.out.println("음수입니다.");
			}
			
		}
		
		
	}
	
	public void ex4() { 
		//달(월)을 입력 받아 해당 달의 계절을 출력
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("달(월)을 입력해주세요:");
	    int month = sc.nextInt();
	    
	    String season; //String 변수 선언
	                   //초기화 x -> 조건문에서 초기화 할 예정
	    
	    if(month >= 3 && month <= 5) {
	    	season = "봄";
	    }
	    
	    else if(month >= 6 && month <= 8) {
	    	season = "여름";
	    }
	    else if(month >= 9 && month <= 11) {
	    	season = "가을";
	    }
	    else if(month == 12 || month == 1 || month == 2) {
	    	season = "겨울";
	    }
	    else {
	    	season = "잘못 입력함";
	    }
	   
	    //결과 출력
	    System.out.println(season);
	    //선언된 변수(지역 변수)는 반드시 사용되기 전 초기화가 되어 있어야 한다.

	}
	
	
	
	//if 예재 5
	public void ex5() {
		//나이를 입력받아 
		//13세 이하면 "어린이"
		//13세 초과, 19에세 이하면 "청소년"
		//19세 초과는 "성인"
		//0세 미만, 100세 초과는 "잘못입력"
		
		
		Scanner sc = new Scanner(System.in);
	
		
		System.out.print("나이 입력:");
		int age = sc.nextInt();
		
	
		String num;  
		
		if(age < 0 || age > 100) {
			num = "잘못입력";
		}else if(age <= 13) {
			num = "어린이";
		}else if(age > 13 && age <= 19) {
 			num = "청소년";
 		}else{
 			num = "성인";
 		}
		System.out.println(num);
		
 		
 	
	 /*  if(age < 0 || age > 100 ) {
			System.out.println("잘못 입력");
	   }else if(age <= 13) {
			System.out.println("어린이");
	   }else if(age > 13 && age <= 19) {
 		   System.out.println("청소년");
 	   }else  {
 			System.out.println("성인");
 	   }
 		
 
		
		*/
	
	}
	//if 예제 6
	public void ex6() {
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("나이 입력:");
		int age = sc.nextInt();
		System.out.print("키 입력:");
		double height = sc.nextDouble();
		
		if(age < 0 ) {
			System.out.println("잘못 입력 하셨습니다.");
		}else if(age > 100) {
			System.out.println("잘못 입력 하셨습니다.");
		}else if(age < 12) {
			System.out.println("적정 연령이 아닙니다.");
		}else if(height < 140.0) {
			System.out.println("적정 키가 아닙니다.");
		}else if(age >= 12 && height >= 140.0) {
			System.out.println("탑승 가능");
		}
		
	
	}
	
	
	
	

	
}


	
	
	
	
	


