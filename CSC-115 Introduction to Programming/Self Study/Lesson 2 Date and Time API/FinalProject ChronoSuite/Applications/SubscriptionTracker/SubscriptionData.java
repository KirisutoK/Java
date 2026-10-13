package Applications.SubscriptionTracker;

// Creation Date: September 30, 2026. at 6:31 PM
// Last Modified: October 13, 2026. at 12:23 AM

import java.time.LocalDate;

public class SubscriptionData {
    //=======VARIABLES=======//
    // [PERSONAL]
    private String SubscriptionName;
    private LocalDate CreationDate;
    private double Price;
    private int BillingCycle; // Days until when the next payment is

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


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    void displaySubscription() {
        System.out.println("Subscription Name: "+SubscriptionName);
        System.out.println("Price: $"+Price);
        System.out.println("Billing Cycle: "+BillingCycle+" Days");
        System.out.println("Creation Date: "+CreationDate);
    }




    // ================================================== OTHER CLASSES ================================================== \\
}
