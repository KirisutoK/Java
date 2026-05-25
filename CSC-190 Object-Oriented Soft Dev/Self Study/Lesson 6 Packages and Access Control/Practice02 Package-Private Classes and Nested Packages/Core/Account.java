package Core;

// Creation Date: May 24, 2026. at 11:05 AM
// Last Modified: May 25, 2026. at  5:50 PM

class Account {
    //=======VARIABLES=======//
    protected String AccountNumber;
    protected double Balance;
    protected String AccountType;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Account(String AccountNumber, double Balance, String AccountType) {
        this.AccountNumber = AccountNumber;
        this.Balance = Balance;
        this.AccountType = AccountType;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getBalance() {
        return Balance;
    }
    protected void getAccountSummary() {
        System.out.println("Account Nunmber: "+AccountNumber);
        System.out.println("Balance: "+Balance);
        System.out.println("Account Type: "+AccountType);
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void addBalance(double amount) {
        Balance = Balance+amount;
    }
    void subtractBalance(double amount) {
        Balance = Balance-amount;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
