package edu.kh.oop.calc2;

public class Calculator2 {
	
	
	
	
	
    private double saveValue; 
    
    
   
public Calculator2() {
		
	}
    
    
   
    public double plus(double number) {
    	
    	 saveValue += number;
    	 return saveValue;
    }
    
    
    public double getSaveValue() {
		return saveValue;
	}


	public void setSaveValue(double saveValue) {
		this.saveValue = saveValue;
	}


	
    public double minus(double number) {
    	saveValue -= number;
    	return saveValue ;
    }
    
    public double init() {
    	saveValue = 0;
    	return saveValue;
    }
    
   
    public  double multi(double number) {
    	saveValue *= number;
    	return saveValue;
    }
    
    
    
	

	
	
	
	
}
