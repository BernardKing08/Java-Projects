package Arrays.Challanges.MinimunElement;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {
    public static void main(String[] args) {
        int[] returnedArray = readInteger(2);
        System.out.println(Arrays.toString(returnedArray));

        int returnedMin = findMin(returnedArray);
        System.out.println("min = " + returnedMin);

    }

    private static int[] readInteger(int num){
        System.out.println("Enter numbers");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        //splits the array using a delimeter ","
        String[] splits = input.split(",");
        int[] values = new int[splits.length];

        for(int i = 0; i < splits.length; i++){
            //converting from a String to an integer using the 
            //parseInt and removing extra spaces using the trim()
            values[1] = Integer.parseInt(splits[i].trim());
        }

        //returning the an int type
        return values;
    }
   

    private static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;

        for(int el : arr){
            if(el < min){
                min = el;
            }
        }

        return min;
    }
}
