package Arrays.MultiDimensionalArrays;

import java.util.Arrays;

public class TwoDimensionalArray {
    private static int[][] array2 = new int[4][4];
    public static void main(String[] args) {
          

        System.out.println(Arrays.toString(array2));
        System.out.println("array2 length = "+ array2.length);

        //using advanced for loop to pront out the two dimensional array
        for(int[] outer : array2){
            System.out.println(outer);
        }

        for(int[] outer : array2){
            System.out.println(Arrays.toString(array2));
        }

        //using method 1 - traditional for statement
        method1();

        //using method 2 - advanced for-loop and var statement
        method2();

        //using method 3 - inbuilt Array function
        method3();
    }

    //method 1 using traditional for statement 
    private static void method1(){
        //printinng each element in the array 
        for(int i = 0; i < array2.length; i++){
            var innerArray = array2[i];
            for(int j = 0; i < innerArray.length; j++){
                System.out.println(array2[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    //method 2 using advanced for-loop and var statement
    private static void method2(){
        for(var outer : array2){
            for(var element : outer){
                System.out.println(element + " ");
            }
            System.out.println();
        }
    }

    //using inbuilt Array function
    private static void method3(){
        System.out.println(Arrays.deepToString(array2));
    }

}
