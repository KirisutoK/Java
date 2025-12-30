import java.util.Scanner;

public class Customers {
    static Scanner scanner = new Scanner(System.in);

    //=======VARIABLES=======//
    private String CustomerName = "";
    private int CustomerID = 0;
    private BankAccounts PrimaryAccount; // has default values but not changeable values
    private BankAccounts SavingsAccount; // has default values but not changeable values

    private Boolean hasPrimaryAccount = false; // Checks if they have opened a primary account
    private Boolean hasSavingsAccount = false; // Checks if they have opened a savings account

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Customers(String CustomerName, int CustomerID) {
        this.CustomerName = CustomerName;
        this.CustomerID = CustomerID;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getCustomerName() {
        return CustomerName;
    }
    public int getCustomerID() {
        return CustomerID;
    }
    public BankAccounts getPrimaryAccount() {
        return PrimaryAccount;
    }
    public BankAccounts getSavingsAccount() {
        return SavingsAccount;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void openAccount(BankAccounts account, String accounttype) {
        if (accounttype.equalsIgnoreCase("Primary")) {
            PrimaryAccount = account;
            hasPrimaryAccount = true;
            System.out.println("you have successfully opened a primary banking account");
        } else if (accounttype.equalsIgnoreCase("Savings")) {
            SavingsAccount = account;
            hasSavingsAccount = true;
            System.out.println("you have successfully opened a savings banking account");
        }
    }
    public void transferMoneyBetweenOwnAccounts(double amount, String fromAccount, String toAccount) { // TRANSFERS MONEY FROM PRIMARY/SAVINGS ACCOUNT TO PRIMARY/SAVINGS ACCOUNT (SAME USER)
        if (fromAccount.equalsIgnoreCase("Primary") && toAccount.equalsIgnoreCase("Savings")) { // IF FROM PRIMARY && TO SAVINGS
            PrimaryAccount.transfer(SavingsAccount, amount);
        } else if (fromAccount.equalsIgnoreCase("Savings") && toAccount.equalsIgnoreCase("Primary")) { // IF FROM SAVINGS && TO PRIMARY
            SavingsAccount.transfer(PrimaryAccount, amount);
        }
    }

    public void DisplayInfoCustomerBankAccount() { // Displays the Info of the customer and if they have opened a primary account or savings account
        System.out.println("Customer Name: " + CustomerName);
        System.out.println("Customer ID: " + CustomerID);
        System.out.println("Primary Account: " + hasPrimaryAccount);
        System.out.println("Savings Accounts: " + hasSavingsAccount);
    }
}