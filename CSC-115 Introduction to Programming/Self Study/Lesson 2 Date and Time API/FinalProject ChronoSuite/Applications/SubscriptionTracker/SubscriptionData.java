package Applications.SubscriptionTracker;

// Creation Date: September 30, 2026. at 6:31 PM
// Last Modified: October 13, 2026. at 12:01 AM

import Misc.DataManager;

import java.time.LocalDate;

public class SubscriptionData {
    //=======VARIABLES=======//
    // [PERSONAL]
    private String SubscriptionName;
    private LocalDate ExpiryDate;
    private LocalDate CreationDate;
    private double Price;
    private int DaysUntilDue;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    SubscriptionData(String SubscriptionName, LocalDate ExpiryDate, double Price) {
        this.SubscriptionName = SubscriptionName;
        this.ExpiryDate = ExpiryDate;
        this.Price = Price;

        CreationDate = LocalDate.now();
    }
    SubscriptionData(String SubscriptionName, LocalDate ExpiryDate, double Price, int DaysUntilDue) {
        this.SubscriptionName = SubscriptionName;
        this.ExpiryDate = ExpiryDate;
        this.Price = Price;
        this.DaysUntilDue = DaysUntilDue; // Note: We must

        CreationDate = LocalDate.now();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    String getSubscriptionName() {
        return SubscriptionName;
    }
    String getExpiryDate() {
        return DataManager.toStringDate(ExpiryDate, "MMMM dd, yyyy");
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    void displaySubscription() {
        System.out.println("Name: "+SubscriptionName);
        System.out.println("Expiration Date: "+getExpiryDate());
        System.out.println("Price: "+getPrice());
    }




    // ================================================== OTHER CLASSES ================================================== \\
}
