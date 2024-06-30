package Control_Flow.MinMaxChallange;

import java.util.Scanner;

public class MinMaxChallange {
    public static void main(String[] args) {
        boolean bool = true;

        Scanner sc = new Scanner(System.in);
        

        double minValue = 0;
        double maxValue = 0;
        Double num;

        while(bool){
            System.out.println("Enter a number or any character to quit");
            String str = sc.nextLine();

            try{
                num = Double.parseDouble(str);

                if(num > maxValue){
                    maxValue = num;
                }
                else if(num < minValue){
                    minValue = num;
                }

            }catch(Exception ex){
                bool = false;    
            }

        }

        System.out.println("The max value is: " + maxValue);
        System.out.println("The min value is: " + minValue);
        
        sc.close();
    }

    
}
