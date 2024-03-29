package bankingApplication;

//imports
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Bank {
    //bank details 
    private String nameOfBank; 
    //an array of users in the bank
    private ArrayList<User> user; 
    //bank keeps tracks of all the accounts in the bank
    private ArrayList<Account> account;

    
    public Bank(String nameOfBank) {
        this.nameOfBank = nameOfBank; 

        this.account = new ArrayList<Account>();
        this.user = new ArrayList<User>(); 
    }

    //generating a UUID for the User 
    public String getNewUserUUID() {
        String uuid; 
        Random rng = new Random(); 
        int lengthOfUUID = 6; 
        boolean nonUnique;

        //generates a random number per iteration and converts it to a string
        do{
            uuid = ""; 
            for(int i = 0; i < lengthOfUUID; i++ ){
                uuid += ((Integer)rng.nextInt(10)).toString(); 
            }

            //check to make sure its unique
            nonUnique = false;
            for(User u : this.user){
                if(uuid.compareTo(u.getUUId()) == 0){
                    nonUnique = true; 
                    break; 
                }
            }
        }
        while(nonUnique);

        //returns a uuid for the user
        return uuid;
        
    }//end of getUserUUId method

    //generates a uuid for the Account
    public String getNewAccountUUID() {
        String uuid;
        int lengthOfUUID = 10;
        Random rng = new Random();
        boolean nonUnique;
    
        do {
            uuid = "";
            for (int i = 0; i < lengthOfUUID; i++) {
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
    
            nonUnique = false;
            for (Account accountUUID : this.account) {
                if (accountUUID.getUUId().compareTo(accountUUID.getUUId()) == 0) {
                    nonUnique = true;
                    break; // Exit the loop once a non-unique UUID is found
                }
            }
        } while (nonUnique);
    
        return uuid;
    }
    

    //adds an account to the Account arrayList 
	public void addAccount(Account account) {
		this.account.add(account);
	}

    public User addUser(String firstName, String lastName, String pin ){
        //creating a new User object 
        User newUser = new User(firstName, lastName, pin, this); 
        //adds the user to the User ArrayList
        this.user.add(newUser); 

        //creating an Account object with details of the user as input 
        Account newAccount = new Account(lastName, newUser, this); 
        //adds the accocunt object to the arrayList of classes

        //adds the account object to the ArrayList of the User and the bank
        newUser.addAccount(newAccount); 
        this.addAccount(newAccount);

        //returns an instance of the newUser object
        return newUser; 
    }

    public User userLogin(String uuid, String pin) {
        for (User user : this.user) {
            if (user.getUUId().equals(uuid) && user.validatePin(pin)) {
                return user;
            }
        }
        return null;
    }
    

    public User userLogin(String uuid){
        
        for(User checkUser : this.user){
            if((checkUser.getUUId().equals(uuid)) /*&& checkUser.validatePin(pin) == true*/){
                return checkUser; 
            }
        }


        return null; 
    }

    //gets the name of the bank
    public String getName(){
        return this.nameOfBank; 
    }
	
}
