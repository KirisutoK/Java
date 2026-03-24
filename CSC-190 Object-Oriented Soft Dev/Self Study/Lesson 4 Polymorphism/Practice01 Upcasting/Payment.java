public class Payment { // PARENT (SUPERCLASS)
    //=======VARIABLES=======//
    protected double Amount;
    protected String PaymentID;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Payment(double Amount, String PaymentID) {
        this.Amount = Amount;
        this.PaymentID = PaymentID;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void processPayment() {
        System.out.println("Processing payment of $" + Amount);
    }
    public void displayPaymentInfo() {
        System.out.println("Amount: " + Amount);
        System.out.println("Payment ID: " + PaymentID);
    }
}
