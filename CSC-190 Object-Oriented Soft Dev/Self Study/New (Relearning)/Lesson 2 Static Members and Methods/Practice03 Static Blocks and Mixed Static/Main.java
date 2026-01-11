public class Main {
    public static void main(String[] args) {
        // CREATING BANK ACCOUNTS
        BankAccount ChristAccount = new BankAccount("TEST123", "Christ", 627.57);
        BankAccount ShanAccount = new BankAccount("TEST321", "Shan", 127.30);
        BankAccount CarlAccount = new BankAccount("TEST676", "Carl", 212.89);
        System.out.println(" "); // Space for Readability

        // DISPLAY ACCOUNTS INFORMATION
        ChristAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability
        ShanAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability
        CarlAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability

        // DISPLAY BANK COUNTS
        System.out.println("Bank Name: " + BankAccount.getBankName());
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total Balance: " + BankAccount.getTotalBalance());
        System.out.println("Interest Rate: " + BankAccount.getInterestRate() * 100 + "%");
        System.out.println(" "); // Space for Readability

        // WITHDRAWS AND DEPOSIT
        ChristAccount.deposit(270.12);
        ShanAccount.withdraw(20.69);
        CarlAccount.deposit(10.12);
        ShanAccount.withdraw(1000.0);
        System.out.println(" "); // Space for Readability

        // CHANGING INTEREST RATE
        BankAccount.setInterestRate(0.05);

        // DISPLAY ACCOUNTS INFORMATION
        ChristAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability
        ShanAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability
        CarlAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability

        // APPLYING INTEREST RATE
        ChristAccount.applyInterest();
        ShanAccount.applyInterest();
        CarlAccount.applyInterest();
        System.out.println(" "); // Space for Readability

        // DISPLAY ACCOUNTS INFORMATION
        ChristAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability
        ShanAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability
        CarlAccount.DisplayBankAccountInformation();
        System.out.println(" "); // Space for Readability

        // DISPLAY BANK COUNTS
        System.out.println("Bank Name: " + BankAccount.getBankName());
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
        System.out.println("Total Balance: " + BankAccount.getTotalBalance());
        System.out.println("Interest Rate: " + BankAccount.getInterestRate() * 100 + "%");
        System.out.println(" "); // Space for Readability


    }
}
