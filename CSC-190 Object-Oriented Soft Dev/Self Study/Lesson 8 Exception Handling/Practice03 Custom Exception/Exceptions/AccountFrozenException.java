package Exceptions;

public class AccountFrozenException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AccountFrozenException() {
        // System.out.println("This account is frozen and cannot perform transactions"); //... <================ THIS JUST PRINTS IN THE CONSTRUCTOR
        super("This account is frozen and cannot perform transactions"); //... <============== THIS ACTUALLY IS INSIDE/PART OF THE CONSTRUCTOR (STORED IN IT) [IT PASSES THE STRING INTO THE EXCEPTION CLASS]
    }
}

// NOTES:
//
// using super(); makes you able to call e.getMessage();