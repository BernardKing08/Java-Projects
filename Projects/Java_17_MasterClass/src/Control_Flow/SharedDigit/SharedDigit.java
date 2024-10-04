package Control_Flow.SharedDigit;

public class SharedDigit {
    // write code here
    public static boolean hasSharedDigit(int number1, int number2){

        int temp1 = number1;
        int temp2 = number2;
        int firstDigit = 0;
        int firstDigit2 = 0; 
        int lastDigit = 0;
        int lastDigit2 = 0;

        if((number1 > 9 && number1 <= 99) && (number2 > 9 && number2 <= 99)){
            firstDigit = temp1 / 10; 
            firstDigit2 = temp2 / 10;

            lastDigit = temp1 % 10; 
            lastDigit2 = temp2 % 10;

            if(firstDigit == firstDigit2 || firstDigit == lastDigit ||
            lastDigit == firstDigit2 || lastDigit == lastDigit2)
                return true;
            else
                return false;
        }
        else 
            return false; 
        

        
    }
}