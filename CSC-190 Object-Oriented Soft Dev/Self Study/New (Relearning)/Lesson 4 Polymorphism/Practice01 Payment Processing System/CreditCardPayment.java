public class CreditCardPayment extends Payment {
    //=======VARIABLES=======//
    private String CardNumber;
    private String CardHolderName;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public CreditCardPayment(double Amount, String PaymentID, String CardNumber, String CardHolderName) {
        super(Amount, PaymentID);
        this.CardNumber = CardNumber;
        this.CardHolderName = CardHolderName;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getMaskedCardNumber() { // Mask the String except the last 4 characters
        String MaskedNumber = "";

        // Adding all the masked letters based on how long the string is
        int MaskedNumbers = CardNumber.length() - 4;
        int MaskedNumberCounter = 0;
        for (int i = 0; i < MaskedNumbers; i++) {
            if (MaskedNumberCounter == 4) {
                MaskedNumber += "-";
                MaskedNumberCounter = 0;
            }
            MaskedNumber += "*";
            MaskedNumberCounter++;
        }

        MaskedNumber +=  "-" + CardNumber.substring(MaskedNumbers, CardNumber.length());

        return MaskedNumber;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of $" + Amount + " for " + CardHolderName);
    }
    @Override
    public void displayPaymentInfo() {
        super.displayPaymentInfo();
        System.out.println("Card Number: " + getMaskedCardNumber());
        System.out.println("Card Holder: " + CardHolderName);

    }
}
