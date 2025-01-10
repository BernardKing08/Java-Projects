package Final_immutable_and_Static.immutableChallenges;

import java.util.List;

import Final_immutable_and_Static.immutableChallenges.dev.Bank.BankAccount;
import Final_immutable_and_Static.immutableChallenges.dev.Bank.BankCustomer;

public class Main {

    public static void main(String[] args) {

//        BankAccount account =
//                new BankAccount(BankAccount.AccountType.CHECKING, 500);
//        System.out.println(account);

        BankCustomer joe = new BankCustomer("Joe", 500.00,
                10000.00);
        System.out.println(joe);

        List<BankAccount> accounts = joe.getAccounts();
        accounts.clear();
        System.out.println(joe);

    }
}