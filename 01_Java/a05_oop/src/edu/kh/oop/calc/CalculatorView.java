package edu.kh.oop.calc;

import java.util.Scanner;

public class CalculatorView {
	
	private Calculator  calc = new Calculator(); //객체 생성
	
	private Scanner sc = new Scanner(System.in);

	
	//계산기 메뉴 표시 기능
	public void displayMenu() { 
		
		int input = 0;  //선택 메뉴 저장용 변수
		
		do {
			
			System.out.println("\n----------------------");
			System.out.println("현재 값 : " + calc.getSaveValue());
			System.out.println("\n----------------------");
			
			System.out.println("1. 더하기(+)");
			System.out.println("2. 빼기(-)");
			System.out.println("3. 곱하기(*)");
			System.out.println("4. 나누기(/)");
			System.out.println("5. 초기화");
			
			System.out.println("6. 최대값으로 변경");
			System.out.println("7. 최소값으로 변경");
			
			System.out.println("8. 원의 넓이 구하기");
			
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택: ");
			input = sc.nextInt();
			
			switch(input) {
			
			//같은 클래스의 다른 메서드 호출 시 메서드명만 작성
			
			case 1 : System.out.println(plus());     break;
			case 2 : System.out.println(minus());    break;
			case 3 : System.out.println(multi());    break;
			case 4 : System.out.println(div());      break;
			
			case 5 :System.out.println("초기화 : " + calc.init()); break;
			
			case 6 :System.out.println("최대값으로 변경 :" + calc.changeMaxValue()); break;
			case 7 :System.out.println("최소값으로 변경: " + calc.changeMinValue()); break;
			case 8 :System.out.println(theAreaOfACircle());break;
			
			case 0 : System.out.println("계산기 종료");  break;
			
			default : System.out.println("잘못 입력");
			
			}
			
		}while(input != 0);
		
		
	} //displayMenu()끝  
	//ctrl + shift + p : { }시작,끝 지점 이동
	
	private String plus() {
		System.out.print("더할 값을 입력해주세요 : ");
		double number = sc.nextDouble(); //더할 값
		
		double saveValue = calc.getSaveValue();  //기존 값
		
		double result = calc.plus(number);
		
		//String.format()
		
		String str = String.format("%.2f + %.2f = %.2f\n",saveValue, number,result);
		
		return str;
	}
	
	private String minus() {
		System.out.print("뺄 값을 입력해주세요 : ");
		double number = sc.nextDouble(); //뺄 값
		
		double saveValue = calc.getSaveValue(); //기존 값
		
		double result = calc.minus(number); //결과 값
		
		String str = String.format("%.2f - %.2f = %.2f\n", saveValue, number, result);
		
		return str;
	}
	
	private String multi() {
		System.out.println("곱할 값을 입력하세요: ");
		double number = sc.nextDouble(); //곱할 값
		 
		double saveValue = calc.getSaveValue(); //기존 값
		
		double result = calc.multi(number); //결과 값
		
		String str = String.format("%.2f * %.2f = %.2f\n", saveValue, number, result);
		
		return str;
		
		
	}
	
	
	private String div() {
		System.out.println("나눌 값을 입력하세요: "); //나눌 값
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue(); //기존값
		
		double result = calc.div(number);  //결과 값
		
		String str = String.format("%.2f / %.2f = %.2f\n", saveValue, number, result);
		
		return str;
		
	}
	
	private String theAreaOfACircle() {
		System.out.println("반지름 입력: ");
		double r = sc.nextDouble();
		
		String str = String.format("PI * %.2f^2 = %.2f\n", r, calc.theAreaOfACircle(r) );
		
		return str;
	}
}
