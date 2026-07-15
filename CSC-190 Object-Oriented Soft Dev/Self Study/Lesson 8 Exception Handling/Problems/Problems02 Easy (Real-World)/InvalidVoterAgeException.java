public class InvalidVoterAgeException extends Exception {
    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public InvalidVoterAgeException(String name, int age) {
        super(name+" cannot register. Age "+age+" is not valid");
    }
}
