package HashSetAndMaps.FinalCollectionsChallenge;

public class Inventory {

    private Product product;
    private double price; 
    private int qtyTotal;
    private int qtyReserved; 
    private int qtyRecorder;
    private int qtyLow;

    public Inventory(Product product, double price, int qtyTotal, int qtyLow) {
        this.product = product;
        this.price = price;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.qtyRecorder = qtyTotal;
    }

    public Product getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public boolean reserveeItem(int qty){
        if((qtyTotal - qtyReserved) >= qty){
            qtyReserved += qty;
            return true;
        }

        return false;
    }

    public void releaseItem(int qty){
        qtyReserved -= qty;
    }

    public boolean sellItem(int qty){
        if(qtyTotal >= qty){
            qtyTotal -= qty;
            qtyReserved -= qty;
            if(qtyTotal <= qtyLow){
                placeInventoryOrder();
            }
            return true;
        }
        return false;
    }

    private void placeInventoryOrder(){
        System.out.printf("Ordering qty %d : %s%n", qtyRecorder, product);
    }

    @Override
    public String toString(){
        return "%s, %.2f : [%04d, %2d]".formatted(product, price, qtyTotal, qtyReserved);
    }

}
