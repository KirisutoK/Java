public class CashPayment extends Payment {
    //=======VARIABLES=======//
    private double ReceivedAmount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public CashPayment(double Amount, String PaymentID, double ReceivedAmount) {
        super(Amount, PaymentID);
        this.ReceivedAmount = ReceivedAmount;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double calculateChange() {
        return ReceivedAmount - Amount;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // @OVERRIDE
    @Override
    public void processPayment() {
        System.out.println("Processing payment of $" + Amount);
    }
    @Override
    public void displayPaymentInfo() {
        super.displayPaymentInfo();
        System.out.println("Received Amount: " + ReceivedAmount);
        System.out.println("Change: " + calculateChange());
    }
}
