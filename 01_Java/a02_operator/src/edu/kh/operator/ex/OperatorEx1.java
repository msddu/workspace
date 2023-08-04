package edu.kh.operator.ex;

import java.util.Scanner;//Scanner가져옴

public class OperatorEx1 {
	
	public static void main(String[]args) {
		
		
		
	//산술 연산자
	// +  -  *  /  %(mod ,나머지 연산) 

	//두 수를 입력받아 
	// + - * / 연산 결과를 모두 출력
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수입력1:");
		int input1 = sc.nextInt();
		
		System.out.print("정수입력2:");
	    int input2 = sc.nextInt();
	    
	    System.out.println();
	    
	    System.out.print(input1 + " + " + input2 + " = " + (input1 + input2) );
	    
	    System.out.println();
	    
	    
	    
	    
	    
	    //-연산
	    
	    int minusresult = input1- input2;
	    System.out.println(input1 + " - " + input2 + " = " + minusresult );
	    
	    
	    //*연산(printf 사용)
	    // %d : 10진수 정수
	    // %f : 10진수 실수
	    // %.1f : 소수점 아래 1자리
	    // %.2f : 소수점 아래 2자리
	    // %.3f : 소수점 아래 3자리
	   
	    
	    /*System.out.printf("빈칸이 포홤된 문자열", 빈칸에 들어갈 값);*/
	    int result = input1 * input2;
	    System.out.printf("%d * %d = %d", input1, input2, result);
	    
	    System.out.println();
	    
	    
	   
	    int result2 = input1 / input2;
	    System.out.printf("%d / %d = %d" , input1, input2, result2);
	    
	    System.out.println();
	    
	    
	    System.out.printf("%d / %d = %.2f" , input1, input2, (double)input1 / input2);
	    // (5/2)의 결과가 2.5가 아닌 2인이유
	    //컴퓨터의 값 처리 원칙에 의해 int/int = int 이기 때문에 결과는 2가 된다.
	    
	    //[5/2의 결과가 2.5가 나오게 하려면...]
	    //input1 또는 input2를 (double)로 강제 형변환 하면 된다
	    //(double)input1 / input2
	    //-> doble / int -> double/double
	    
	    
	    
	   
	   System.out.println();
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		// %(나머지)연산 -> 몫이 정수로 다 나눠진 후 나머지가 출력
	    
	    System.out.printf("%d %% %d = %d", input1, input2, input1 % input2);
	    //  %% -> printf에서 문자열 "%"를 의미하는 기호
	    
	   
	    
	    
	    
	    
	    
	    
	} 

}
