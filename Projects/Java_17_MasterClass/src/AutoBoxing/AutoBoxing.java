package AutoBoxing;

public class AutoBoxing {
    public static void main(String[] args) {
        Customer bob = new Customer("Bob s", 1000);

        //printing user 'bob' info
        System.out.println(bob);

        Bank bank = new Bank("Chase");
        bank.addNewCustomer("Jane", 1000);
        System.out.println(bank);

        bank.addTransaction("Jane", -10.25);
        bank.addTransaction("Jane", -75.25);
        bank.printStatement("Jane");
    }
}
