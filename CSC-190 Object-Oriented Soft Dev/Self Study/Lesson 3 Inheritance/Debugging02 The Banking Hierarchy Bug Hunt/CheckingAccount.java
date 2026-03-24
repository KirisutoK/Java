public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountHolder, String accountNumber, double balance, double overdraftLimit) {
        super(accountHolder, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {
        if (balance + overdraftLimit > amount) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount);
        } else {
            System.out.println("Overdraft limit exceeded for " + accountHolder);
        }
    }

    public void displayAccount() {
        super.displayAccount(); // Added
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}
