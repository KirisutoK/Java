// PayPal.java
public class PayPal
        extends Payment
        implements Refundable {
    private String email;

    public PayPal(String payerName, double amount, String email) {
        super(payerName, amount);
        this.email = email;
    }

    public void processPayment() {
        System.out.println("Processing PayPal payment for " + payerName);
    }

    public void refund() {
        System.out.println("Refunding $" + getRefundAmount() + " to " + email);
    }

    public double getRefundAmount() {
        return amount;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("PayPal: " + email);
    }
}