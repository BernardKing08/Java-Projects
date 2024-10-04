package Control_Flow.AllFactors;

public class FactorPrinter {
    // write code here
    public static void printFactors(int number){

        if(number >= 1){
            int temp = 1;
            while(temp <= number){
                if((number % temp) == 0){
                    System.out.println(temp);
                }
                
                temp++;
            }
        }
        else 
            System.out.println("Invalid Value");
    }
}
