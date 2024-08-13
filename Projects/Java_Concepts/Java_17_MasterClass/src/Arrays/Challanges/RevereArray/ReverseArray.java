package Arrays.Challanges.RevereArray;

import java.util.Arrays;

public class ReverseArray {

    private void reversedArray(int[] myArr){
        System.out.println("Array = " + Arrays.toString(myArr));

        //sorting the array in descending order
        int[] myArr2 = new int[myArr.length];
        for (int i = 0; i < myArr.length; i++) {
            myArr2[i] = myArr[myArr.length - 1 - i];
        }

        System.out.println("Reversed array = " + Arrays.toString(myArr2));

    }
}
