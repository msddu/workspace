package edu.kh.exceprion.model.dto;

//사용자 정의 예외
//자바에서 제공하지 않는 예외를 직접 만드는 방법

//1. Exception클래스 아무거나 상속 받기
//    단, Unchecked 로 만들고 싶으면 RuntimeException관련 예외 상속 받기
//2. 생성자 만들기
public class UserException extends Exception {
	
	public UserException() {
		super("사용자 정의 예외 발생");
	}
	
	public UserException(String message) {
		super(message);
	}
	

}

