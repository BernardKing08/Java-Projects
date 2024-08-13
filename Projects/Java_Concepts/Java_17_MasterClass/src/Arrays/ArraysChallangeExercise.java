package Arrays;

import java.util.Arrays;
import java.util.Random;

public class ArraysChallangeExercise {
    //creating an array that sorts a list of integers in descending order

    public static void main(String[] args) {
        //initializing the array
        int[] myArr = getRandomArray(5);

        //printing out the original array to the screen
        System.out.println("Original array: " + Arrays.toString(myArr));

        //sorts the array in ascending order
        Arrays.sort(myArr);

        //sorting the array in descending order
        int[] myArr2 = new int[myArr.length];
        for (int i = 0; i < myArr.length; i++) {
            myArr2[i] = myArr[myArr.length - 1 - i];
        }

        //printing the sorted array in descending order
        System.out.println("Sorted array in descending order: " + Arrays.toString(myArr2));
    }

    public static int[] getRandomArray(int length) {
        //generating a random number
        Random random = new Random();
        
        //initializing the array
        int[] localArray = new int[length];

        //generating random number in the array
        for (int i = 0; i < length; i++) {
            localArray[i] = random.nextInt(10);
        }

        //returning the array
        return localArray;
    }
}
