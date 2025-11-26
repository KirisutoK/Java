class BankAccount {
    // PRIVATE attributes - can't be accessed directly from outside
    private String accountHolder;
    private double balance;
    private String accountNumber;
    
    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        // Use setter to validate initial balance
        setBalance(initialBalance);
    }
    
    // GETTER methods - allow READ access to private data
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // SETTER method with VALIDATION - controls HOW data can be changed
    private void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Error: Balance cannot be negative!");
            this.balance = 0;
        }
    }
    
    // Public methods to safely modify balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New balance: $" + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            System.out.println("New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds!");
        } else {
            System.out.println("Error: Withdrawal amount must be positive!");
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("====================");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("====================");
    }
}