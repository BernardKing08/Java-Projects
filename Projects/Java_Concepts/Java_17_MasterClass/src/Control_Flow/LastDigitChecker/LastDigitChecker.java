package Control_Flow.LastDigitChecker;

public class LastDigitChecker {
    public static boolean hasSameLastDigit(int number1, int number2, int number3){
        
        if(isValid(number3) && isValid(number2) && isValid(number1)){
            return (((number1 % 10) == (number2 % 10)) || ((number1 % 10) == (number3 % 10)) || ((number3 % 10) == (number2 % 10)));
        }
        else
            return false;
        
    }

    public static boolean isValid(int number){
        if((number >= 10) && (number <= 1000))
            return true;
        else 
            return false;

    }
}
