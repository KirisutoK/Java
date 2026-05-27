package Core;

// Creation Date: May 24, 2026. at 6:44 PM
// Last Modified: May 27, 2026. at  2:58 PM

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
    public double getAccountBalance(String accountNumber) {
        //? FINDING THE ACCOUNT
        for (int i = 0; i < AccountCount; i++) {
            if (accountNumber.equals(Accounts[i].AccountNumber)) {
                return Accounts[i].getBalance();
            }
        }

        return -1; // if it's not found
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void deposit(String AccountNumber, double Amount) {
        //? FINDING THE ACCOUNT
        boolean AccountExists = false;
        for (int i = 0; i < AccountCount; i++) {
            if (AccountNumber.equals(Accounts[i].AccountNumber)) {
                Transactions deposit = new Transactions("D"+AccountNumber+AccountCount, Amount, "Deposit");
                deposit.processTransaction(Accounts[i]);
                AccountExists = true;
                System.out.println(Amount+"$ has been deposited to "+AccountNumber);
            }
        }

        //? IF THE ACCOUNT NUMBER CANT BE FOUND
        if (!AccountExists) {
            System.out.println("Account Number invalid!");
        }
    }
    public void withdraw(String AccountNumber, double Amount) {
        //? FINDING THE ACCOUNT
        Account TargetAccount = null;
        boolean AccountExists = false;
        boolean ValidAmount = false;
        for (int i = 0; i < AccountCount; i++) {
            if (AccountNumber.equals(Accounts[i].AccountNumber)) {
                TargetAccount = Accounts[i];
                AccountExists = true;
                if (Accounts[i] instanceof CheckingAccount) { // if its a checking account
                    if (!((CheckingAccount) TargetAccount).canWithdraw(Amount)) { // if it cant withdraw
                        System.out.println("Transaction Denied: Taking more money will hit "+AccountNumber+"'s the overdraft limit");
                        return; // stops the whole method here
                    } else { // if it can withdraw
                        ValidAmount = true;
                    }
                } else if (Accounts[i].getBalance() >= Amount) { // if the balance is greater than the Amount
                    ValidAmount = true;
                }
            }
        }

        //? PROCESSING THE TRANSACTION
        if (AccountExists && ValidAmount) { // <============================================================================================ LEFT HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
            Transactions withdraw = new Transactions("W"+AccountNumber+AccountCount, Amount, "Withdraw");
            withdraw.processTransaction(TargetAccount);
            System.out.println(Amount+"$ has been withdraw from "+AccountNumber);
            return; // Stops the whole method here
        }

        //? IF THE ACCOUNT NUMBER CANT BE FOUND
        if (!AccountExists) {
            System.out.println("Account Number invalid!");
        } else if (!ValidAmount) {
            System.out.println(AccountNumber+" does not have the valid amount to withdraw $"+Amount);
        }
    }
    public void openAccount(String AccountType) {
        //? CHECK IF IT'S ALREADY FULL
        if (AccountCount > Accounts.length) {
            System.out.println(BankingServiceName+" is currently full!");
            return; // stops the whole method here
        }

        //? CREATES AN ACCOUNT
        Accounts[AccountCount] = new Account("00"+AccountCount, 0, AccountType);
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
