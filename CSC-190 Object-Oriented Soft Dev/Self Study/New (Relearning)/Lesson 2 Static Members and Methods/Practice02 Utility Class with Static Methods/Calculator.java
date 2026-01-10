public class Calculator {
    //=======VARIABLES=======//
    private double result;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Calculator() {
        result = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getResult() {
        return result;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void add(double num) {
        result += num;
    }
    public void subtract(double num) {
        result -= num;
    }
    public void multiply(double num) {
        result = result*num;
    }
    public void division(double num) {
        result = result/num;
    }
    public void reset() {
        result = 0;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
