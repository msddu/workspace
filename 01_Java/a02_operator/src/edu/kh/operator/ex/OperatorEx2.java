package edu.kh.operator.ex;

public class OperatorEx2 {
	
	public static void main(String[] args) {
		//main 자동완성 -> main작성 후 -> ctrl + 스페이스바 
	    //println 자동완성 -> syso 작성후  ctrl + 스페이스바  
		//(피연산자: 연산을 당하는 변수나 값)
		
		
		
		System.out.println("[전위연산]");
		
		
		System.out.println("증가 연산 테스트");
		int num1 = 5;
		
		System.out.println(num1); //5
		System.out.println(++num1); //6
		System.out.println(++num1); //7
		System.out.println(++num1); //8
		System.out.println(++num1); //9
		
		
		System.out.println("감소 연산 테스트");
		int num2 = 10;
		
		System.out.println(num2); //10
		System.out.println(--num2); //9
		System.out.println(--num2); //8
		System.out.println(--num2); //7
		System.out.println(--num2); //6
		
		
		

		System.out.println("-------------------------");
		
		System.out.println("[후위연산]");
		
         // 후위 연산은 우선 순위가 제일 마지막이다!!!
		
		System.out.println("증가 연산 테스트");
		int num3 = 20;
		
		System.out.println(num3);  //20
		System.out.println(num3++);//20 출력 후 21로 증가
		System.out.println(num3++); //21출력 후 22로 증가
		System.out.println(num3);

		
		
		System.out.println("감소 연산 테스트");
	    int num4 = 99;
	    System.out.println(num4--); //99
	    System.out.println(num4--); //98
	    System.out.println(num4--); //97
	    System.out.println(num4--); //96
	    System.out.println(num4--); //95
	    
	    
	    
	    
	    System.out.println("----------------------------");
	    
	    int a = 3;  
	    int b = 5;
	    int c = a++ + --b; //a = 4, b = 4, c = 7
	    System.out.printf("a = %d, b = %d, c = %d", a, b, c);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
		
   
		
		
		
		
		
	}

}
