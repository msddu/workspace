package edu.kh.operator.ex;
import java.util.Scanner;
public class OperatorEx4 {
	
	
	
/* [배수 확인 프로그램]
 * 확인 할 수: 15
 * 배수 : 4
 * 
 * 15는 4의 배수? false
 * 
 *-----------------------------------
 *확인 할 수: 333
 *배수: 3
 *
 *333은 3의 배수? true
 * 
 * */
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("[배수 확인 프로그램]");
		
		
		System.out.print("확인 할 수: ");
		int num1 = sc.nextInt();
		
		
		
		System.out.print("배수: ");
		int num2 = sc.nextInt();
		
		System.out.println();
		
		System.out.printf("%d는 %d의 배수? %b \n", num1, num2, num1 % num2 == 0);

		
		System.out.println("---------------------------------------");
		
		System.out.println("[배수 확인 프로그램]");
		
		System.out.print("확인 할 수: ");
		int num3 = sc.nextInt();
		
		System.out.print("배수: ");
		int num4 = sc.nextInt();
		
		System.out.println();
		
		
		boolean result = num3 % num4 ==0;
		System.out.printf("%d은 %d의 배수? %b \n", num3, num4, result);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
