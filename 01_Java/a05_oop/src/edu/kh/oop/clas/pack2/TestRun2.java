package edu.kh.oop.clas.pack2;


public class TestRun2 {
	
	public static void main(String[] args) {
		
		//classTest1 객체 생성
		//->다른 패키지
		//패키지가 다른 클래스를 접근하고자 할 때 import라는 작업을 해서 가져와 사용
		
		//public은 어디서든 접근해 가져가서 사용 가능하다라는 말
		
		//ClassTEST2 객체 생성
		ClassTest2 c2 = new ClassTest2();
		//(default) 접근 제한자 : 같은 패지키 에서 접근 가능
		//같은 패키지 import 필요없음
		
		c2.method2();
		
		
	}

}
