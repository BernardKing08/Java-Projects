package Collections.LinkedListProject.Challange;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){

    @Override
    public String toString(){
        return String.format("%s (%d)", name, distance);
    }
}    

public class LinkedListChallange{
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place abeokuta = new Place("Abeokuta", 1374);
        Place abeokuta2 = new Place("Abeokuta", 1374);
        Place abuja = new Place("Abuja", 1432);
        Place owerri = new Place("owerri", 3445);
        Place lagos = new Place("lagos", 9889);

        addPlace(placesToVisit, abeokuta);
        addPlace(placesToVisit, abeokuta2);
        addPlace(placesToVisit, abuja);
        addPlace(placesToVisit, owerri);
        addPlace(placesToVisit, lagos);

        var iterator = placesToVisit.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while(!quitLoop){

            if(!iterator.hasPrevious()){
                System.out.println("Originating : " + iterator.next());
                forward = true;
            }
            if(!iterator.hasNext()){
                System.out.println("final : " + iterator.previous());
                forward = false;
            }

            System.out.println("Enter value: ");
            String menuItem = sc.nextLine().toUpperCase().substring(0, 1);

            switch(menuItem){
                case "F" :
                    System.out.println("User wants to go forward");
                    if(!forward){
                        forward = true;
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if(iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B" : 
                    if(forward){
                        forward = false;
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    System.out.println("User wants to go backward");
                    if(iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "M" :
                    printMenu();
                    break;
                case "L" : 
                    System.out.println(placesToVisit);
                    break;
                default: 
                    quitLoop = true;
                    break;
            }
        }
    }

    public static void addPlace(LinkedList<Place> list, Place place){
        //checking for duplicate 
        if(list.contains(place)){
            System.out.println("A similar place already exists");
            return;
        }

        //ignoring case 
        for(Place p : list){
            if(p.name().equalsIgnoreCase(place.name())){
                System.out.println("Found duplicate");
                return;
            }
        }

        int matchedIndex = 0; 
        for(var p : list){
            if(place.distance() < p.distance()){
                list.add(matchedIndex, place);
            }
        }

        list.add(place);
    }

    public static void printMenu(){
        System.out.println("""
                Available actions select word or letter):
                (F)orward
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit""");
    }
}
