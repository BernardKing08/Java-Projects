package Arrays;

import java.util.Arrays;

//Shoeing reference types vs Value types
public class ArraysReference {


    public static void main(String[] args) {
        //original array 
        int[] myIntArr = new int[5];
        //a reference to the array in memory 
        int[] anotherArray = myIntArr;

        //printing out the array 
        System.out.println("myIntArr = " + Arrays.toString(myIntArr));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        //making changes to the array copy 
        anotherArray[0] = 1;

        //printing out the arrays 
        System.out.println("myIntArr = " + Arrays.toString(myIntArr));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

    }

    //Third reference to the same array in memory
    private static void modifyArray(int[] array){
        array[1] = 2; 
    }

}
