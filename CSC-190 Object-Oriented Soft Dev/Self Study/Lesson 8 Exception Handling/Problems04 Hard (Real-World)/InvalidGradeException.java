public class InvalidGradeException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public InvalidGradeException(double grade) {
        super("Invalid grade: "+grade+". Must be between 0 and 100");
    }
}
