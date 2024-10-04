package Abstraction.Abstraction;

public class FurnitureObject extends ProductForSale{

    public FurnitureObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This " + type + " is product was manufactured in North carolina");
        System.out.printf("The price od the piece is $%6.2f %n", price);
        System.out.println(description);
    }
    
}
