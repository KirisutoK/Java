package Applications.SubscriptionTracker;

// Creation Date: September 30, 2026. at 6:31 PM
// Last Modified: September 30, 2026. at  6:55 PM

import Misc.DataManager;

import java.time.LocalDate;

public class Subcription {
    //=======VARIABLES=======//
    String SubscriptionName;
    LocalDate ExpiryDate;
    LocalDate CreationDate;
    double Price;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    Subcription(String SubscriptionName, LocalDate ExpiryDate, double Price) {
        this.SubscriptionName = SubscriptionName;
        this.ExpiryDate = ExpiryDate;
        this.Price = Price;

        CreationDate = LocalDate.now();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    String getSubscriptionName() {
        return SubscriptionName;
    }
    String getExpiryDate() {
        return DataManager.toStringDate(ExpiryDate, "SOMETHING"); //! <=================== FORMAT NEEDS TO BE INITIALIZED
    }
    double getPrice() {
        return Price;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    void displaySubscription() {
        System.out.println("Name: "+SubscriptionName);
        System.out.println();
        System.out.println();
    }




    // ================================================== OTHER CLASSES ================================================== \\
}
