package HashSetAndMaps.SortedMaps;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;


public class Main {
    
    private static Map<String, Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String, Student> students = new TreeMap<>();

    public static void main(String[] args) {
        Course jnc = new Course("jnc101", "Java Master Class", "Java");
        Course python = new Course("pyt102", "Python Master Class", "Python");

        addPurchase("Mary Martin", jnc, 129.99);
        addPurchase("Andy Martin", jnc, 129.99);
        addPurchase("Mary Martin", python, 129.99);
        addPurchase("Joe jones", jnc, 129.99);
        addPurchase("Bill Brown", jnc, 129.99);

        addPurchase("Chuck cheese", python, 129.99);
        addPurchase("Davey Jones", python, 129.99);
        addPurchase("Eva East", jnc, 129.99);
        addPurchase("Fred Forker", python, 129.99);
        addPurchase("Greg Brady", python, 129.99);

        purchases.forEach((k,v) -> System.out.println(k + ": " + v));
        System.out.println("-".repeat(30));
        students.forEach((k,v) -> System.out.println(k + ": " + v));

        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();

        for(Purchase p : purchases.values()){
            datedPurchases.compute(p.purchaseDate(), (pdate, plist) -> {
                List<Purchase> list = 
                    (plist == null) ? new ArrayList<>() : plist;
                list.add(p);
                return list;
            });
        }

        datedPurchases.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    private static void addPurchase(String name, Course course, double price){
        Student existingStudent = students.get(name);
        //checking if student already exists
        if(existingStudent == null){
            existingStudent = new Student(name, course);
            students.put(name, existingStudent);            
        } 
        else{
            existingStudent.addCourse(course);
        }

        //getting the day of purchase
        int day = new Random().nextInt(1, 14);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price, year, day);
        purchases.put(key, purchase);

    }

}
