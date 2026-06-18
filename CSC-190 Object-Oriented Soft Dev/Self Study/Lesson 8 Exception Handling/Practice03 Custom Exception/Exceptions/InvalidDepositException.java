package Exceptions;

public class InvalidDepositException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public InvalidDepositException(double amount) {
        // System.out.println("Invalid deposit amount: $"+amount); //... <================ THIS JUST PRINTS IN THE CONSTRUCTOR
        super("Invalid deposit amount: $"+amount); //... <============== THIS ACTUALLY IS INSIDE/PART OF THE CONSTRUCTOR (STORED IN IT) [IT PASSES THE STRING INTO THE EXCEPTION CLASS]
    }
}

// NOTES:
//
// using super(); makes you able to call e.getMessage();