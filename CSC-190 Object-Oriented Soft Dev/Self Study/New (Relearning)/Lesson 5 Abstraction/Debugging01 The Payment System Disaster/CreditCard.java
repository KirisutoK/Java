// CreditCard.java
public class CreditCard
        extends Payment
        implements Refundable, Verifiable {
    private String cardNumber;

    public CreditCard(String payerName, double amount, String cardNumber) {
        super(payerName, amount);
        this.cardNumber = cardNumber;
    }

    public void processPayment() {
        System.out.println("Processing credit card payment for " + payerName);
    }

    public void refund() {
        System.out.println("Refunding $" + amount + " to card " + cardNumber);
    }

    public double getRefundAmount() {
        return amount;
    }

    public boolean verify() {
        return cardNumber.length() > 16;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Card: " + maskCard(cardNumber));
    }

    private String maskCard(String card) {
        return "****-****-****-" + card.substring(card.length() - 4);
    }
}