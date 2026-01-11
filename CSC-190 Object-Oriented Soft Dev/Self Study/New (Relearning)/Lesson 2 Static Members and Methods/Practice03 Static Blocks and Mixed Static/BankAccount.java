public class BankAccount {
    //=======VARIABLES=======//
    // Static Variables
    private static String BankName;
    private static double InterestRate;
    private static int TotalAccounts;
    private static double TotalBalance;
    // STATIC BLOCKS --->> Gives value to variables when the class is created  or loaded(object is created)
    static {
        BankName = "Global Bank";
        System.out.println("Bank System initialized");
        InterestRate = 0.03; // 3%
        TotalAccounts = 0;
        TotalBalance = 0.0;
    }

    // Instance Variables
    private String AccountNumber;
    private String AccountHolder;
    private Double Balance;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public BankAccount(String AccountNumber, String AccountHolder, Double Balance) {
        this.AccountNumber = AccountNumber;
        this.AccountHolder = AccountHolder;
        this.Balance = Balance;

        TotalAccounts++;
        TotalBalance += Balance;

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

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public static void setInterestRate(double rate) { // Changes Interest Rate for all instances
        InterestRate = rate;
    }
    public void deposit(double amount) { // Deposit money
        Balance += amount;
        TotalBalance += amount;
        System.out.println("Successfully deposited $" + amount + " from " + BankName);
    }
    public void withdraw(double amount) { // Withdraw money
        if ((Balance -= amount) < 0) {
            System.out.println("Insufficient amount");
        } else {
            Balance -= amount;
            TotalBalance -= amount;
            System.out.println("Succesfully withrdawn $" + amount + " from " + BankName);
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayBankAccountInformation() {
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Holder: " + AccountHolder);
    }
}
