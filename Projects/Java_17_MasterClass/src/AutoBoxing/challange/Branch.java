package AutoBoxing.challange;

import java.util.ArrayList;

public class Branch {
    private String name; 
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction){
        if(findCustomer(customerName) == null){            
            customers.add(new Customer(customerName, initialTransaction)); //initializes and adds a new customer to the arrayList customers
            return true;
        }
        else{
            return false; //customer already exists
        }
    }

    public boolean addCustomerTransaction(String customerName, double transaction){
        if(findCustomer(customerName) != null){ //the customer is found and the transaction is added to its transaction arrayList       
            findCustomer(customerName).transactions().add(transaction);
            return true;
        }
        
        return false;
    }

    public Customer findCustomer(String customerName){
        for(var customer : customers){
            if(customer.name().equalsIgnoreCase(customerName)){
                return customer; 
            }
        }

        return null; //customer was not found
    }

    
}
