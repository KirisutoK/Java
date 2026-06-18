package Exceptions;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(double amount) {
        // System.out.println("Insufficient Funds, you are short by $"+amount);  // <================ THIS JUST PRINTS IN THE CONSTRUCTOR
        super("Insufficient funds. You are short by $"+amount); //... <============== THIS ACTUALLY IS INSIDE/PART OF THE CONSTRUCTOR (STORED IN IT) [IT PASSES THE STRING INTO THE EXCEPTION CLASS]
    }
}

// NOTES:
//
// using super(); makes you able to call e.getMessage();