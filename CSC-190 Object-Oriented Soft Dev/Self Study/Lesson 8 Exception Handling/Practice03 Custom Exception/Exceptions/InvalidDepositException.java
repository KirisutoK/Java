package Exceptions;

public class InvalidDepositException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public InvalidDepositException(double amount) {
        System.out.println("Invalid deposit amount: $"+amount);
    }
}
