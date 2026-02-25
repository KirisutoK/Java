// Refundable.java (Interface)
public interface Refundable {
    void refund();
    double getRefundAmount(); // This was the problem here, CreditCard [CLASS] and PayPal [CLASS] does not have this method.
}