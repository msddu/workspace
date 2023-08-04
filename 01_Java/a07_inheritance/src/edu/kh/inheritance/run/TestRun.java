package edu.kh.inheritance.run;

import edu.kh.inheritance.model.dto.Child1;
import edu.kh.inheritance.model.dto.Child2;
import edu.kh.inheritance.model.dto.Parent;

public class TestRun {
	
	public static void main(String[] args) {
		
		
		//부모 객체 생성
		Parent p1 = new Parent();   //ctrl + shift + o : import 구문 자동 추가
        Parent p2 = new Parent(100, "하");
        
        
        System.out.println("------------------");
        
        Child1 c1 = new Child1("제네시스 G70");
        		
        Child2 c2 = new Child2("시그니엘");
        
        
        Child2 c3 = new Child2(900, "김", "원룸");
    	System.out.println(c3.getMoney());   //parent
    	System.out.println(c3.getLastName());//parent
    	System.out.println(c3.getHouse());   //Child2
    	
        //자식 객체를 생성했기 때문에
        //자식의 생성자가 실행되는건 이해되는데 
        //왜 부모의 기본 생성자가 같이 실행이 됐을까
        
        /*자식이 부모로 부터 상속 받은 멤버(필드,메서드) 사용*/
        
        
        //아무리 상속받았다고 해도 private은 직접 접근이 불가능하다!
        //(부모님의 개인적인 것을 마음대로 건드릴수 없다)
        //c1.money = 10;
        
        //대신 간접 접근 방법 getter/ setter 이용 가능
        
        System.out.println(c1.getMoney());
        
        System.out.println(c1.getLastName());
        
        
        //자식의 toString 호출
        
        System.out.println(c1.toString());
        
        System.out.println(c3.toString());
       
        
	
	
	}
	
	

}
