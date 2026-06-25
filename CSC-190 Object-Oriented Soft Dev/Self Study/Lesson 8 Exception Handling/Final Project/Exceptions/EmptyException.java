package Exceptions;

public class EmptyException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public EmptyException() {
        super("The Data is empty! (OR NULL)");
    }
}
