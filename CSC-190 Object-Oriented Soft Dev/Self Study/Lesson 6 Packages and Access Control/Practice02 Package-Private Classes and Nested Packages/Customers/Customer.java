package Customers;

// Creation Date: May 27, 2026. at 2:49 PM
// Last Modified: May 29, 2026. at  3:31 AM

import Core.BankingService;

public class Customer {
    //=======VARIABLES=======//
    private String Name;
    private String CustomerID;
    private String PimaryAccountNumber;
    private BankingService Bank;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Customer(String Name, String CustomerID, BankingService Bank) {
        this.Name = Name;
        this.CustomerID = CustomerID;
        this.Bank = Bank;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getCustomerID() {
        return CustomerID;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    private void setPrimaryAccountNumber(String PrimaryAccountNumber) {
        this.PimaryAccountNumber = PrimaryAccountNumber;
    }
    void openAccount(BankingService bank, double balance, String accountType) {
        bank.createAccount(balance, accountType);
        setPrimaryAccountNumber("00"+ Bank.getAccountCount());
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// TODO: LEFT HERE ON THIS CLASS
// TODO: DID NOT KNOW HOW TO CREATE AN ACCOUNT FOR A SPECIFIC BANK
// TODO: TOO MUCH STUFF TO DO