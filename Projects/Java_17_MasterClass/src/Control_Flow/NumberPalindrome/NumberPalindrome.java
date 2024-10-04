package Control_Flow.NumberPalindrome;

public class NumberPalindrome {
    public static boolean isPalindrome1(int number){
        int value = number;
        
        if(value < 0)
            value *= -1;
              
        StringBuilder sb = new StringBuilder((String.valueOf(value)));
        
        if((Integer.toString(value)).equals(sb.reverse().toString())){
            return true; 
        }
        else{
            return false;
        }
    }


    public static boolean isPalindrome(int number) {
        // Store the original number
        int originalNumber = number;
        
        // A negative number cannot be a palindrome
        if (number < 0) {
            number = -number;  // Make the number positive for reverse comparison
        }

        // Variable to store the reversed number
        int reverse = 0;

        // Loop to reverse the number
        while (number > 0) {
            // Extract the last digit of the number
            int lastDigit = number % 10;

            // Increase the place value of reverse and add lastDigit to reverse
            reverse = reverse * 10 + lastDigit;

            // Remove the last digit from the number
            number = number / 10;
        }

        // Check if the original number and the reversed number are equal
        if (originalNumber < 0) {
            originalNumber = -originalNumber;  // Convert to positive for comparison
        }

        return originalNumber == reverse;
    }
    
    
}
