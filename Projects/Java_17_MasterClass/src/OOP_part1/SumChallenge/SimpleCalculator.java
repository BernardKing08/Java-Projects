package OOP_part1.SumChallenge;

public class SimpleCalculator {
    public double firstNumber;
    public double secondNumber;
    
    
    
    public double getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}
	public double getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}
	
	public double getAdditionResult(){
		//returns the addition of the 2 numbers
		return firstNumber + secondNumber; 		
	}
	
	public double getSubtractionResult(){
		//returns the addition of the 2 numbers
		return firstNumber - secondNumber;
	}
	
	public double getMultiplicationResult(){
		//returns the addition of the 2 numbers
		return firstNumber * secondNumber;
	}
	
	public double getDivisionResult(){
		if(secondNumber == 0)
			return 0;
		
		//returns the addition of the 2 numbers
		return firstNumber / secondNumber;
	}
	

	
    
}
