package LambdaExp.methodReferences;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.Arrays;
import java.util.ArrayList;

class PlainOld{

    private static int last_id = 1;

    private int id;

    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Creating a plainOld object: id = " + id);
    }
}

public class Main {

    public static void main(String[] args) {
        List<String> list = (Arrays.asList("Bob", "anna", "David", "Gary", "Eve"));  

        //using method reference
        list.forEach(System.out::println);

        //caling calculator method
        // calculator((a, b) -> a + b, 10, 25);
        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 1.0, 2.5);

        // Supplier<PlainOld> reference1 = () -> new PlainOld();
        Supplier<PlainOld> reference1 = PlainOld::new;

        PlainOld newPojo = reference1.get();

        System.out.println("Gettting array");

        //creating and setting 10 plainold objects in an array
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        System.out.println("_".repeat(30));
        calculator((a, b) -> a + b, "Hello", " World");

        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello", " World"));
        System.out.println(b2.apply("Hello ", "world"));
        System.out.println(u1.apply("Hello"));

        //using string transform method
        String result = "Hello".transform(u1);
        System.out.println("Result = " + result);

        result = result.transform(String::toLowerCase);
        System.out.println("Result = " + result);

        System.out.println("-".repeat(30));
        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
    }

    public static <T> void calculator(BinaryOperator<T> function, T value1, T value2){
        T result = function.apply(value1, value2);
        System.out.println("Result of operation " + result);
    }

    //creating an array of class plainold
    public static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());

        return array;
    }
}
