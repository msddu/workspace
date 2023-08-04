package edu.kh.oop.calc;


//계산기
public class Calculator {
	
	private final double PI = 3.141592;
	private final int MAX_VALUE = 1_000_000_000;
	private final int MIN_VALUE = -1_000_000_000;
	
	private double saveValue; //값 저장용 필드
	
	//기본 생성자
	public Calculator() {}
	
	//saveValue setter
	public void setSaveValue(double saveValue) {
		this.saveValue = saveValue;
	
	}
	
	//saveValue의 getter
	public double getSaveValue() {
		return saveValue;
		
	}

	
	//계산기의 기능(더하기)
	
	public double plus(double number) {
		
		saveValue += number;
		return saveValue;
	
		
	}
	//빼기
	public double minus(double number) {
		
		saveValue -= number;
		return saveValue;
		
	}
	//곱하기
    public double multi(double number) {
		
		saveValue *= number;
		return saveValue;
		
	}
	//나누기
    public double div(double number) {
    	
    	if(number == 0) { //0으로 나누면 오류가 나기 때문에 입력값이 0이면 
                          //saveValue를 0으로 만든 후 saveValue 반환
    		saveValue = 0;
    		return saveValue;
    	}
		
	    saveValue /= number;  //입력값이 0이 아닌경우
		return saveValue;
		
	}
    
    //초기화 기능
    public double init() {
    	saveValue = 0;
    	return saveValue;
    }
    
    
    //최대값으로 변경
    public double changeMaxValue() {
    	saveValue = MAX_VALUE;
    	return saveValue;
    }
    
    //최소값으로 변경
    public double changeMinValue() {
    	
    	saveValue = MIN_VALUE;
    	return saveValue;
    }
    
    //원의 넓이 : PI * 반지름의 제곱
    public double theAreaOfACircle(double r) {
    	saveValue = PI * r * r;
    	return saveValue;
    }

}
