public class BankAccount {
    //=======VARIABLES=======//
    // Static Variables
    private static String BankName;
    private static double InterestRate;
    private static int TotalAccounts;
    private static double TotalBalance;
    // STATIC BLOCKS --->> Gives value to variables when the class is created  or loaded(object is created)
    static {
        BankName = "HOPE Bank";
        System.out.println("Bank System initialized");
        InterestRate = 0.03; // 3%
        TotalAccounts = 0;
        TotalBalance = 0.0;
    }

    // Instance Variables
    private String AccountNumber;
    private String AccountHolder;
    private Double AccountBalance;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BankAccount(String AccountNumber, String AccountHolder, Double AccountBalance) {
        this.AccountNumber = AccountNumber;
        this.AccountHolder = AccountHolder;
        this.AccountBalance = AccountBalance;

        TotalAccounts++;
        TotalBalance += AccountBalance;

        System.out.println("Account has been successfully created!");
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public static double getInterestRate() {
        return InterestRate;
    }
    public static int getTotalAccounts() {
        return TotalAccounts;
    }
    public static double getTotalBalance() {
        return TotalBalance;
    }
    public static String getBankName() {
        return BankName;
    }
    public double getBalance() {
        return AccountBalance;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public static void setInterestRate(double rate) { // Changes Interest Rate for all instances
        InterestRate = rate;
        System.out.println("Interest rate has been changed to " + rate + " or " + rate * 100 + "%");
    }
    public void deposit(double amount) { // Deposit money
        AccountBalance += amount;
        TotalBalance += amount;
        System.out.println("Successfully deposited $" + amount + " from " + AccountHolder + "'s account.");
    }
    public void withdraw(double amount) { // Withdraw money
        if (AccountBalance >= amount) { // checks if account balance is greater than the amount
            AccountBalance -= amount;
            TotalBalance -= amount;
            System.out.println("Successfully withdrawn $" + amount + " from " + AccountHolder + "'s account.");
        } else {
            System.out.println("Insufficient Amount!");
        }
    }
    public void applyInterest() {
        double InterestGained = AccountBalance * InterestRate;
        AccountBalance += InterestGained;
        TotalBalance += InterestGained;
        System.out.println("Interest Rate has been applied to " + AccountHolder + "'s account.");
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayBankAccountInformation() {
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Number: " + AccountNumber);
        System.out.println("Account Balance: " + AccountBalance);
    }
}
