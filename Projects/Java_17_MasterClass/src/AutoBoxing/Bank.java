package AutoBoxing;

import java.util.ArrayList;

public class Bank {
    private String name; 
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name){
        this.name = name;
    }

    private Customer getCustomer(String CustomerName){

        //searching thorugh the list of customers 
        for(var customer : customers){
            if(customer.name().equals(CustomerName.toUpperCase())){
                return customer; 
            }
        }

        //if customer is not found
        System.out.printf("Customer (%s) was not found %n", CustomerName);
        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit){
        if(getCustomer(customerName) == null){
            Customer customer = new Customer(customerName, initialDeposit); //checks if the customer already exists and adds the customer if false
            customers.add(customer); // adding the newly created customer to the list

            System.out.println("New Customer added: " + customer);
        }
    }

    //generating a toString method
    @Override
    public String toString(){
        return "Bank{" + 
                "name = " + name + '\'' +
                ", customers = " + customers + 
                '}';
    }

    public void addTransaction(String name, double transactionAmount){
        Customer customer = getCustomer(name);

        if(customer != null){
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName){
        Customer customer = getCustomer(customerName);

        if(customer == null){
            return;
        }

        System.out.println("_".repeat(30)); //line to seperate entries
        System.out.println("Customer Name: " + customer.name());
        System.out.println("Transactions: ");

        //printing user transactions
        for(double d : customer.transactions()){ //unboxing
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}
