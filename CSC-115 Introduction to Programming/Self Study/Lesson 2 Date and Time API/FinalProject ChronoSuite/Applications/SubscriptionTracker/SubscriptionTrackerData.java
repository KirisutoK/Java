package Applications.SubscriptionTracker;


// Creation Date: September 30, 2026. at 6:18 PM
// Last Modified: October 03, 2026. at 12:12 AM

import Applications.Application;

import java.time.LocalDate;
import java.util.HashSet;

public class SubscriptionTrackerData { // implements Application
    //=======VARIABLES=======//
    // [PERSONAL]
    private String Author;

    // [CALCULATIONS]
    private int TotalMonthlyPrice;
    private int TotalYearlyPrice;
    private HashSet<SubcriptionData> Subscriptions;

    // [SECURITY]
    private String Password; // TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password. (DO THIS AFTER LEARNING HOW TO ENCRYPT AND HASHING [Cryptography Lessons: Not OOP])
    private boolean EmptyPassword;
    private boolean LoggedIn = false;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    SubscriptionTrackerData(String Author) {
        this.Author = Author;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    // [PERSONAL]
    public String getAuthor() {
        return (LoggedIn) ? Author : null;
    }

    // [SECURITY]
    public boolean getLoggedIn() {
        return LoggedIn;
    } // used for checking back into the application (when you are in the main menu and use the application, if you have current file then use this to check if your are logged in or not)
    public boolean getEmptyPassword() {
        return EmptyPassword;
    }
    public void setPassword(String HashedPassword) {
        this.Password = HashedPassword;
        this.EmptyPassword = false;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // [SECURITY]
    public boolean logIn(String input, String currentUser) {
        //// LoggedUser = currentUser;
        if (Password.equals(input)) {
            LoggedIn = true;
            return true; // true means that it has succefully logged in
        }

        return false; // false means that it did not logged-in successsfully
    }
    public void logOut() {
        LoggedIn = false;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    
    // ================================================== OTHER CLASSES ================================================== \\

}
