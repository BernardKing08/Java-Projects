package HashSetAndMaps.SetsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapViewMain{
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        //gives an orderly copy of the passed set 
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if(contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus Van Pelt exists");
        }

        //using the set to remove contents from the Map
        System.out.println("-".repeat(30));
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        //this had no effect onthe original Map
        System.out.println("-".repeat(30));
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k,v) -> System.out.println(v));

        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        //removing all keys from the Map
        System.out.println("-".repeat(30));
        keysView.clear();
        System.out.println(contacts);

        System.out.println("-".repeat(30));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keysView);

        //getting all values in a Map
        System.out.println("-".repeat(30));
        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("-".repeat(30));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        //adding duplicate contact with different Key 
        System.out.println("-".repeat(30));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size() < contacts.keySet().size()){
            System.out.println("Duplicate values are in my Map");
        }

        var nodeSet = contacts.entrySet();
        for(var node: nodeSet){
            if(!node.getKey().equals(node.getValue().getName())){
                System.out.println("Key dosent match name" + node.getKey() + ": " + node.getValue());
            }
        }

    }
}