package OOP_part1.BankAccount;

public class Account {
    public String accountNumber;
    public double accountBalance;
    public String customerName;
    public String email;
    public String phoneNumber;

	public Account(String accountNumber, double accountBalance, String customerName, String email, String phoneNumber){
		this.accountBalance = accountBalance; 
		this.accountNumber = accountNumber; 
		this.customerName = customerName; 
		this.email = email; 
		this.phoneNumber = phoneNumber; 
	}


	//setters and getters for accountNumber  
    public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	//setters and getters for account Balance
	public double getAccountBalance() {
		System.out.print("Your balance is : ");
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	//setters and getters for customer Name
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	//setters and getters for email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//setters and getters for phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/*Create getters and setters for each field.
		Create two additional methods:
		one for depositing funds into the account.
		A customer should not be allowed to withdraw funds if that withdrawal takes their balance negative.
		one for withdrawing funds from the account
	 */

	public void depositMoney(double amount){
		if(amount < 0){
			System.out.println("Enter a valid amount");
		}
		else
			accountBalance += amount;
	}

	public double withdrawMoney(double amount){
		if((accountBalance - amount) < 0){
			System.out.format("The amount $%s, is more than your bank account balance $%s", amount, getAccountBalance());;
		}
		else{
			accountBalance = accountBalance - amount;
			System.out.format("Your new balance is $%s", getAccountBalance());
		}

		return amount;
	}
}
