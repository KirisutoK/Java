package Core;

// Creation Date: May 25, 2026. at 5:37 PM
// Last Modified: May 25, 2026. at  5:38 PM

public class CheckingAccount extends Account {
    //=======VARIABLES=======//
    private double OverdraftLimit;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public CheckingAccount(String AccountNumber, double Balance, String AccountType, double OverdraftLimit) {
        super(AccountNumber, Balance, AccountType);
        this.OverdraftLimit = OverdraftLimit;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
