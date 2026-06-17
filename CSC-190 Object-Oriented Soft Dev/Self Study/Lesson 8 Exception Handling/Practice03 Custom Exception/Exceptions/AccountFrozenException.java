package Exceptions;

public class AccountFrozenException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AccountFrozenException() {
        System.out.println("This account is frozen and cannot perform transactions");
    }
}
