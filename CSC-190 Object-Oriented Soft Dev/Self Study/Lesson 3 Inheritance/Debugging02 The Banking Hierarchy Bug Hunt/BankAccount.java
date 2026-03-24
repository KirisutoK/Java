public class BankAccount {
    protected String accountHolder;
    protected String accountNumber;
    protected double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds for " + accountHolder);
        }
    }

    public void displayAccount() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
