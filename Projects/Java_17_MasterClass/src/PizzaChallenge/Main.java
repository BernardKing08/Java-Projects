package PizzaChallenge;

import java.util.Scanner;

public class Main {

    // Initializing scanner
    private static Scanner sc = new Scanner(System.in);
    private static double bill = 0;

    public static void main(String[] args) {

        welcomeMessage(); // Prints welcome message

        Pizza pizza = getPizza(); // Gets the type of pizza
        bill += pizza.getPizzaValue(); 

        // Get user choice for cheese and add cost to the bill
        Toppings cheese = getToppingChoice("cheese", pizza);
        bill += cheese.getValue();

        // Get user choice for pepperoni and add cost to the bill
        Toppings pepperoni = getToppingChoice("pepperoni", pizza);
        bill += pepperoni.getValue();

        // Prints the final bill
        System.out.println("Your final bill is: $" + bill);
    }

    // Prints the welcome message to the screen
    private static void welcomeMessage(){
        System.out.println("""
            Welcome to Python Pizza Deliveries
            Enter size of pizza:
            """);
    }

    // Method to get the pizza size from the user and return the corresponding Pizza enum
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
                yield getPizza(); // Recursion for invalid input
            }
        };
    }

    private static Toppings getToppingChoice(String toppingType, Pizza pizzaSize) {
        System.out.printf("Would you like some %s? ('Y' for Yes, 'N' for No): ", toppingType);
        char choice = sc.next().toUpperCase().charAt(0);

        // Validate user input
        if(choice == 'Y') {
            if(toppingType.equals("pepperoni")) {
                return getPepperoniChoice(pizzaSize); 
            } 
            else if (toppingType.equals("cheese")) {
                return Toppings.CHEESE; 
            }
        } 
        else if(choice == 'N') {
            return Toppings.NONE; 
        }

        System.out.println("Error in input. Please choose 'Y' or 'N'.");
        return getToppingChoice(toppingType, pizzaSize); // Recursion for invalid input
    }

    private static Toppings getPepperoniChoice(Pizza pizzaSize) {
        return switch (pizzaSize) {
            case L, M -> Toppings.PEPPERONI_ML; // Medium or Large pizza gets $3 pepperoni
            case S -> Toppings.PEPPERONI_SMALL; // Small pizza gets $2 pepperoni
        };
    }

    //Enum for pizza sizes and their respective prices
    public enum Pizza {
        S(15),
        M(20),
        L(25);

        private final int value;

        Pizza(int value) {
            this.value = value;
        }

        public int getPizzaValue() {
            return value;
        }
    }

    //Enum for toppings (pepperoni for small, medium/large, cheese, and none)
    public enum Toppings {
        PEPPERONI_SMALL(2),
        PEPPERONI_ML(3),
        CHEESE(1),
        NONE(0); // No additional topping

        private final int value;

        Toppings(int value) {
            this.value = value;
        }

        public double getValue() {
            return this.value;
        }
    }
}
