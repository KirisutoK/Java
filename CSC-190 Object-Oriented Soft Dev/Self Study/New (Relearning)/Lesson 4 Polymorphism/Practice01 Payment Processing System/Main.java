public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS or INSTANCES
        CreditCardPayment CCPayment01 = new CreditCardPayment(150.00, "CCP100", "214325354654", "Bella"); // Payments[0]
        PayPalPayment PPPayment01 = new PayPalPayment(75.50, "PPP100", "TestPayPalPayment_01@Gmail.com"); // Payments[1]
        CashPayment CPayment01 = new CashPayment(50.00, "CP100", 60.00); // Payments[2]
        CreditCardPayment CCPayment02 = new CreditCardPayment(200.00, "CCP101", "234332314654", "Christ"); // Payments[3]
        PayPalPayment PPPayment02 = new PayPalPayment(99.99, "PPP101", "TestPayPalPayment_02@Gmail.com");

        Payment[] Payments = {CCPayment01, PPPayment01, CPayment01, CCPayment02, PPPayment02}; // An Array of Children with common Parent

        // PROCESS PAYMENT
        System.out.println("=== PROCESS PAYMENT ===");
        for (Payment i : Payments) {
            i.processPayment();
        }
        System.out.println(" "); // Space for Readability

        // DISPLAY INFO
        System.out.println("=== DISPLAY INFO ===");
        for (Payment i : Payments) { // Enhanced For Loops
            i.displayPaymentInfo();
            System.out.println(" "); // Space for Readability
        }

        // TOTAL PAYMENT AMOUNT
        System.out.println("=== TOTAL PAYMENT AMMOUNT ===");
        double TotalPaymentAmount = 0;
        for (Payment i : Payments) {
            TotalPaymentAmount += i.Amount;
            System.out.println("+ $" + i.Amount + " from " + i.PaymentID);
        }
        System.out.println("Total Payment Amount: " + TotalPaymentAmount);
        System.out.println(" "); // Space for Readability

        // INSTANCEOF -- Checks Class type
        System.out.println("=== INSTANCEOF SYNTAX===");

        int TotalCashPayment = 0;
        int TotalPayPalPayment = 0;
        int TotalCreditCardPayment = 0;

        for (Payment i : Payments) {
            if (i instanceof CashPayment) { // checks if that value inside the array is this specific class
                TotalCashPayment++;
            } else if (i instanceof  PayPalPayment) {
                TotalPayPalPayment++;
            } else if (i instanceof CreditCardPayment) {
                TotalCreditCardPayment++;
            }
        }
        System.out.println("Total Cash Payment: " + TotalCashPayment);
        System.out.println("Total PayPal Payment: " + TotalPaymentAmount);
        System.out.println("Total Credit Card Payment: " + TotalCreditCardPayment);
    }
}
