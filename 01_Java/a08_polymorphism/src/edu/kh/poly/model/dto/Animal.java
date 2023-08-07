package edu.kh.poly.model.dto;

//추상 클래스(abstract class)
//-미완성 부분(추상 메서드)이 포함된 클래스
//미완성이다 보니 단독 객체로 생성 불가능...!

//(단, 추상 메서드가 없어도 추상 클래스로 선언 가능)
public abstract class Animal {
	
	private String type;  //종, 류(양서류, 포유류, 갑각류...)
	private String eatType; // 식성(초식,잡식,육식)
	
	public Animal() {
		super(); //object생성자 호출
	}

	public Animal(String type, String eatType) {
		
		this.type = type;
		this.eatType = eatType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}

	@Override
	public String toString() {
		return type + "/" + eatType;
	}
	
	//abstract : 추상적인
	//abstract method(추상 메서드)
	//->몸체(메서드 정의)가 없는 메서드
	//-> 상속받은 자식에 따라 코드가 달라져야 하기 때문에
	//->자식 클래스에서 오버라이딩이 강제화
	public abstract void breath();
	

	
	
	
	
	
	
	
	
	

}
