package bankingApplication;

//importing necessary librairies 
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {
    //user details 
    private String firstName; 
    private String lastName; 
    private String uuid; 
    private byte pinHash[];

    //saving user accounts 
    private ArrayList<Account> accounts; 

    /*constructor method for the User class 
     * Creates a new User 
     * with lastName, firstName, pin and an object of the bank as parameters
    */
    User(String firstName, String lastName, String pin, Bank theBank ){
        this.firstName = firstName; 
        this.lastName = lastName; 
         
        /*Using a MD5 algorithm for hashing of the pin 
         * this way we are storing the MD5 hash of the pin rather than the pin itself
         * for security reasons 
        */
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            this.pinHash = md.digest(pin.getBytes()); 
        } catch (Exception e) {
            System.out.println("Error, caught noSuchAlgorithm exception");
            e.printStackTrace();
            System.exit(1);
        }

        //getting a Unique Universal ID for the user - UUID
        this.uuid = theBank.getNewUserUUID(); 

        //creating an empty list of accounts 
        this.accounts = new ArrayList<Account>();

        //printing 'log message' 
        System.out.printf("New User %s, %s, with UUID %s created. \n", lastName, firstName, this.uuid); 

    }//end of user constructor 

    //method to add the account to the account ArrayList
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    //getter method for the uuid variable
    public String getUUId() {
        return this.uuid; 
    }

    //validates the pin 
    public boolean validatePin(String aPin) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (Exception e) {
            System.out.println("Error: The password validation algorithm is not available. Please contact the system administrator.");
            // Optionally, you can log the error for further investigation
            e.printStackTrace();
            return false;
        }
    }

    //getter method to get the first name
    public String getFirstName() {
        return this.firstName; 
    }

    public void printAccountsSummary() {
        System.out.printf("\n\n%s's accounts summary\n ", this.getFirstName());

        for(int i = 0; i < this.accounts.size(); i++){
            System.out.printf("%d) %s\n",  (i+1), this.accounts.get(i).getSummaryLine());
        }
        System.out.println();
    }

    public int getNumAccount() {
        return this.accounts.size(); 
    }

    public void printTransactionHistory(int accIndex) {
       this.accounts.get(accIndex).printTransactionHistory(); 
    }

    public double getAccountBalance(int accIndex){
        return this.accounts.get(accIndex).getBalance(); 
    }

    public String getAccUUid(int accIndex) {
        return this.accounts.get(accIndex).getUUId();
    }

    public void addAccTransaction(int accIndex, double amount, String memo) {
        this.accounts.get(accIndex).addTransaction(amount, memo);
    }

}
