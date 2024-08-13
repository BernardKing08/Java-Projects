package Arrays;

import java.util.Arrays;

public class ArraysProject {

    public static void main(String[] args){
        //declairing a basic array
        int[] myArr = new int[10];
        //assigning a value to the array
        myArr[5] = 30;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.2;
        //printing out the array
        System.out.println(myDoubleArray);

        //using an array initializer
        int[] firstfivePositives = new int[]{1,2,3,4,5};
        //another way of using array initializer
        int[] firstTen = {1,2,3,4,5,6,7,8,9,10};
        //printing the first value of the array
        System.out.println("first = " + firstTen[0]);
        
        //getting length of the array
        System.out.println("Length of the array is " + firstTen.length);
        //getting last index of oan array
        System.out.println("Last = " + firstTen[firstTen.length-1]);

        int[] newArray;
        newArray = new int[]{5,4,3,2,1};

        //looping through the array 
        for(int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }

        //using enhanced for eeach loop
        for(int element : newArray){
            System.out.println(element);
        }

        //working with the java.util.arrays
        System.out.println(Arrays.toString(newArray));

        //creating an array of objects that supports any type in java
        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("Hi there");
        //nested arrays
        objectArray[2] = newArray;


    }

}
