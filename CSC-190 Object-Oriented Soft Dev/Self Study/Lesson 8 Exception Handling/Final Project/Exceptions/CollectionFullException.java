package Exceptions;

public class CollectionFullException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public CollectionFullException() {
        super("The collection is currently full!");
    }
}
