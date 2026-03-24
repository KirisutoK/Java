// Payment.java (Abstract Class)
public abstract class Payment {
    protected String payerName;
    protected double amount;

    public Payment(String payerName, double amount) {
        this.payerName = payerName;
        this.amount = amount;
    }

    public abstract void processPayment();

    public void displayInfo() {
        System.out.println("Payer: " + payerName);
        System.out.println("Amount: $" + amount);
    }

    public String getPayerName() {
        return payerName;
    }

    public double getAmount() {
        return amount;
    }
}