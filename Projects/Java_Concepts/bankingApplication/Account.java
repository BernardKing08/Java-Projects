package bankingApplication;

//imports
import java.util.ArrayList;


public class Account {
    //accounts details 
    private String name; 
    private String uuid; 

    //object representation of the account owner
    private User holder; 

    //list of transactions carried out in the account
    private ArrayList<Transaction> transactions; 

    
    /*Account constructor  */
    Account(String name, User holder, Bank theBank){
        this.name = name; 
        this.holder = holder; 

        //generates the uuid from the bank class and saves it in the uuid variable
        this.uuid = theBank.getNewAccountUUID(); 

        this.transactions = new ArrayList<Transaction>(); 

        holder.addAccount(this);
        theBank.addAccount(this);
         
    }

    //getter method for the uuid 
    public String getUUId() {
        return uuid;
    }

    public String getSummaryLine(){
        //get account balance 
        double balance = this.getBalance(); 

        //formtatting te summary line depending on the account balbnvave 
        if(balance >= 0){
            return String.format("%s : $%0.2f : %s" , this.getUUId(), balance, this.name); 
        }
        else {
            return String.format("%s : ($%0.2f) : %s" , this.getUUId(), balance, this.name);
        }
    }

    public double getBalance(){
        double balance = 0; 

        for(Transaction t : this.transactions){
            balance += t.getamount(); 
        }
        return balance; 
    }

	public void printTransactionHistory() {
		System.out.printf("\nTransaction history for acount %s\n", this.getUUId());

        for(int i = this.transactions.size() - 1; i >= 0; i--){
            System.out.println(this.transactions.get(i).getSummaryLine());
        }
        System.out.println();
	}

    public void addTransaction(double amount, String memo) {
        //create nw transaction object and add it to our list 
        Transaction newtTransaction = new Transaction(amount, this, memo);
        this.transactions.add(newtTransaction); 
    }
}
