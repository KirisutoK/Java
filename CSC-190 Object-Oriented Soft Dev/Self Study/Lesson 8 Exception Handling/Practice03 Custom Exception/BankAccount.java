// Creation Date: June 17, 2026. at 9:13 AM
// Last Modified: June 17, 2026. at  4:47 PM

import Exceptions.*;

public class BankAccount {
    //=======VARIABLES=======//
    private String AccountHolder;
    private double Balance;
    private boolean isFrozen;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BankAccount(String AccountHolder, double initialbalance) {
        this.AccountHolder = AccountHolder;
        this.Balance = initialbalance;
        this.isFrozen = false;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getBalance() {
        return Balance;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void deposit(double amount) throws InvalidDepositException, AccountFrozenException {
        if (isFrozen) {
            throw new AccountFrozenException();
        } else if (amount <= 0) {
            throw new InvalidDepositException(amount);
        } else {
            Balance += amount;
        }
    }
    public void withdraw(double amount) throws InsufficientFundsException, AccountFrozenException {
        if (isFrozen) {
            throw new AccountFrozenException();
        } else if (amount > Balance) {
            throw new InsufficientFundsException(amount);
        } else {
            Balance = Balance - amount;
        }
    }
    public void freezeAcount() {
        isFrozen = true;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInfo() {
        System.out.println("Account Holder: "+AccountHolder);
        System.out.println("Balance: "+Balance);
        System.out.println("Is Frozen: "+isFrozen);
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
