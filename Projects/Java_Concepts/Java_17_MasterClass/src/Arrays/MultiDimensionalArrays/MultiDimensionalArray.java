package Arrays.MultiDimensionalArrays;

import java.util.Arrays;

public class MultiDimensionalArray {
    private static Object[] anyArray = new Object[3];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new String[] {"a", "b", "c"}; 
        anyArray[1] = new String[][]{
                {"1", "2", },
                {"3", "4", "5"},
                {"6", "7", "8", "9"}
        };

        System.out.println(Arrays.deepToString(anyArray));

        anyArray[2] = new int[2][2][2];

        System.out.println(Arrays.deepToString(anyArray));

        for(Object element : anyArray){
            System.out.println("Element type = " + element.getClass().getSimpleName());
            System.out.println("Element to string = " + element);
            System.out.println(Arrays.deepToString((Object[]) element));
        }
    }
}
