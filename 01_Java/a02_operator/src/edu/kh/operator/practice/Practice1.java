package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		/*문제:모든 사람이 사탕을 골고루 나눠가지려고 한다. 인원 수와 사탕 개수를 키보드로 입력 받고
		1인당 동일하게 나눠가진 사탕 개수와 나눠주고 남은 사탕의 개수를 출력하세요.

		[실행화면]
		인원 수 : 29
		사탕 개수 : 100
		1인당 사탕 개수 : 3
		남는 사탕 개수 : 13*/
		
		System.out.print("인원수:");
		
		int num1 = sc.nextInt();
		
		System.out.print("사탕개수:");
		int num2 = sc.nextInt();
		
		
		int result1 = num2 / num1;
		System.out.println("1인당 사탕 개수:" + result1);
		
		
		int result2 = num2 % num1;
		System.out.print("남는 사탕 개수:" + result2);
		
		
		
		
		
	}

}
