public class Main {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount("John Doe", "ACC001", 1000);
        
        account.displayAccountInfo();
        
        // Try to access balance directly (THIS WOULD NOT WORK!)
        // account.balance = -500;  // ERROR! balance is private
        
        // Instead, use public methods (encapsulation in action!)
        account.deposit(500);
        System.out.println();
        
        account.withdraw(200);
        System.out.println();
        
        // Try invalid operations (encapsulation protects us!)
        account.withdraw(2000);  // Too much!
        System.out.println();
        
        account.deposit(-100);   // Negative amount!
        System.out.println();
        
        // Use getter to READ balance safely
        System.out.println("Current balance: $" + account.getBalance());
    }
}