package LambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class RunMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("alpha", "bravo", "charlie", "delta"));

        for(String s : list){
            System.out.println(s);
        }

        //using lambda exp to print out the list element
        System.out.println("-".repeat(30));
        list.forEach(myString -> System.out.println(myString));

        //using curly braces in lambda exp
        System.out.println("-".repeat(30));
        list.forEach(myString -> {
            char firstChar = myString.charAt(0);
            System.out.println(myString + " means " + firstChar);
        });


        //calling the static method using lambda
        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((var a, var b) -> a / b, 10.5, 2.0);
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Mike");
        var result4 = calculator((new Operation<Integer>() {
            @Override
            public Integer operate(Integer a, Integer b){
                return a + b;
            }
        }), 5, 7);


        //working with consumer functional interface
        var coords = Arrays.asList(new double[]{47.216, -95.234},
            new double[]{29.1566, -89.2495},
            new double[]{35.1556, -90.0659});

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-".repeat(30));
        coords.forEach(s -> processPoint(s[0], s[1], p1));
        //nested lambda expressions
        coords.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng)));

        //using list removeif lambda exp
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));
        //adding more elements to the list 
        System.out.println("-".repeat(30));
        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));
        //removing any string that atarts with 'ea'
        list.removeIf(s -> s.startsWith("ea"));
        //replacAll lambda exp
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("-".repeat(30));
        list.forEach(s  -> System.out.println(s));


        //working with the setAll method in the Arrays library
        String[] emptyString = new String[10];
        Arrays.fill(emptyString, "");
        System.out.println(Arrays.toString(emptyString));
        //using the setAll lambda exp
        Arrays.setAll(emptyString, (i) -> (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyString));
        //using the setAll lambda exp
        Arrays.setAll(emptyString, (i) -> (i + 1) + ". " +
            switch(i){
                case 0 -> "one";
                case 1 -> "two";
                case 2 -> "three";
                default -> "";
            });
        System.out.println(Arrays.toString(emptyString));


        String[] names = {"bob", "carl", "edd", "eddy", "fred"};
        String[] randomList = randomlySelectedValues(15, names, () -> new Random().nextInt(0, names.length));
        
        System.out.println(Arrays.toString(randomList));
    }

    //creating a static generic method to access the operate interface
    public static<T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1,value2);
        System.out.println("Result of operation: " + result);
        return result;

    }

    //creating an inbuilt static generic method to access the binaryOperator interface 
    public static<T> T calculate(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1,value2);
        System.out.println("Result of operation: " + result);
        return result;

    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }

    //using a supplier lambda exp
    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for(int i = 0; i < count; i++){
            selectedValues[i] = values[s.get()];
        }

        return selectedValues;
    }
}
