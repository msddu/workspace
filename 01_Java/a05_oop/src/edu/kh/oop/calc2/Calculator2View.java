package edu.kh.oop.calc2;

import java.util.Scanner;

public class Calculator2View {

	
	private Calculator2 calc = new Calculator2();
	private Scanner sc = new Scanner(System.in);
	private int input;
	

	
	public void displayMenu() {
		
		input = 0;
		
	 do {
			System.out.println("현재값: " + calc.getSaveValue());
			
			System.out.println("1. 더하기");
			System.out.println("2. 빼기");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 선택: ");
			input = sc.nextInt();
			
			
			switch(input){
				case 1 : System.out.println(plus());  break;
				case 2 : System.out.println(minus()); break; 
				case 3 : System.out.println(multi()); break; 
				case 0 : System.out.println("계산기 종료"); break;
				 
		}
		
		
		
		
		
	}while(input != 0);
}
	
	



private String plus() {
		
		System.out.println("더할 값을 입력하세요: ");
		double number = sc.nextDouble();
		
		 double saveValue = calc.getSaveValue();
		 
		 double result = calc.plus(number);
		 
		 String str = String.format("%.2f + %.2f = %.2f\n" , saveValue, number, result);
		
		return str;
	}

	private String minus() {   
		
		System.out.println("뺄 값을 입력하세요: ");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		
		double result = calc.minus(number);
		
		String str = String.format("%2f - %2f = %2", saveValue, number, result);
		return str;
	}
	
	private String multi() {
		
		System.out.println("곱할 값을 입력하세요: ");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		
		double result = calc.multi(number);
		
		String str = String.format("%2f * %2f = %2f", saveValue, number, result);
		
		return str;
	}

	
}