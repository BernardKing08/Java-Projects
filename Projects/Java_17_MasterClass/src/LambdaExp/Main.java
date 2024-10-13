package LambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person(String firstName, String lastName){ 
        @Override
        public String toString(){
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(new Main.Person("Lucy", "Van pelt"),
            new Person("Sandy", "cheeks"),
            new Person("SpongeBob", "squarePants"),
            new Person("fakeSponge", "squarePants"),
            new Person("Patrick", "Star"),
            new Person("Cash", "Crabs")
        ));

        //creating an anonymous class
        var comparatorClass = new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return o1.lastName().compareTo(o2.lastName());
            }
        };

        people.sort(comparatorClass);
        System.out.println(people);

        //creating a local interface in the main class
        interface EnhancedComparator<T> extends Comparator<T>{
            int secondLevel(T o1, T o2);
        }

        //creating an anonymous class that implements the local interface
        var comparatorMix = new EnhancedComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName().compareTo(o2.lastName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName().compareTo(o2.firstName());
            }
            
        };

        people.sort(comparatorMix);
        System.out.println(people);
    }
}
