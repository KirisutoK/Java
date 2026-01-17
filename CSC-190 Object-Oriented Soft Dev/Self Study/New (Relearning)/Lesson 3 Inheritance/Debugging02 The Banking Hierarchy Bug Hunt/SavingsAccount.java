public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountHolder, String accountNumber, double balance, double interestRate) {
        super(accountHolder, accountNumber, balance); // Changed
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest applied: $" + interest);
        System.out.println("New balance: $" + balance);
    }

    public void displayAccount() {
        super.displayAccount();
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}
