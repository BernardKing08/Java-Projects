package Arrays;

import java.util.Arrays;

public class ArrayProject3 {
    public static void main(String[] args) {
        
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray); //binary search only works on sorted arrays

        //binary Search using Arrays.binearySearch
        if(Arrays.binarySearch(sArray, "Mark") > 0){
            System.out.println("A match Mike was found");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};

        if(Arrays.equals(s1,s2)){
            System.out.println("They are equal");
        }
        else{
            System.out.println("They are not equal");
        }
    }
}
