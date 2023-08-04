package edu.kh.control.condition.ex;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

//기능용 클래스
public class SwitchEx {
	
	/*switch문 
	 *- 식 하나의 결과로 많은 경우의 수를 처리할 때 사용하는 조건문
	 *  -> 식의 결과에 맞는 case 구문이 수행됨
	 *  
	 *  [작성법]
	 *  
	 *  switch(식){ // 식의 결과는 정수 또는 문자열
	 *  case 결과1: 결과1의 수행 코드 ; break;
	 *  case 결과2: 결과2의 수행 코드 ; break;
	 *  default : 모든 case가 만족하지 못할 떄 수행할 코드
	 *  }
     */
	
	//Switch 예제 1
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		//키보드로 정수를 입력받아 
		//1 : RED
		//2 : ORANGE
		//3 : YELLOW
		//4 : GREEN
		//5 : BLUE
		//1~5가 아니면 : BLACK
		
		System.out.print("정수 입력: ");
		int input = sc.nextInt();
		
		String result;
		
	/*	
		if(input == 1) {
			result = "RED";
		}else if(input == 2) { 
			result = "ORANGE";
		}else if(input == 3) {
			result = "YELLOW";
	    }else if(input == 4) {
			result = "GREEN";
        }else if(input == 5) {
			result = " BLUE";
        }else 
			result = "BLACK";
		
		System.out.println(result);
		
		
		
		*/
		
		// switch 버전
		
		switch(input){
		
		case 1 : result = "RED";  break;
		case 2 : result = "ORANGE";  break;
		case 3 : result = "YELLOW";  break;
	    case 4 : result = "GREEN";  break;
		case 5 : result = "BLUE";  break;
	    default : result = "BLACK";
		
		}
		
		System.out.println(result);
		
		
		
	}
	
	//switch 예제 2
	public void ex2() {
		
		
		
		//점심 결정 프로그램
        //난수(math.random() ), switch문
		
		//1부터 5사이의 난수를 발생시켜 
		//일치하는 수의 메뉴를 출력
		
		
		
		//1~5난수 생성
		int randomNumber = (int)(Math.random() * 5 + 1 );
		
		String menu = null;
		switch(randomNumber) {
		case 1 : menu = "제육볶음"; break;
		case 2 : menu = "서브웨이"; break;
		case 3 : menu = "돈까스"; break;
		case 4 : menu = "초밥"; break;
		case 5 : menu = "파스타"; break;
	
		}
		
		System.out.printf("오늘의 점심 메뉴는 [%s] 입니다" , menu);
		
		}
		
		
		
		
		//Switch 예제 3
		public void ex3(){
			
			//문자열로 메뉴를 입력받아 
			//해당 메뉴의 가격을 출력
			
			//[실행화면]
			//메뉴를 선택해주세요(김밥, 라면, 떡볶이) : 김밥
			//김밥의 가격은 3000원 입니다.
			
			//메뉴를 선택해주세요(김밥, 라면, 떡볶이) : 샌드위치
			//존재하지 않는 메뉴입니다.
			
			
			
			Scanner sc = new Scanner(System.in);
			
			System.err.print("메뉴를 선택해주세요:");
			String menu = sc.next();
			
			
			int price; //가격 저장용 변수
			
			
			switch(menu) {
			case "김밥" :  price = 3000;  break;
			case "라면" :  price = 2500;  break;
			case "떡볶이": price = 4000; break;
			default : price = -1; //값에 의미를 부여해서 조건식에 사용하는 방법을 이해해야 한다!!!
		
			}
			if(price != -1)
				System.out.printf("%s의 가격은 %d 입니다", menu, price);
			else
				System.out.println("존재하지 않는 메뉴입니다");
			
		
		
		
	}

	
		
		//switch 예제 4
		
		public void ex4() {
		//산술 연산 계산기
			
			//두 정수와 1개의 연산자(+-*/)를 입력받아 연산 결과를 출력
			
			//[실행화면]
			//정수1 입력 : 5
			//연산자 : +
			//정수2 입력 : 4
			//5 + 4 = 9
			
			//정수1 입력 : 5
			//연산자 : / 
			//정수2 입력 : 4
			//5 / 4 = 1
			
			//정수1 입력 : 2
			//연산자 : @
			//정수2 입력: 10
			//전재하지 않는 연산자 입니다.
		 
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("정수1 입력:");
		int num1 = sc.nextInt();
		
		System.out.print("연산자:");
		String op = sc.next(); //한글자만 입력해도 String(연산자 포함)
		
		System.out.print("정수2 입력:");
		int num2 = sc.nextInt();
		
		int result = 0; //default에서 잘못입력되면 값이 대입되지 않기 때문에 선언에 초기화를 해놓는다
		
		boolean flag = false;
		//false 일때 : 연산자를 정상 입력
		//true 일때 : 연산자를 잘못 입력
		switch(op){
		case "+" : result= num1 + num2; break;
		case "-" : result= num1 - num2; break;
		case "*" : result= num1 * num2; break;
		case "/" : result= num1 / num2; break;
		case "%" : result= num1 % num2; break;
		default : flag = true; //연산자를 잘못 입력 -> flag를 true로 변경
		}
		if(!flag) {   //flag == false 와 !false는 같은 의미
			System.out.printf("%d %s %d = %d", num1, op, num2, result);
		}else {
			System.out.println("잘못 입력 되었습니다.");
		}
				
	
		
		}
		
		//switch 예제 5 - break의 역할
		
		public void ex5() {
			
			//switch문을 이용한 계절 판별기
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("달(월)입력:");
			int month = sc.nextInt();
			
			
			//break : 멈추다
			//-> 해당 case를 수행 한 후 switch문을 멈춰서 빠져 나가라
			
			//*break가 없는 경우
			//-break를 만나거나 switch가 끝날때 까지 
			// 다음 case를 연달아 실행
			String season; //결과 저장
			
			switch(month) {
			case 12 : case 1 : case 2 : season = "겨울";  break;
			
			case 3 : case 4 : case 5 : season = "봄";  break;
			
			case 6 : case 7 : case 8 : season = "여름"; break;
			
			case 9 : case 10 : case 11 : season = "가을"; break;
			
            default : season = "잘못입력";

			
			}
		
			System.out.println(season);
			
			
			
			
			
		}
		

	
	
	
	
}
