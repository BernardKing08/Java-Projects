package Abstraction.Abstraction;

import java.util.ArrayList;

//creating a record item in the store class
record OrderItem(int qty, ProductForSale products){

}

public class Store {
    
    private static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {

        //adding art object 
        storeProducts.add(new ArtObject("Oil painting", 1350, "Work by benny"));
        storeProducts.add(new ArtObject("Angel painting", 105350, "Work by ben"));

        //adding furniture object
        storeProducts.add(new FurnitureObject("Lamp", 200, "Tiffany Lamp with Hummingbirds"));
        storeProducts.add(new FurnitureObject("Chair", 300, "Bernard's wood with Hummingbirds"));

        //Listing the products
        listProducts();

        //creating Order of stores
        System.out.println("\nOrder 1");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        //creating order of furnitures for the second order
        System.out.println("\nOrder 2");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 2, 4);
        addItemToOrder(order2, 3, 1);
        printOrder(order2);
    }

    public static void listProducts(){
        for(var item : storeProducts){
            System.out.println("-".repeat(30));
            item.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty){
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order){

        double salesTotal = 0; 
        for(var item : order){
            item.products().printPricedItem(item.qty());
            salesTotal += item.products().getSalesPrice(item.qty());
        }

        System.out.printf("Sales Total = $%6.2f %n", salesTotal);
    }
}
