package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx {

        
	
	
	
	 /*for문
	  * -끝이 정해져 있는 경우에 사용하는 반복문
	  * (몇번 반복할지 알고 있을 때 사용한다)
	  * 
	  * [작성법*/
	
	   //for 예제 1
	public void ex1() {
		
		//안녕하세요 10번 출력하기
		
		
		for(int i=1; i<=10; i++) {
			System.out.printf("안녕하세요\n");
		}
		
		
		
		
	}
	
	
	 //for 예제 2
	public void ex2() {
		
		//1부터 10까지 출력하기
		
		for(int i = 1; i<=10; i++) {
			System.out.println(i);
		}
		
		
		
		
	}
	//for 예제 3
	public void ex3() {
		
		
		
		//3부터 8까지 출력
		
		for(int i = 3; i <= 8; i++) {
			System.out.println(i);
		}
		
		
		
		
		
	}
	 //for문 예제 4
	public void ex4() {
		
		
		//2부터 20까지 출력
		
		for(int i = 2; i <= 20; i+=2) {
			System.out.println(i);
		}
		
	
	}
	//for문 예제 5
	public void ex5() {
		
		
		//1부터 10까지 정수의 합 구하기
		
		int sum = 0;
		for(int i=1 ; i<=10; i++) {
			sum += i;
		}
		System.out.println("합계:" + sum);
		}
	
	
	//for 예제 6
	public void ex6() {
		
		//50부터 100까지의 모든 정수의 합 출력
		
		int sum = 0;
		for(int i = 50; i <= 100; i++) {
			sum += i;
		}
		System.out.println("합계:" + sum);
		
		
		
		
	}
	
	//for 예제 7
	public void ex7() {
		
		//3부터 30까지 3씩 증가하며 출력
		//출력되는 수들의 합을 마지막에 출력
		
		int sum = 0;
		for(int i =3; i<=30; i+=3) {
			sum = sum+=i;
			System.out.println("증가하며 출력:" + i);
		}
		    System.out.println("합계:" + sum);
	}
	
	//시작, 끝, 증가할 수를 입력 받아 
	//지정된 범위까지 모두 출력 후
	//합계도 출력
	
	//시작: 1
	//끝: 5
	//증가할 수: 2
	//1 3 5
	//합계 : 9
	public void ex8() {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시작:");
		int start = sc.nextInt();
		
		System.out.print("끝:");
		int end = sc.nextInt();
		
		System.out.print("증가할 수:");
		int step = sc.nextInt();
		
		int sum = 0;
		for(int i = start; i <= end; i+=step ) {
			System.out.print(i + " "); //옆으로 출력
			sum+=i;
		}
		 System.out.println("\n합계:" +sum);

		
	}
	
	//1부터 10까지 모든 정수 출력
	//단, 짝수는 []감싸서 출력
	
	//1 [2] 3 [4] 5 [6] 7 [8] 9 [10]
	public void ex9() {
		
		for(int i = 1; i <=10; i++) {
			
			if(i % 2 == 0) {
				System.out.printf("[%d]" , i);

			}else {
				System.out.printf("%d" , i);
				
     }
			
			
			
			
    }
   }
	public void ex10() {
		//1부터 10까지 모든 정수출력
		//단, 홀수는 ()감싸서 출력
		//+1은 "시작" 10은 "끝"이라고 출력
		
		//시작 2 (3) 4 (5) 6 (7) 8 (9) 끝
		
		for(int i = 1; i <=10; i++) {
			if(i == 1) {
				System.out.print("시작");
				
			}else if(i ==10) {
				System.out.print("끝");
				
			}else if(i % 2 != 0) {
				
				System.out.printf("(%d)", i);
				
			}else
				System.out.printf("%d", i);
		}
		
		 
		
		
	}
	
	public void ex11() {
		//1부터 20까지 1씩 증가하는 반복문을 이용해 
		//짝수의 합, 홀수의 합을 구해서 출력
		int sum = 0;
		int sun = 0;
		for(int i = 1; i <=20; i++) {
			if(i % 2 == 0) {
				sum = sum + i;
				
			}else {
				sun = sun+ i;
		   }
		
		}
		System.out.println("짝수의 합:" + sum);
		System.out.println("홀수의 합:" + sun);

	
		
	}	
	
	
	public void ex12() {
		
		//(1부터 100까지 1씩 증가하는 반복문을 이용)
		//1~100까지 사이의 수 중 입력받은 수의 배수를 뺀 나머지 수의 합을 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수를 입력하세요:");
		int input = sc.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i <=100; i++) {
			if(i % input == 0) {
				continue;
			}else
				sum = sum + i;
			
		}
		
		System.out.println(sum);
	}
	
	
	
	
	
	
	
	
	
		
   	
}	




	
	

