import java.util.Scanner;

public class BankAccounts {
    static Scanner scanner = new Scanner(System.in);

    //==========VARIABLES==========\\
    private String AccountNumber = "";
    private String AccountHolder = "";
    private Double AccountBalance = 0.0;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BankAccounts(String accountholder, String accountnumber) {
        this.AccountNumber = accountnumber;
        this.AccountHolder = accountholder;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getAccountNumber() {
        return AccountNumber;
    }
    public String getAccountHolder() {
        return AccountHolder;
    }
    public Double getAccountBalance() {
        return AccountBalance;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void deposit(Double amount) {
        System.out.println("Would you like to deposit $" + amount + " to your account?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println(" "); // Space for Readability

        int DepositChoice = scanner.nextInt();
        if (DepositChoice == 1) {
            AccountBalance += amount;
            System.out.println("Transaction Completed");
        } else {
            System.out.println("Transction Declined");
        }
    }
    public void withdraw(Double amount) {
        if (AccountBalance <= amount) { // If AccountBalance is less than the amount needed to withdraw
            System.out.println("Would you like to withdraw $" + amount + " to your account?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println(" "); // Space for Readability

            int WithdawChoice = scanner.nextInt();
            if (WithdawChoice == 1) {
                AccountBalance -= amount;
                System.out.println("Transaction Completed");
            } else {
                System.out.println("Transaction Declined");
            }
        } else {
            System.out.println("Insufficient Account Balance");
            System.out.println(" "); // Space for Readability
            System.out.println("Transaction Declined.");
        }
    }
    public void transfer(BankAccounts targetaccount, Double amount) {
        if (AccountBalance <= amount) { // If AccountBalance is less than the amount needed to withdraw
            System.out.println("Would you like to transfer $" + amount + " to " + targetaccount.getAccountHolder() + "?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.println(" "); // Space for Readability

            int WithdawChoice = scanner.nextInt();
            if (WithdawChoice == 1) {
                AccountBalance -= amount;
                amount += targetaccount.AccountBalance;
                System.out.println("Transaction Completed");
            } else {
                System.out.println("Transaction Declined");
            }
        } else {
            System.out.println("Insufficient Account Balance");
            System.out.println(" "); // Space for Readability
            System.out.println("Transaction Declined.");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayBankAccountInfo() {
        System.out.println("Account Number: " + AccountNumber);
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Balance: $" + AccountBalance);
    }
}
