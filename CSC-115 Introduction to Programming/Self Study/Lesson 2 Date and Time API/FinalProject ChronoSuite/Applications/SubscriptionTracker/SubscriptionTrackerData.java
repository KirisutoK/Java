package Applications.SubscriptionTracker;


// Creation Date: September 30, 2026. at 6:18 PM
// Last Modified: October 01, 2026. at  1:06 PM

import Applications.Application;

import java.time.LocalDate;
import java.util.HashSet;

public class SubscriptionTrackerData { // implements Application
    //=======VARIABLES=======//
    String Author;
    LocalDate AuthorBirthday;

    int TotalMonthlyPrice;
    int TotalYearlyPrice;
    HashSet<SubcriptionData> Subscriptions;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    SubscriptionTrackerData(String Author, LocalDate AuthorBirthday) {
        this.Author = Author;
        this.AuthorBirthday = AuthorBirthday;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    
    // ================================================== OTHER CLASSES ================================================== \\

}
