package Core;

// Creation Date: May 24, 2026. at 6:35 PM
// Last Modified: May 26, 2026. at 10:09 PM

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Transactions {
    //=======VARIABLES=======//
    private String TransactionID;
    private double Amount;
    private String Type;
    private String Timestamp;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Transactions(String TransactionID, double Amount, String Type) {
        this.TransactionID = TransactionID;
        this.Amount = Amount;
        this.Type = Type;

        // Get current timestamp  <============== With the help of Claude
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Timestamp = now.format(formatter);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    void getDetails() {
        System.out.println("Transaction ID: "+TransactionID);
        System.out.println("Amount: "+Amount);
        System.out.println("Type: "+Type);
        System.out.println("Timestamp: "+ Timestamp);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void processTransaction(Account account) {
        if (Type.equalsIgnoreCase("DEPOSIT")) {
            account.updateBalance(account.getBalance() + Amount); // Adds up Balance
        } else if (Type.equalsIgnoreCase("Withdraw")) {
            account.updateBalance(account.getBalance() - Amount); // Subtracts Balance
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
