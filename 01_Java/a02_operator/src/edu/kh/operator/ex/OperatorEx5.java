package edu.kh.operator.ex;

public class OperatorEx5 {
	
	public static void main(String[] args) {
		
		/*
		int iNum1 = 10;
		int iNum2 = 4;
		float fNum = 3.0f;
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum1 / iNum2);
		
		System.out.println((int)dNum);
		
		System.out.println((double)iNum1);
		System.out.println(iNum2 * dNum);
		
		System.out.println((int)fNum);
		System.out.println(iNum1 / (int)fNum);
		
		
		System.out.println(iNum1 / fNum);
		System.out.println((double)iNum1 / fNum);
		
		System.out.println((int)ch);

		System.out.println(iNum1 + ch);
		
		
		System.out.println((char)75);
		
		System.out.println((char)(iNum1 + ch));
		
		
		
		
		
		*/
		
		
		
		//  AND연산자 (&&)
		// - 둘 다 true이면 true, 나머진 false
		//- -~와, 그리고(이고), 이면서(면서), 부터, 까지, 사이
		
		//104는 100 이상이면서 짝수인가
		
		
		boolean result1 = (104 >= 100) && (104 % 2 == 0);
		System.out.println("104는 100 이상이면서 짝수인가?:" + result1 );
		
		int Num2 = 50;
		boolean result2 = (Num2 <= 50) && (Num2 % 3 == 0);
		System.out.println("Num2는 50 이하이고 3의 배수인가?:" + result2);
		
		
		
		int Num3 = 67;
		boolean result3 = (1<=Num3) && (Num3 <= 100);
		System.out.println("Num3는 1부터 100사이의 정수인가?: " +  result3);
		
		
		//------------------------------------------------------------------------------
		
		
		// OR연산자(||): 둘다 false이면 false, 아니면 true
		// - 또는, ~이거나(거나)
		
		int Num4 = 20;
		boolean result4 = (Num4 > 10) || (Num4 % 3 == 0);
		System.out.println("Num4는 10을 초과하거나 홀수인가?:" + result4);
		
		
		
		int Num5 = 51;
	    boolean result5 = ( (0 <= Num5) && (Num5 <= 50) ) || (Num5 < 0);
		System.out.println("Num5는 0이상 50이하의 수 또는 음수인가?:" + result5);
		
		//-------------------------------------------------------------------------------
		
		//논리 부정(NOT) 연산자 (!)
		// - 논리 값을 반대로 바꾸는 연산자
		
	    System.out.println(!true);
	    System.out.println(!false);
	    
	    
	    
	    int Num6 = 11;
	    boolean result6 =  Num6 % 2 == 0;
	    System.out.println("Num6는 짝수인가?:" + result6);
	    System.out.println("Num6는 홀수인가?:" + !result6);
	    
	    
	    
	    
	    
	    int Num7 = 30;
	    boolean result7 =( (1 <= Num7) && (Num7 <= 50 ) ) && !(Num7 % 5 == 0); 
	    System.out.println("Num7은 1부터 50까지 정수 이면서 5의 배수가 아닌 수?:" + result7);
	  
	    
	    
	    
	    
	    
	    
	    
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
