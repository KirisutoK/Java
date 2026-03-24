public class PayPalPayment extends Payment {
    //=======VARIABLES=======//
    private String Email;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public PayPalPayment(double Amount, String PaymentID, String Email) {
        super(Amount, PaymentID);
        this.Email = Email;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal payment of $" + Amount + " to " + Email);
    }
    @Override
    public void displayPaymentInfo() {
        super.displayPaymentInfo();
        System.out.println("Email: " + Email);
    }
}
