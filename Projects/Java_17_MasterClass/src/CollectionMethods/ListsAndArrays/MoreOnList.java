package CollectionMethods.ListsAndArrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MoreOnList {
    public static void main(String[] args) {
        String[] items = {"apples", "banana", "milk"};

        List<String> list = List.of(items);

        //printing the immutable list out
        System.out.println(list);

        //printing the type
        System.out.println(list.getClass().getName());

        //converting it to an Array
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(
            List.of("pickles", "mustard", "cheese")
        );
        System.out.println(nextList);

        //using the addAll method to add a list to an arrayList
        groceries.addAll(nextList);

        if(groceries.contains("mustard")){
            System.out.println("List contains mustard");
        }

        //removing items from a list
        // remove() by index or by value
        // removeAll()
        // retain(list.of(...))
        // clear()

        //sorting of list
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder()); //Comparator.reverseOrder()
        System.out.println(groceries);


    }
}
