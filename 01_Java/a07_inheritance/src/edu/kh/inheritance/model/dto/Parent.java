package edu.kh.inheritance.model.dto;

       /*상속불가*/
public /*final*/ class Parent {

	private int money = 100_000_000;
	private String lastName = "홍";
	
	public Parent() {
		System.out.println("parent() 기본 생성자로 부모 객체 생성");
		
		
		
	}
	
	public Parent(int mony, String lastName) {
		
		System.out.println("Parent(int, Stirng)매개변수 생성자로 부모객체 생성");
		
		this.money = money;
		this.lastName = lastName;
		
	
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	//toString(): 객체의 필드를 하나의 문자열로 반환
	@Override //object의 toString() 오버라이딩
	public String toString() {
		return money + "/" + lastName;
	}
}


//final 자료형 변수명;   -> 상수
//public final calss 클래스명  -> 상속 불가
//public final void 메서드명() -> 오버라이딩 불가



