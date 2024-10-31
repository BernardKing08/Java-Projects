package CollectionMethods.ListsAndArrays.Challange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Challange1 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Array list variable 
        ArrayList<String> groceries = new ArrayList<>();

        boolean flag = true;
        while(flag){
            printAction();

            switch(Integer.parseInt(sc.nextLine())){
                case 1 -> addItems(groceries);
                case 2 -> removeItem(groceries);
                case 3 -> printOutList(groceries);
                default -> flag = false;
            }

            //sorting and printing out the list
            groceries.sort(Comparator.naturalOrder());
            System.out.println(groceries);
        }
    }

    private static void printOutList(ArrayList<String> groceries) {
        System.out.println(groceries);
    }

    public static void addItems(ArrayList<String> groceries){
        System.out.println("Add item(s) [seperate items by comma]: ");
        String[] items = sc.nextLine().split(",");
        //groceries.addAll(List.of(items));

        for(String str : items){
            String trimmed = str.trim();
            //checking for duplicate values in the list
            if(groceries.indexOf(trimmed) < 0){
                groceries.add(trimmed);
            }
        }
    }

    public static void removeItem(ArrayList<String> groceries){
        System.out.println("Remove item(s) [seperate items by comma]: ");
        String[] items = sc.nextLine().split(",");
        

        for(String str : items){
            String trimmed = str.trim();
            groceries.remove(trimmed);
        }
    }

    public static void printAction(){
        String textBlock = """
                Available Actions:

                0 - To shutdown

                1 - to add item(s) to list (comma delemited list)

                2 - to remove any items (comma delemited list)

                3 - to print out the List

                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }
}
