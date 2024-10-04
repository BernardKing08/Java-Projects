package bankingApplication;

import java.util.Scanner; 

public class ATM {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in); 

        //initializing the theBank Object
        Bank thebank = new Bank("Sterling Bank"); 

        //creating a user 
        User aUser = new User("Bernard", "Ugochukwu", "1234", thebank); 

        //creating an account
        Account aAccount = new Account("Checking Account", aUser, thebank); 

        //Adding the Account object to the User ArrayList and he thebank ArrrayList
        aUser.addAccount(aAccount);
        thebank.addAccount(aAccount);

        User currentUser; 
        while(true){
            currentUser = ATM.mainMenuPrompt(thebank, sc); 
            //stays in the loop until the right password is used

            ATM.printUserMenu(currentUser, sc);

        }
    }//end of main method

    private static User mainMenuPrompt(Bank thebank, Scanner sc) {
        String userID;
        String pin;
        User authUser;
    
        do {
            System.out.printf("\n\nWelcome to %s\n", thebank.getName());
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();
    
            System.out.print("Enter pin: ");
            pin = sc.nextLine();
    
            // Testing the user UUID and PIN with the current userID and pin
            authUser = thebank.userLogin(userID, pin);
            if (authUser == null) {
                System.out.println("Incorrect userID or PIN. Please try again.");
            }
        } while (authUser == null); // Loop until successful login
    
        return authUser;
    }
    

    private static void printUserMenu(User currentUser, Scanner sc) {
        //print a summary of the user accounts
        currentUser.printAccountsSummary(); 

        int choice; 

        do{
            System.out.printf("Welcome, %s, what would you like to do", currentUser.getFirstName());
            System.out.println(" 1) Show transaction history");
            System.out.println(" 2) withdrawal");
            System.out.println(" 3) Deposit");
            System.out.println(" 4) Transfer");
            System.out.println(" 5) Quit");
            System.out.println();
            System.out.println("Enter choice");
            choice = sc.nextInt(); 

            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice please choose 1-5");
            }

        }
        while(choice < 1 || choice > 5);//end of do while loop 

        switch (choice) {
            case 1: 
                ATM.showTransactionHistory(currentUser, sc); 
                break; 
            case 2: 
                ATM.withdrawFunds(currentUser, sc); 
                break;
            case 3: 
                ATM.DepositFunds(currentUser,  sc); 
                break;
            case 4: 
                ATM.transferFunds(currentUser, sc); 
                break;
        }

        //redisplay this menu as long as the user does not quit
        if(choice != 5){
            ATM.printUserMenu(currentUser, sc);
        }

    }

    private static void showTransactionHistory(User currentUser, Scanner sc) {
        int theAcc; 

        //prompt the user to enter the account he wants to get history
        do{
            System.out.printf("Enter the account (1-%d) of the account whose transaction you want to see ", currentUser.getNumAccount());
            theAcc = sc.nextInt(); 

            if(theAcc < 0 || theAcc >= currentUser.getNumAccount()){
                System.out.println("Invalid account. Please try again ");
            }
        }
        while(theAcc < 0 || theAcc >= currentUser.getNumAccount());//end of do...while loop

        currentUser.printTransactionHistory(theAcc); 
    }

    private static void withdrawFunds(User currentUser, Scanner sc) {
        //getting the account the user wants to transfer from and the acc the user wants to transfer to
        int fromAcc; 
        double amount; 
        double accBalance; 
        String memo;

        //get the acc to transfer from 
        do{
            System.out.printf("Enter the number (1-%d) of the account you eant to transfer from:\n" );
            fromAcc = sc.nextInt()-1; 

            if(fromAcc < 0 || fromAcc >= currentUser.getNumAccount()){
                System.out.println("Invalid account. Please try again ");
            }
        } while(fromAcc < 0 || fromAcc >= currentUser.getNumAccount());

        accBalance = currentUser.getAccountBalance(fromAcc);

        //get the amount to transfer
        do {
            System.out.printf("Enter amount to transfer (max : $%0.02f)", accBalance); 
            amount = sc.nextDouble(); 

            if(amount < 0){
                System.out.println("Amount must be greater than zero");
            }
            else if(amount > accBalance) {
                System.out.println("Amount must not be greater than Account balance");
            }
        } while (amount < 0 || amount > accBalance);

        sc.nextLine();

        //get the memo
        System.out.println("Enter the memo: ");
        memo = sc.nextLine();

        //do the withdrawal
        currentUser.addAccTransaction(fromAcc, (-1*amount), memo); 
    }

    private static void DepositFunds(User currentUser, Scanner sc) {
        //getting the account the user wants to transfer from and the acc the user wants to transfer to
        int toAcc; 
        double amount; 
        double accBalance; 
        String memo;

        //get the acc to transfer from 
        do{
            System.out.printf("Enter the number (1-%d) of the account you eant to transfer from:\n" );
            toAcc = sc.nextInt()-1; 

            if(toAcc < 0 || toAcc >= currentUser.getNumAccount()){
                System.out.println("Invalid account. Please try again ");
            }
        } while(toAcc < 0 || toAcc >= currentUser.getNumAccount());

        accBalance = currentUser.getAccountBalance(toAcc);

        //get the amount to transfer
        do {
            System.out.printf("Enter amount to transfer (max : $%0.02f)", accBalance); 
            amount = sc.nextDouble(); 

            if(amount < 0){
                System.out.println("Amount must be greater than zero");
            }
            else if(amount > accBalance) {
                System.out.println("Amount must not be greater than Account balance");
            }
        } while (amount < 0 || amount > accBalance);

        sc.nextLine();

        //get the memo
        System.out.println("Enter the memo: ");
        memo = sc.nextLine();

        //do the withdrawal
        currentUser.addAccTransaction(toAcc, (amount), memo); 
    }

    private static void transferFunds(User currentUser, Scanner sc) {
        //getting the account the user wants to transfer from and the acc the user wants to transfer to
        int fromAcc; 
        int toAcc; 
        double amount; 
        double accBalance; 

        //get the acc to transfer from 
        do{
            System.out.printf("Enter the number (1-%d) of the account you eant to transfer from:\n" );
            fromAcc = sc.nextInt()-1; 

            if(fromAcc < 0 || fromAcc >= currentUser.getNumAccount()){
                System.out.println("Invalid account. Please try again ");
            }
        } while(fromAcc < 0 || fromAcc >= currentUser.getNumAccount());

        accBalance = currentUser.getAccountBalance(fromAcc);

        //get the account to transfer to
        do{
            System.out.printf("Enter the number (1-%d) of the account you want to transfer to:\n" );
            toAcc = sc.nextInt()-1; 

            if(toAcc < 0 || toAcc >= currentUser.getNumAccount()){
                System.out.println("Invalid account. Please try again ");
            }
        } while(toAcc < 0 || toAcc >= currentUser.getNumAccount());

        //get the amount to transfer
        do {
            System.out.printf("Enter amount to transfer (max : $%0.02f)", accBalance); 
            amount = sc.nextDouble(); 

            if(amount < 0){
                System.out.println("Amount must be greater than zero");
            }
            else if(amount > accBalance) {
                System.out.println("Amount must not be greater than Account balance");
            }
        } while (amount < 0 || amount > accBalance);

        //finally do the transfer
        currentUser.addAccTransaction(fromAcc, (-1 * amount), String.format("Transfer to Account", currentUser.getAccUUid(toAcc)));
        //transfering to the account 
        currentUser.addAccTransaction(toAcc , (-1 * amount), String.format("Transfer to Account", currentUser.getAccUUid(fromAcc)));

    }
}//end of ATM class









/*Having issues with the login phase, normally the uuid and the pin is required to login
 * but that isnt the case as it always says invalid email, 
 * so i tried to use only the uuid but it didnt work 
 * 
 * would be checking the while loop incharge of the login phase 
 */