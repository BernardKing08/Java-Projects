package Control_Flow.ReadingUserInput;

import java.util.Scanner;

public class ReadingUserInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1; 
        int sum = 0;
        String value;

        while(count <= 5){
            System.out.print(count + ") Enter a valid Number: ");
            value = sc.nextLine();

            try{
                double num = Double.parseDouble(value);
                sum += num;
                count++;
            }
            catch(Exception ex){
                System.out.println("Enter a valid number");
            }
        }

        System.out.println("The sum is: " + sum);

        sc.close();
    }
}
