package Core;

// Creation Date: May 24, 2026. at 6:44 PM
// Last Modified: May 24, 2026. at  7:03 PM

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankingService {
    //=======VARIABLES=======//
    private String BankingServiceName;
    private Account[] Accounts;
    private int AccountCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BankingService() {
        Accounts = new Account[10];
        AccountCount = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void deposit(String AccountNumber, double Amount) {
        //? FINDING THE ACCOUNT
        boolean AccountExists = false;
        for (int i = 0; i < AccountCount; i++) {
            if (AccountNumber.equals(Accounts[i].AccountNumber)) {
                Transactions deposit = new Transactions("Deposit123", Amount, "Deposit");
                AccountExists = true;
            }
        }

        //? IF THE ACCOUNT NUMBER CANT BE FOUND
        if (!AccountExists) {
            System.out.println("Account Number invalid!");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void createAccount(String AccountNumber, double Balance, String AccountType) {
        //? CHECK IF ACCOUNTS ARRAY IS FULL
        if (AccountCount > Accounts.length) {
            System.out.println(BankingServiceName+" is full: ["+AccountCount+"/10]");
            return; // Stops the whole method here
        }
        
        //? CHECK IF BALANCE IS VALID (MUST NOT BE NEGATIVE)
        if (Balance < 0) {
            System.out.println("Balance must not be less than 0");
            return; // Stops the whole method
        }

        //? CREATES AND ADD NEW ACCOUNT TO THE ARRAY
        Accounts[AccountCount] = new Account(AccountNumber, Balance, AccountType);
    }
}
