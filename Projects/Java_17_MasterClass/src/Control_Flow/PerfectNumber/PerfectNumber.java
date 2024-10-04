package Control_Flow.PerfectNumber;

public class PerfectNumber {
    // write code here
    public static boolean isPerfectNumber(int number){
        if(number > 1){

            int temp = 1;
            int sum = 0;

            while(number > temp){
                if(number % temp == 0)
                    sum +=temp;
                temp++;
            }

            if(number == sum)
                return true;
            else
                return false;

        }
        else{
            return false;
        }



    }
}