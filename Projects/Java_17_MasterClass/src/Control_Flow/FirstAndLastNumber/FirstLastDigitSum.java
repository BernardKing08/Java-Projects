package Control_Flow.FirstAndLastNumber;

public class FirstLastDigitSum {
    // write code here
    public static int sumFirstAndLastDigit(int number){
        
        int lastNumber = number % 10;

        if(number >= 0){
            int firstNumber  = number;
            while(firstNumber >= 10){
                firstNumber /= 10;
            }
            return firstNumber + lastNumber;
        }
        else
            return -1;
        
    }
    
}