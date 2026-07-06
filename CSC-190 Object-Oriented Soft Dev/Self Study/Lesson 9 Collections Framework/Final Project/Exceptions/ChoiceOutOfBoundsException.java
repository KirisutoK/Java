package Exceptions;

public class ChoiceOutOfBoundsException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ChoiceOutOfBoundsException() {
        super("Please choose from 1 to 6");
    }
}
