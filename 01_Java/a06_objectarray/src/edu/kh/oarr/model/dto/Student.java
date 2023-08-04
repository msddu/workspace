package edu.kh.oarr.model.dto;

public class Student {
	
	private int grade;
	private int ban;
	private int number;
	
	private String name;
	
	private int kor;
	private int eng;
	private int math;
	
	//생성자
	
	//기본 생성자 : 접근제한자 + class명{ }
	public Student() { }
	
	//매개변수 생성자 : 오버로딩
	public Student(int grade, int ban, int number, String name) {
		
		this.grade = grade;
		this.ban = ban;
		this.number = number;
		this.name = name;
		
	}
	
	//getter : 필드의 값을 가져갈 수 있도록 설정
	
	public int getGrade() {
		return grade;
	}
	// setter : 외부의 값을 필드로 가져올수 있도록 설정
	
	public void setGrade(int grade) { //(전달받을 값을 저장할 매개변수)
		this.grade = grade;          //전달받은 값을 this.grade에 저장
	}
	
	
	public int getBan() {
		return ban;
	}
	
	public void setBan(int ban) {
		this.ban = ban;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
	//alt + shift + s  -> r(Generate Getter and Setter)
	
	
	
	//필드를 하나의 문자열로 만들어 반환하는 메서드
	public String toString() {
		//toString : 객체의 필드 값을 하나의 문자열로 반환
		return String.format("%d학년 %d반 %d번 %s [%d, %d, %d]" , grade , ban, number, name, kor, eng, math);
	}

}
