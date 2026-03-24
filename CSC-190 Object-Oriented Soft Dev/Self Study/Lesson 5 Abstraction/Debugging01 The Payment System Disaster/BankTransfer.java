// BankTransfer.java
public class BankTransfer extends Payment implements Verifiable {
    private String accountNumber;

    public BankTransfer(String payerName, double amount, String accountNumber) {
        super(payerName, amount);
        this.accountNumber = accountNumber;
    }

    public void processPayment() {
        System.out.println("Processing bank transfer for " + payerName);
    }

    public boolean verify() {
        return accountNumber.startsWith("ACC") || accountNumber.length() >= 6;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Account: " + accountNumber);
    }
}