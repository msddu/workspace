package edu.kh.poly.model.dto;

//Car를 상속 받은 자식 클래스 Porsche
public class Porsche extends Car {
	
	private boolean openTheDoor;

	
    public Porsche() {
	// TODO Auto-generated constructor stub
}


	public Porsche(boolean openTheDoor) {
	super();
	this.openTheDoor = openTheDoor;
    }

	public Porsche(int i, int j, String string) {
		// TODO Auto-generated constructor stub
	}


	public boolean isOpenTheDoor() {
		return openTheDoor;
	}
	
	public void setOpenTheDoor(boolean openTheDoor) {
		this.openTheDoor = openTheDoor;
	}


	//Car의 toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + "Porche [openTheDoor=" + openTheDoor + "]";
	}
	
	
	
}
