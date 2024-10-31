package CollectionMethods.LinkedListProject;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListProject {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

        placesToVisit.add("Syndey");
        placesToVisit.add(0, "Canberra");

        //adding elements
        addMoreElement(placesToVisit);

        //removing elements
        //removeElement(placesToVisit);

        //ways of getting elements from linkedList
        gettingElements(placesToVisit);

    }

    //exploring more methods of the linkedList
    private static void addMoreElement(LinkedList<String> linkedList){
        linkedList.addFirst("Darwin");
        linkedList.addLast("Lagos");

        //Queue methods
        linkedList.offer("Melbourne");
        linkedList.offerFirst("Abuja");
        linkedList.offerLast("Enugu");

        //stack methods
        linkedList.push("Albama");

    }

    private static void removeElement(LinkedList<String> list){
        list.remove(4);
        list.remove("Abuja");

        System.out.println(list);
        String s1 = list.remove(); //removes first element
        System.out.println(s1 + "was removed");
        //removeFirst()
        //removeLast()

        //Queue/Dequq poll methods
        String p1 = list.poll();
        System.out.println(p1 + "was removed");

        String p2 = list.pollFirst();
        System.out.println( p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list){
        System.out.println("Rertrived element = " + list.get(4));

        System.out.println("Retrived element = " + list.getFirst()); //returns the first element
        System.out.println("Retrived element = " + list.getLast()); // returns ;ast element
        System.out.println("Abuja positon is at " + list.indexOf("Abuja"));
        //lastIndexOf(); //retrives last index from a list

        //Queue retrival methods
        System.out.println("Element from element() = " + list.element()); // first element from Queue

        //stack retrival methods
        System.out.println("Elment from peek() = " + list.peek());
        System.out.println("Elment from peekFirst() = " + list.peekFirst());
        System.out.println("Elment from peekLast() = " + list.peekLast());

    }

    private static void printItinerary(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        for(int i = 1; i < list.size(); i++){
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void printItinerary2(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        
        //using enhanced for loop
        String previousTown  = list.getFirst();
        for(String town : list){
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
    }

    //using iterator
    private static void printItinerary3(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        
        //using enhanced for loop
        String previousTown  = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
        }

        System.out.println("Trip ends at " + list.getLast());
    }
}
