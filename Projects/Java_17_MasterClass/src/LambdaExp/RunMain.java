package LambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    //creating a static generic method to access the operate interface
    public static<T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1,value2);
        System.out.println("Result of operation: " + result);
        return result;

    }
}
