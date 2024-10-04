package Collections.LinkedListProject;

import java.util.LinkedList;
import java.util.List;

public class IteratorProject {
    
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(List.of("apples", "banana", "milk"));

        testIterator(list);
    }

    //An iterator is forward only and only supports the remove method
    public static void testIterator(LinkedList<String> list){
        var iterator = list.iterator();
        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            if(iterator.next().equals("milk")){
                iterator.remove(); //only the remove method is alowed for the iterator
                //ListIterator has ListIterator.add() 
            }
        }

        System.out.println(list);
    }
}
