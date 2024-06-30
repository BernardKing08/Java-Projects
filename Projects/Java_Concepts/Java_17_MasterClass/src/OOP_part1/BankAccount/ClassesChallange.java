package OOP_part1.BankAccount;

public class ClassesChallange {
    public static void main(String[] args) {
        Account userAccount = new Account("12345678", 1000, "King Benny", "Bernardkingsley08@Gmail.com", "+(234) 9057180122");

        System.out.println(userAccount.getAccountBalance());
        userAccount.withdrawMoney(2000);

        userAccount.withdrawMoney(200);
    }
}
