package Core;

// Creation Date: May 25, 2026. at 5:26 PM
// Last Modified: May 26, 2026. at 10:30 PM

public class SavingsAccount extends Account {
    //=======VARIABLES=======//
    private double InterestRate;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SavingsAccount(String AccountNumber, double Balance, String AccountType, double InterestRate) {
        super(AccountNumber, Balance, AccountType);
        this.InterestRate = InterestRate;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    @Override protected void getAccountSummary() {
        super.getAccountSummary();
        System.out.println("Interest Rate: "+InterestRate);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void applyInterest() {
        Balance = Balance+(Balance*InterestRate);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
    