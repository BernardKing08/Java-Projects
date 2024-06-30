package Control_Flow.EvenDigitSum;

public class EvenDigitSum {
    // write code here
    public static int getEvenDigitSum(int number){
        int temp = number;
        int value = 0; 
        int sum = 0;

        if(number >= 0){
            while(temp > 0){
                value = temp % 10;

                if(value % 2 == 0)
                    sum += value;
                    
                temp /= 10;
            }

            return sum;
        }
        else{
            return -1;
        }

    }
}
