package Core;

// Creation Date: May 25, 2026. at 5:37 PM
// Last Modified: May 26, 2026. at 10:45 PM

public class CheckingAccount extends Account {
    //=======VARIABLES=======//
    private double OverdraftLimit;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public CheckingAccount(String AccountNumber, double Balance, String AccountType, double OverdraftLimit) {
        super(AccountNumber, Balance, AccountType);
        this.OverdraftLimit = OverdraftLimit;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    @Override protected void getAccountSummary() {
        super.getAccountSummary();
        System.out.println("Overdraft Limit: "+OverdraftLimit+"$");
    }
    public boolean canWithdraw(double amount) {
        return (Balance-amount) >= OverdraftLimit; // if the amount of money taken from balance is greater than or equal to OverdraftLimit, return true
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
