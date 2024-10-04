package Arrays;

import java.util.Random;
import java.util.Arrays;

public class ArrayProjects2 {
    //Working eith java.util.Arrays methods

    public static void main(String[] args) {
        
        int[] firstArray = getRandomArray(10); 
        System.out.println(Arrays.toString(firstArray));

        //sorting the array
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        //using array.fill method
        int[] secondaryArray = new int[10];
        Arrays.fill(secondaryArray, 5);
        System.out.println(Arrays.toString(secondaryArray));

        //using copyOf method 
        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length); //takes the array to copy and a new length as argument
    }

    private static int[] getRandomArray(int len){
        //creating a random number using the random class
        Random random = new Random();
        //creating an array with method member parameter as length
        int[] newInt = new int[len];

        //generating a random number with upper bound of 100 and assigning it to the newInt array index
        for(int i = 0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}
