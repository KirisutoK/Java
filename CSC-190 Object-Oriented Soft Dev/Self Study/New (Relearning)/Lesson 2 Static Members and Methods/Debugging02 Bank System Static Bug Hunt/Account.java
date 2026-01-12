public class Account {
    private static String bankName;
    private static double minimumBalance;
    private static int totalAccounts;
    private static double totalDeposits;

    static {
        bankName = "First National Bank";
        minimumBalance = 50.0;
        totalAccounts = 0;
        totalDeposits = 0.0;
    }

    private String accountHolder;
    private double balance;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalAccounts++;
        totalDeposits += initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        totalDeposits += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount > minimumBalance) { // 1400 > 100 CORRECT
            if (balance > amount) { // 1300 < 1400
                balance -= amount;
                totalDeposits -= amount;
                System.out.println("Succesfully withdrawn $" + amount + " from " + accountHolder);
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Cannot withdraw: would go below minimum balance");
        }
    }

    public void displayBalance() {
        System.out.println(accountHolder + "'s balance: $" + balance);
    }

    public static String getBankName() {
        return bankName;
    }

    public static double getMinimumBalance() {
        return minimumBalance;
    }

    public static void setMinimumBalance(double amount) {
        minimumBalance = amount;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getTotalDeposits() {
        return totalDeposits;
    }
}
