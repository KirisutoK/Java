package Customers;

// Creation Date: May 27, 2026. at 2:49 PM
// Last Modified: May 27, 2026. at  3:01 PM

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

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// TODO: LEFT HERE ON THIS CLASS
// TODO: DID NOT KNOW HOW TO CREATE AN ACCOUNT FOR A SPECIFIC BANK