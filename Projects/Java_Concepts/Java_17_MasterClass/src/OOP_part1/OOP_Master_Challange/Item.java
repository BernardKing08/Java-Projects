package OOP_part1.OOP_Master_Challange;

//building a full application using all principles of OOP
public class Item {
    private String type;  
    private String name; 
    private double price; 
    private String size = "Medium"; 

    Item(String type, String name, double price){
        this.type = type.toUpperCase();
        this.name = name.toUpperCase(); 
        this.price = price; 
    }

    public String getName() {

        if(name.equals("SIDE") || name.equals("DRINK")){
            return size + " " + name;
        }

        return name;
    }

    public double getBasePrice(){
        return price;
    }

    public double getAdjustedPrice(){
        return switch(size){
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    
    public void setSize(String size) {
        this.size = size;
    }

    public void printItem(){
        printItem(getName(), getAdjustedPrice());
    }

    public static void printItem(String name, double price){
        System.out.printf("%20s:%6.2f%n", name, price);
    }




}
