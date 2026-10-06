package Applications.SubscriptionTracker;

// Creation Date: September 30, 2026. at 6:31 PM
// Last Modified: October 06, 2026. at  3:45 PM

import Misc.DataManager;

import java.time.LocalDate;

public class SubcriptionData {
    //=======VARIABLES=======//
    // [PERSONAL]
    private String SubscriptionName;
    private LocalDate ExpiryDate;
    private LocalDate CreationDate;
    private double Price;

    // [PERIODICALS]
    private boolean Monthly;
    private boolean Yearly;
    private String CustomPeriod;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    SubcriptionData(String SubscriptionName, LocalDate ExpiryDate, double Price) {
        this.SubscriptionName = SubscriptionName;
        this.ExpiryDate = ExpiryDate;
        this.Price = Price;

        CreationDate = LocalDate.now();
    }
    SubcriptionData(String SubscriptionName, LocalDate ExpiryDate, double Price, int MonthlyOrYearly) {
        this.SubscriptionName = SubscriptionName;
        this.ExpiryDate = ExpiryDate;
        this.Price = Price;
        if (MonthlyOrYearly == 1) {
            Monthly = true;
        } else {
            Yearly = true;
        }

        CreationDate = LocalDate.now();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    String getSubscriptionName() {
        return SubscriptionName;
    }
    String getExpiryDate() {
        return DataManager.toStringDate(ExpiryDate, "MMMM dd, yyyy");
    }
    String getPrice() {
        if (Monthly) {
            return Price+" (Monthly)";
        } else if (Yearly) {
            return Price+" (Yearly)";
        } else {
            return Price+"";
        }
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
