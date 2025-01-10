package Final_immutable_and_Static.immutableChallenges.dev.dto;

public class Transaction {
    private int routingNumber;
    private long transactionid;
    private int customerId;
    private double amount;

    public Transaction(int routingNumber, long transactionid, int customerId, double amount) {
        this.routingNumber = routingNumber;
        this.transactionid = transactionid;
        this.customerId = customerId;
        this.amount = amount;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public long getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(long transactionid) {
        this.transactionid = transactionid;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "%015d:%020d:%015d:%012.2f".formatted(routingNumber, customerId, transactionid, amount);
        
    }

    

    
}
