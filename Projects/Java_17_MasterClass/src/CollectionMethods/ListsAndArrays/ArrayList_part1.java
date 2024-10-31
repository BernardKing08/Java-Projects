package CollectionMethods.ListsAndArrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Inner record
 */
record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name){
        this(name, "Dairy", 1);
    }

    @Override
    public String toString(){
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}


public class ArrayList_part1 {
    public static void main(String[] args) {
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "Produce", 6);
        groceryArray[2] = new GroceryItem("butter");

        System.out.println(Arrays.toString(groceryArray));

        //Creating an ArrayList
        // ArrayList objectList = new ArrayList();
        // objectList.add(new GroceryItem("butter"));
        // objectList.add(new GroceryItem("Yougrt"));

        ArrayList<GroceryItem> groceryItem = new ArrayList<>();
        groceryItem.add(new GroceryItem("butter"));
        groceryItem.add(new GroceryItem("Yougrt"));
        
        groceryItem.set(1, new GroceryItem("wine"));
        System.out.println(groceryItem);
    }
}
