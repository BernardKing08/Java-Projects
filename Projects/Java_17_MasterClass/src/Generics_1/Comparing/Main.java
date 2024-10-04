package Generics_1.Comparing;

import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;

        Integer[] others = {0, 5, 20, 43, 50};

        for(Integer i : others){
            int val = five.compareTo(i);

            System.out.printf("%d %s %d: compareTo = %d%n", five, 
                (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for(String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo = %s%n", banana, 
                (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        Student tim = new Student("tim");
        Student [] students = {new Student("alice"), new Student("zach"), new Student("john"), new Student("mike")};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}

class Student implements Comparable<Student>{

    private static int LastID = 1000;
    private int id;
    private String name; 
    protected double gpa;
    private static Random random = new Random();

    public Student(String name){
        this.name = name;
        id = LastID + 1;
        gpa = random.nextDouble(1.0, 4.0);  
    }

    @Override
    public String toString(){
        return name; 
    }

    

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
