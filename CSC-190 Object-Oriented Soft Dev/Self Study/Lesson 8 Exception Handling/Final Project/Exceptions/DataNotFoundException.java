package Exceptions;

public class DataNotFoundException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public DataNotFoundException() {
        super("Data can't be found!");
    }
}
