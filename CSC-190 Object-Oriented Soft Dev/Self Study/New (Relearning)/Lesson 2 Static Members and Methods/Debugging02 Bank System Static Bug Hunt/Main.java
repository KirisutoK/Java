public class Main {
    public static void main(String[] args) {
        System.out.println("Bank: " + Account.getBankName()); // Correct
        System.out.println("Minimum balance: $" + Account.getMinimumBalance());

        Account acc1 = new Account("John", 1000.0);
        Account acc2 = new Account("Sarah", 1500.0);
        Account acc3 = new Account("Mike", 2000.0);

        System.out.println("Total accounts: " + Account.getTotalAccounts());
        System.out.println("Total deposits: $" + Account.getTotalDeposits());

        acc1.deposit(500.0);
        acc2.withdraw(200.0);
        acc3.deposit(1000.0);

        // CALCULATION NOTES
        // 4500.0 + 500.0 + 1000.0 = 6000.0 - 200.0 = 5800 CORRECT
        //

        System.out.println("\nAfter transactions:");
        System.out.println("Total deposits: $" + Account.getTotalDeposits()); // SHOULD BE $5800.0

        acc1.displayBalance(); // Correct
        acc2.displayBalance(); // Correct
        acc3.displayBalance(); // Correct
        System.out.println(" "); // Space for Readability

        Account.setMinimumBalance(100.0);

        acc2.withdraw(1400.0);
        acc2.displayBalance();
    }
}