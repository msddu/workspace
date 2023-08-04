package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {
	
	public void ex1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요:");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			if(num < 1) {
				System.out.print("1 이상의 숫자를 입력해주세요.");
			}else
			System.out.print(i + " ");
		}
		
		
	}
	
	public void ex2() {

		Scanner sc = new Scanner(System.in);
	
		
		System.out.print("1이상의 숫자를 입력하세요:");
		int num = sc.nextInt();
		
		for(int i = num; i >= 1; i--) {
			if(num < 1) {
				System.out.print("1 이상의 숫자를 입력해주세요.");
			}else
			System.out.print(i + " ");
		}
		
		
	}
	
	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 하나 입력하세요: ");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i = 1; i <= num; i++) { 
			sum+=i;
			System.out.println(i);
			if(i < num) {
				System.out.println(" + ");
					
			}
			
		
			
		}
		System.out.println(" = " + sum);
		
		
		
		
	}
	
	public void ex4() { 
		
	Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 수를 입력하세요: ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 수를 입력하세요: ");
		int num2 = sc.nextInt();
		
	/*
		//입력받은 두 수가 모드 1이상인가?
		if(num1 >=1 && num2 > 1) {
			
		}
		
		if(num2>num1) { 
		for(int i = num1; i<= num2; i++) {  
			 System.out.print(i + " ");
		 }
		}
	    else if(num1>num2) {
			for(int j = num2; j<= num1; j++) { 
				System.out.print(j + " ");
			}
	    }else {
			System.out.println("1이상의 수를 입력해주세요");
	
           }
	}
	
	public void ex5() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int num = sc.nextInt();
		
		
		System.out.printf("=======[%d단]========\n", num);
		
		
		for(int i=1; i <= 9; i++) {
			System.out.printf("%d x %d = %d\n" , num, i , num*i );
		}
		
	*/	
		//생각을 좀 해봐야하는 방법 + 변수를 아는가?
	
		if(num1 > num2) {
			//먼저 입력한 수가 더 큰 경우
			
		int temp = num1;
			num1 = num2;
			num2 = temp;
			
		}
		for(int i = num1; i <=num2; i++) {
			System.out.print(i + " + ");
		}
            
		
		
		
		
		
	}
	
	
	public void ex6() {
		
Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int dan = sc.nextInt();
		
		if(!(2 <= dan && dan<= 9)) {
			System.out.print("2~9사이 숫자만 입력하세요:");
		}
			else{
				for( dan = 1; dan <= 9; dan++) {
					System.out.printf("=======단==========\n , dan");
			}
			for(int i = 1; i <=9; i++)
			System.out.printf("%d x %d = %d\n" , dan, i , dan*i );
		}
		
		
	
		
		
		
		
	}
	
	
							
}				
			
	