package bankingApplication;

import java.util.Date;


public class Transaction{
    //transcation details 
    private double amount; 
    private Date timeStamp; 
    private String memo; 

    private Account inAccount; 


    //Constructor for the Transaction Class 
    Transaction(double amount, Account inAccount){
        this.amount = amount; 
        this.inAccount = inAccount; 
        timeStamp = new Date(); 
        this.memo = ""; 
        
    }

    //overloading the Transaction constructor to accept a memo argument 
    Transaction(double amount, Account inAccount, String memo){
        //calling the 2-argument constructor
        this(amount, inAccount); 
        this.memo = memo; 


    }

    public double getamount() {
       return this.amount; 
    }

    public String getSummaryLine() {
        if(this.amount >= 0){
            return String.format("%s : $%0.02f : %s", this.timeStamp.toString(), this.amount, this.memo);
        }
        else {
            return String.format("%s : $(%0.02f) : %s", this.timeStamp.toString(), this.amount, this.memo);
        }
    }


}