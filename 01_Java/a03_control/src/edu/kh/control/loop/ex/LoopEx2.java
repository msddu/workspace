package edu.kh.control.loop.ex;

import java.util.Scanner;

public class LoopEx2 {
	
	
	//구구단 2단 출력하기
	//2 x 1 =2
	//2 x 2 =4
	//2 x 3 =6
	//2 x 4 =8
	//2 x 5 =10
	//2 x 6 =12
	//2 x 7 =14
	//2 x 8 =16
	//2 x 9 =18

	public void ex1() {
		
		for(int i = 1; i <=9; i++) {
			System.out.printf("2 x %d =  %d\n" , i, 2*i);
		}
	}

	//입력 받은 단 출력하기
	
	//단 입력 : 3
	//[구구단 3단]
	//3 x 1 = 3
	//3 x 2 = 6
	//3 x 3 = 9
	public void ex2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력:");
		int dan = sc.nextInt();
		
		System.out.printf("\n[구구단 %d 단]\n" , dan);
		
		for(int i= 1; i<=9; i++) {
			System.out.printf("%d x %d = %d\n" , dan , i , dan*i);
		}
	
		
	}
	
	// 입력 받은 단 출력하기
	//조건 : 입력 받은 값이 2~9사이 일때만 구구단 출력
	//      2~9사이가 아닐 경우 "잘못 입력 하셨습니다." 출력
	public void ex3() {
		
		
        Scanner sc = new Scanner(System.in);
		
		System.out.print("단 입력:");
		int dan = sc.nextInt();
		
		System.out.printf("\n[구구단 %d 단]\n" , dan);
		
		if(dan >= 2 || dan > 9) {
			System.out.println("잘못 입력 하셨습니다.");
		}
			else {
				for(int i= 1; i<=9; i++) {
					System.out.printf("%d x %d = %d\n" , dan , i , dan*i);
				}
			}
		
			
		
		}
		
	
	
		//5 4 3 2 1 출력하기(반복문 사용)
		public void ex4() {
			
			for(int i = 5; i >= 1; i--) {
				System.out.print(i);
			}
			
			
			
			
			
			
			
		}
		
		// 9 8 7 6 5 4 출려하기
		public void ex5() {
			
			for(int i = 9; i>=4; i--) {
				System.out.print(i);
			}
			
			
			
			
			
			
			
			
			
			
		}
		/*중첩 반복문
		 * 
		 *12345
		 *12345
		 *12345*/
		public void ex6() {
			//5회 반복
			for(int j = 1; j <=5; j++) {
			    //5회 반복하면서 12345 출력
				for(int i = 1; i<=5; i++) {
				   System.out.print(i);
			   }
				System.out.println();
			}
			
		}
		// 54321
		// 54321
		// 54321
		// 54321
		public void ex7() {
			
			for(int j = 1; j <=4; j++) {
			   
				for(int i = 5; i >= 1; i--) {
				   System.out.print(i);
			   }
				System.out.println();
			
			
			
		}
		
	
		
		}
		
		//(0,0) (0,1) (0,2)
		//(1,0) (1,1) (1,2)
		
		public void ex8() {
			
			for(int j = 0; j < 2; j++) {
				for(int i = 0; i<3; i++) {
					System.out.printf("(%d,%d)",j,i);
				}
				System.out.println();
				
		     	}
			

			
			
			
		}
		
		//2단부터 9단까지 모두 출력하기
		public void ex9() {
			
			for(int j = 2; j <=9; j++) {
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d x %d = %d\n", j, i, j*i);
				}
			System.out.println("----------");
			
			}
			
		}
		
		
		public void ex10(){
			
			for(int j = 9; j >=2; j--) {
				System.out.printf("[%d단]\n", j);
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d x %d = %d\n", j, i, j*i);
				}
				System.out.println("----------");
			
			
			}
		}	
			
			
	
		//구구단 출력하기
		//[조건]
		//1 입력 시 2~9 순서로 출력
		//2 입력 시 9~2 순서로 출력
		//1,2가 아니면 "잘못 입력하셨습니다." 출력
			public void ex11() {
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("1) 2-9순서대로  /  2) 9-2역순으로 : "); // 1 or 2
				int input = sc.nextInt();
				
				switch(input) {
				case 1 :   
					for(int dan = 2 ; dan <= 9 ; dan++) {
						System.out.printf("[%d단]\n", dan); // 제목
						
						for(int i = 1 ; i <= 9 ; i++) {
							System.out.printf("%d x %d = %d \n", dan, i , dan*i);
						}
						System.out.println("------------------");
					}
					break;
				
				case 2 :	
					
					for(int dan = 9 ; dan >= 2 ; dan--) {
						System.out.printf("[%d단]\n", dan); // 제목
						
						for(int i = 1 ; i <= 9 ; i++) {
							System.out.printf("%d x %d = %d \n", dan, i , dan*i);
						}
						System.out.println("------------------");
					}
					
					break;
				
				default : System.out.println("잘못 입력 하셨습니다");
				}
		}

		
			
			//count 변수 이용하기
			
			//1 2 3
			//4 5 6
			//7 8 9
			public void ex12() {
				
				int count = 0; //안쪽 for문이 반복할 때 마다 1씩 카운트
				//1행, 2행, 3행
				for(int row = 1; row <=3; row++) {
					//1열, 2열, 3열
					for(int column = 1; column <=3; column ++) {
						count++;//열(칸)을 방문할 때 마다 1씩 증가
						System.out.print(count + " ");
					}
					System.out.println();
					
				}
				
			}
			
			
			public void ex13() {
				
				int count = 0;
				//2중 for문 사용
				for(int row = 1; row <=3; row++) {
					for(int col = 1; col <=4; col++) {
						count++;
						System.out.print(count + " ");
					}
					System.out.println();
				}
				
				System.out.println("----------------------");
				
				//단일 for문 + if문
				
				for(int i = 1; i <=12; i++) {
					System.out.print(i + " ");
					
					if( i % 4 == 0) {
						System.out.println();
					}
				}
				
			
				}
			
			public void ex14() {
				
				
				//행,열의 크기를 입력받아 출력하기 + count
				
				Scanner sc = new Scanner(System.in);
				
				System.out.print("행:");
				int row = sc.nextInt();
				
				System.out.print("열:");
				int col = sc.nextInt();
				
				int count = 0;
				//초기식, 조건식, 증감식은 상황에 따라서 
				//늘어나거나 작성하지 않을 수 있다.
				
				//for(; ;) -> 무한루프
				
				//초기식 작성x -> 대신 row,col(입력 받은 값) 사용
				for( ; row >=1; row--) {
					
					for(int y = col;  y >= 1 ; y-- ) {
						System.out.print(++count + " ");
						
					}
					System.out.println();
				}				
				
			}
			
			
			//1
			//12
			//123
			//1234
			
			//줄(행)이 증가할 때 마다 
			//칸(열)이 같은 수로 증가
			public void ex15() {
				
				
				for(int row = 1; row <=4; row++) {
					
					
					for(int col = 1; col <= row; col++) {
						
						System.out.print(col + " ");
					}
					System.out.println();
				 
				}
				
				
				
			
					
					
					
				}
				
				
				
				
				
			public void ex16() {
				
				
				
				for(int row = 4; row >= 1; row--) {
					
					for(int col = 1; col <= row; col++) {
						
						System.out.print(col + " ");
					}
				System.out.println();
				}
				
				
			}
			
			//4321
			//321
			//21
			//1
			public void ex17() {
				
				for(int row = 1; row <= 4; row++ ) {
					
					for(int col = 5-row; col >= 1; col--) {
						System.out.print(col + " ");
					}
					System.out.println();
				}
				
				
				
				
				
				
				
				
				
			}
			
			//4
			//43
			//432
			//4321
			
			public void ex18() {
				
				
				
				for(int row = 4; row >= 1; row--) {
					
					for(int col = 4; col >= row ; col-- ) {
						System.out.print(col + " ");
					}
					System.out.println();
				}
				
				
				
				
				
			}
			
			
			
			
			
				
}
			
			
				
				
	
	

