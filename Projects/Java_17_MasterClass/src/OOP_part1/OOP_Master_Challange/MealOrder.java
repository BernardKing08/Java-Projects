package OOP_part1.OOP_Master_Challange;

public class MealOrder {
    private Item drink;
    private Burger burger; 
    private Item side;
    
    public MealOrder(){
        this("burger", "coke", "fries");
    }

    public MealOrder(String burgerType, String drinkType, String sideType){

        if(burgerType.equalsIgnoreCase("deluxe")){
            this.burger = new DeleuxeBurger(burgerType, sideType, 8.50);
        }
        else{
            this.burger = new Burger(burgerType, sideType, 4.0);
        }

        this.burger = new Burger("Burger", burgerType, 4.0);
        this.drink = new Item("Drink", drinkType, 1.0);
        this.side = new Item("side", sideType, 1.50);
    }

    public double getTotalPrice(){
        if(burger instanceof DeleuxeBurger){
            return burger.getAdjustedPrice();
        }
        return side.getAdjustedPrice() + drink.getAdjustedPrice() + burger.getAdjustedPrice();
    }

    public void printItemizedList(){

        if(burger instanceof DeleuxeBurger){
            Item.printItem(drink.getName(), 0);
            Item.printItem(side.getName(), 0);
        }
        else{            
            drink.printItem();
            side.printItem();
        }
        
        System.out.println("-".repeat(30));
        Item.printItem("Total Price", getTotalPrice());
    }

    public void addBurgerToppings(String extra1, String extra2, String extra3){
        burger.addToppings(extra1, extra2, extra3);
    }

    public void addToppings(String extra1, String extra2, String extra3, String extra4, String extra5){
        if(burger instanceof DeleuxeBurger db){
            db.addToppings(extra1, extra2, extra3);
        }
        burger.addToppings(extra1, extra2, extra3);
    }

    public void setDrinkSize(String size){
        drink.setSize(size);
    }

}
