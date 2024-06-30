package Control_Flow.GreatestCommonDivisor;

public class GreatestCommonDivisor {
    // write code here
    public static int getGreatestCommonDivisor(int first, int second){

        if((first >=10) && (second >=10)){
            int temp = 1;
            int HCF = 0; 

            while((temp < first) || (temp < second)){
                if((first % temp == 0) && (second % temp == 0))
                    HCF = temp;
                
                temp++;
            }
            return HCF;
        }
        else
            return -1;
    }
}