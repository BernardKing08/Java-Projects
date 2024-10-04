package AutoBoxing.challange;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branch;

    Bank(String name){
        this.name = name;
        branch = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        if(getBranch(branchName) == null){
            branch.add(new Branch(branchName));
            return true; //returns trus after adding the branch to the arraylist
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        if(getBranch(branchName) != null){
            //if the branch is not equal to null i.e the branch exists
            return getBranch(branchName).addCustomerTransaction(customerName, transaction); 
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        if(getBranch(branchName) != null){
            //if the branch is not equal to null i.e the branch exists
            return getBranch(branchName).newCustomer(customerName, initialTransaction);             
        }

        return false;
    }

    public boolean listCustomers(String branchName, boolean printTransactions){
        if(getBranch(branchName) != null){
            Branch branch = getBranch(branchName);
            //if the branch is not equal to null i.e the branch exists
            if(printTransactions){
                for(var b : branch.getCustomers()) {
                    System.out.println(b.getClass().getName());
                    System.out.println(b.transactions());
                }

                return true;
            }

            branch.getCustomers();
      
        }

        return true;
    }

    public Branch getBranch(String branchName){
        for(var b : branch){
            if(b.getName().equalsIgnoreCase(branchName)){
                return b; // returns true if the bank is found
            }
        }
        
        return null; //returns false if the bank is not found
    }
 
    

}
