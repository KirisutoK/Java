import java.util.Scanner;

public class Customers {
    static Scanner scanner = new Scanner(System.in);

    //=======VARIABLES=======//
    private String CustomerName = "";
    private int CustomerID = 0;
    private BankAccounts PrimaryAccount; // has default values but not changeable values
    private BankAccounts SavingsAccount; // has default values but not changeable values

    static Boolean hasPrimaryAccount = false; // Checks if they have opened a primary account
    static Boolean hasSavingsAccount = false; // Checks if they have opened a savings account

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
        double PrimaryAccountBalance = PrimaryAccount.getAccountBalance();
        double SavingsAccountBalance = SavingsAccount.getAccountBalance();

        if (amount >= PrimaryAccountBalance || amount >= SavingsAccountBalance) { // CHECKS IF THE AMOUNT IS EQUAL OR GREATER THAN THE CURRENT BALANCE
            if (fromAccount.equalsIgnoreCase("Primary")) { // ASKS FOR CONFIRMATION
                System.out.println("Would you like to transfer $" + amount + "from your [Primary Account] to your [Savings Account]?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println(" ");
                System.out.print("\nAnswer Box: ");

                int ConfirmationChoice = scanner.nextInt(); // DEDUCTS PRIMARY ACCOUNT BALANCE AND ADDS UP SAVINGS ACCOUNT BASED ON AMOUNT
                if (ConfirmationChoice == 1) {
                    PrimaryAccountBalance -= amount;
                    SavingsAccountBalance += amount;

                    System.out.println("\nTransaction Completed");
                } else {
                    System.out.println("\nTransaction Declined");
                }

            } else if (fromAccount.equalsIgnoreCase("Savings")) {
                System.out.println("Would you like to transfer $" + amount + "from your [Savings Account] to your [Primary Account]?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println(" ");
                System.out.print("\nAnswer Box: ");

                int ConfirmationChoice = scanner.nextInt(); // DEDUCTS PRIMARY ACCOUNT BALANCE AND ADDS UP SAVINGS ACCOUNT BASED ON AMOUNT
                if (ConfirmationChoice == 1) {
                    SavingsAccountBalance -= amount;
                    PrimaryAccountBalance += amount;

                    System.out.println("\nTransaction Completed");
                } else {
                    System.out.println("\nTransaction Declined");
                }
            }
        } else {
            System.out.println("Transaction Declined");
        }
    }

    public void DisplayInfoCustomerBankAccount() { // Displays the Info of the customer and if they have opened a primary account or savings account
        System.out.println("Customer Name: " + CustomerName);
        System.out.println("Customer ID: " + CustomerID);
        System.out.println("Primary Account: " + hasPrimaryAccount);
        System.out.println("Savings Accounts: " + hasSavingsAccount);
    }
}