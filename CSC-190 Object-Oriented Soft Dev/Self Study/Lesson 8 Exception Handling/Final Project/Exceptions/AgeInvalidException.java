package Exceptions;

public class AgeInvalidException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AgeInvalidException() {
        super("The Age must be 21 above!");
    }
}
