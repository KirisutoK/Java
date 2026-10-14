package Applications.SubscriptionTracker;

// Creation Date: September 30, 2026. at 6:31 PM
// Last Modified: October 13, 2026. at 11:31 PM

import java.time.LocalDate;

public class SubscriptionData {
    //=======VARIABLES=======//
    // [PERSONAL]
    String SubscriptionName;
    LocalDate CreationDate;
    double Price;
    int BillingCycle; // Days until when the next payment is

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    SubscriptionData(String SubscriptionName, double Price, int BillingCycle) { //... If this is a Subscription that was made today
        this.SubscriptionName = SubscriptionName;
        this.Price = Price;
        this.BillingCycle = BillingCycle; // Days until due

        CreationDate = LocalDate.now();
    }
    SubscriptionData(String SubscriptionName, double Price, int BillingCycle, LocalDate CreationDate) { //... If this Subscription had already started before today or after today.
        this.SubscriptionName = SubscriptionName;
        this.Price = Price;
        this.BillingCycle = BillingCycle; // Days until due
        this.CreationDate = CreationDate;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getSubscriptionName() {
        return SubscriptionName;
    }
    public LocalDate getCreationDate() {
        return CreationDate;
    }
    public double getPrice() {
        return Price;
    }
    public int getBillingCycle() {
        return BillingCycle;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS




    // ================================================== OTHER CLASSES ================================================== \\
}
