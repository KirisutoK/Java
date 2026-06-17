package Exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(double amount) {
        System.out.println("Insufficient Funds, you are short by $"+amount);
    }
}
