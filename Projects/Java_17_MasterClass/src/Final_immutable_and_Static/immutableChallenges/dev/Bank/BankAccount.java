package Final_immutable_and_Static.immutableChallenges.dev.Bank;

import java.util.LinkedHashMap;
import java.util.Map;

import Final_immutable_and_Static.immutableChallenges.dev.dto.Transaction;

public class BankAccount {

    public enum AccountType {CHECKING, SAVINGS}

    private final AccountType accountType;
    private double balance;
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }

    public Map<Long, String> getTransactions() {

        Map<Long, String> txMap = new LinkedHashMap<>();
        for (var tx : transactions.entrySet()) {
            txMap.put(tx.getKey(), tx.getValue().toString());
        }
        return txMap;
    }

    //package private
    void commitTransactions(int routingNumber, long transactionid, String customerId, double amount){
        balance += amount;
        transactions.put(transactionid, new Transaction(routingNumber, transactionid,
            Integer.parseInt(customerId), amount));
    }
}
