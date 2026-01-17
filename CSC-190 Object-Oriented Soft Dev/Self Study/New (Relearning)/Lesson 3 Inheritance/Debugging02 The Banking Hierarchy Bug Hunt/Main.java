public class Main {
    public static void main(String[] args) {
        BankAccount basic = new BankAccount("John", "ACC001", 1000.0);
        SavingsAccount savings = new SavingsAccount("Sarah", "SAV001", 2000.0, 0.05);
        CheckingAccount checking = new CheckingAccount("Mike", "CHK001", 1500.0, 500.0);

        System.out.println("Initial balances:");
        basic.displayAccount();
        savings.displayAccount();
        checking.displayAccount();

        System.out.println("\n--- Transactions ---");
        basic.deposit(500.0);
        savings.deposit(1000.0);
        checking.withdraw(200.0);

        System.out.println("\n--- Apply Interest ---");
        savings.applyInterest();

        System.out.println("\n--- Overdraft Test ---");
        checking.withdraw(2000.0);

        System.out.println("\nFinal balances:");
        basic.displayAccount();
        savings.displayAccount();
        checking.displayAccount();

        System.out.println("\nTotal accounts: " + BankAccount.getTotalAccounts());
    }
}
