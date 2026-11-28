package Applications.SubscriptionTracker;


// Creation Date: September 30, 2026. at 6:18 PM
// Last Modified: November 27, 2026. at 11:46 PM

import java.util.HashSet;

public class SubscriptionTrackerData { // implements Application
    //=======VARIABLES=======//
    // [PERSONAL]
    private String Author;

    // [SECURITY]
    private String Password; // TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password. (DO THIS AFTER LEARNING HOW TO ENCRYPT AND HASHING [Cryptography Lessons: Not OOP])
    private boolean EmptyPassword;
    private transient boolean LoggedIn = false;
    private String LoggedUser; // the last user who logged into this file

    // [CALCULATIONS]
    private double TotalMonthlyCost = 0;
    private double TotalYearlyCost = 0;
    private HashSet<SubscriptionData> Subscriptions;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    SubscriptionTrackerData(String Author) {
        this.Author = Author;
        TotalMonthlyCost = 0.0;
        TotalYearlyCost = 0.0;
        EmptyPassword = true;
        Subscriptions = new HashSet<>();
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getAuthor() {
        return (LoggedIn) ? Author : null;
    }
    public String getLoggedUser() {
        return LoggedUser;
    }
    public boolean isEmpty() {
        return Subscriptions == null || Subscriptions.isEmpty();
    }
    public HashSet<SubscriptionData> getSubscriptions() {
        return Subscriptions;
    }
    public SubscriptionData getSubscription(String SubscriptionName) {
        for (SubscriptionData SD: Subscriptions) {
            if (SD.getSubscriptionName().equals(SubscriptionName)) {
                return SD;
            }
        }

        return null; // It's null if nothing matches in the HashSet<SubscriptionData>
    }
    public double getTotalMonthlyCost() {
        TotalMonthlyCost = 0;

        // CALCULATE EVERY SUBS IN MONTHLY: Price * (30.44/BillingCycle)
        for (SubscriptionData SD: Subscriptions) {
            TotalMonthlyCost += SD.getPrice()*(30.44/SD.getBillingCycle());
        }
        
        return TotalMonthlyCost;
    }
    public double getTotalYearlyCost() {
        TotalYearlyCost = 0;

        // CALCULATE EVERY SUBS IN MONTHLY: Price * (365.25/BillingCycle)
        for (SubscriptionData SD: Subscriptions) {
            TotalYearlyCost += SD.getPrice()*(365.25/SD.getBillingCycle());
        }

        return TotalYearlyCost;
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
        if (Password.equals(input)) {
            LoggedUser = currentUser;
            LoggedIn = true;
            return true; // true means that it has succefully logged in
        }

        return false; // false means that it did not logged-in successsfully
    }
    public void logOut() {
        LoggedIn = false;
    }

    // [DATA MANAGEMENT]
    boolean addSubscription(SubscriptionData Subscription) {
        return Subscriptions.add(Subscription);
    }
    boolean removeSubscription(SubscriptionData Subscription) {
        return Subscriptions.remove(Subscription);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    
    // ================================================== OTHER CLASSES ================================================== \\



}
