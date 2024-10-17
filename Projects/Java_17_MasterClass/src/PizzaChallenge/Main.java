package PizzaChallenge;

import java.util.Scanner;

public class Main {

    //initializing scanner
    private static Scanner sc = new Scanner(System.in);
    private static double bill = 0;

    public static void main(String[] args) {

        welcomeMessage(); //prints welcome message

        Pizza pizza = getPizza(); //gets the type of pizza
        bill += pizza.getPizzaValue();

        Toppings cheese = getToppingChoice("cheese");  //gets cheese
        bill += cheese.getValue();  

        Toppings pepperoni = getToppingChoice("pepperoni");  //gets pepperoni
        bill += pepperoni.getValue();

        //prints user final bill
        System.out.println("Your final bill is: $" + bill);
    }


    //prints the welcome message to the screen
    private static void welcomeMessage(){
        System.out.println("""
            Welcome to Python Pizza Deliveries
            Enter size of pizza """);
    }

    private static Pizza getPizza() {
        System.out.print("'L' for Large, 'M' for Medium, 'S' for Small: ");
        char pizzaSize = sc.next().toUpperCase().charAt(0);

        // Map user input to Pizza enum and validate
        return switch (pizzaSize) {
            case 'L' -> Pizza.L;
            case 'M' -> Pizza.M;
            case 'S' -> Pizza.S;
            default -> {
                System.out.println("Error in input. Please enter 'L', 'M', or 'S'.");
                yield getPizza();  // Recursion for invalid input
            }
        };
    }

    // Get the user's choice for toppings (cheese or pepperoni)
    private static Toppings getToppingChoice(String toppingType) {
        System.out.printf("Would you like some %s? ('Y' for Yes, 'N' for No): ", toppingType);
        char choice = sc.next().toUpperCase().charAt(0);

        // Validate user input and map to Toppings enum
        return switch (choice) {
            case 'Y' -> Toppings.Y;
            case 'N' -> Toppings.N;
            default -> {
                System.out.println("Error in input. Please choose 'Y' or 'N'.");
                yield getToppingChoice(toppingType);  // Recursion for invalid input
            }
        }; 
    }

    //pizza enum
    public enum Pizza{
        S(15),
        M(20),
        L(25);

        private final int value;

        Pizza(int value) {
            this.value = value;
        }

        public int getPizzaValue(){
            return value;
        }
    }

    //pepperonni enum
    public enum Toppings{
        Y(2),
        N(0);

        private final int value; 

        Toppings(int value){
            this.value = value;
        }

        public double getValue() {
            return this.value;
        }
    }
}
