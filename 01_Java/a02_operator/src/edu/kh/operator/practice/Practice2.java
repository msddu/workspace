package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice2 {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		/*문제: 키보드로 입력 받은정수가 양수이면 “양수“, 양수가 아니면 “양수 아님“를 출력하세요.

		[실행화면]
		정수 입력 : -9
		양수 아님*/
		
		System.out.print("정수입력:");
		int num1 = sc.nextInt();
		
		String result = (num1 > 0)? "양수" : "양수 아님";
		System.out.println(result);
		
		
		
		
	}

}
