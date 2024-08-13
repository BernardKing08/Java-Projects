package Arrays.VarArgs;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello world again");

        String[] splitStrings = "Hello World again".split(" ");

        printText(splitStrings);

        System.out.println("-".repeat(20));
        printText("Hello");

        System.out.println("-".repeat(20));
        printText("Hello", "World", "again"); 

    }

    private static void printText(String... textList){
        for(String t : textList){
            System.out.println(t);
        }

    }
}
