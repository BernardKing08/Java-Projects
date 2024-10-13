package LambdaExp.lambdaExpChallenge;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    private static Random random = new Random();
    

    public static void main(String[] args) {
        String[] names = {"Bob", "anna", "David", "Ed", "Fred", "Gary", "Eve"};    

        //setting all arrays element to uppercase using lambda
        Arrays.setAll(names, i -> names[i].toUpperCase());
        System.out.println("---> Transform to uppercase");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);

        backedByArray.replaceAll(s -> s += " " + getRandomChar('A', 'D') + ".");
        System.out.println("--> Add random middle initial");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s += " " + getReversedName(s.split(" ")[0]));
        System.out.println("---> Add reversed name as last name");
        Arrays.asList(names).forEach(s -> System.out.println(s));
        
    }

    public static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar, (int)endChar+1);
    }

    public static String getReversedName(String firstName){
        return new StringBuilder(firstName).reverse().toString();
    }
    

}
