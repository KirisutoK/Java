public class Main {
    public static void main(String[]args) {
        Customers customer1 = new Customers("John", 123);
        Customers customer2 = new Customers("Miya", 321);

        BankAccounts Primary1 = new BankAccounts(customer1.getCustomerName(), String.valueOf(customer1.getCustomerID())); // Second Parameter must be string but the original value that we need to show is int so we have to concatenate the value to string
        BankAccounts Primary2 = new BankAccounts(customer2.getCustomerName(), String.valueOf(customer2.getCustomerID())); // Second Parameter must be string but the original value that we need to show is int so we have to concatenate the value to string
        BankAccounts Savings1 = new BankAccounts(customer1.getCustomerName(), String.valueOf(customer1.getCustomerID())); // Second Parameter must be string but the original value that we need to show is int so we have to concatenate the value to string
        BankAccounts Savings2 = new BankAccounts(customer2.getCustomerName(), String.valueOf(customer2.getCustomerID())); // Second Parameter must be string but the original value that we need to show is int so we have to concatenate the value to string

        customer1.openAccount(Primary1,"Primary");
        customer1.openAccount(Savings1, "Savings");
        customer2.openAccount(Primary2, "Primary");
        customer2.openAccount(Savings2, "Savings");

        customer1.DisplayInfoCustomerBankAccount(); // Checks Customer1's Primary Bank Information
        System.out.println(" "); // Space for readability
        customer2.DisplayInfoCustomerBankAccount(); // Checks Customer2's Primary Bank Information
        System.out.println(" "); // Space for readability

        customer1.getPrimaryAccount().deposit(3000.0); // DEPOSIT $3000.00 TO BANK
        System.out.println(" "); // Space for readability

        customer1.transferMoneyBetweenOwnAccounts(1000.00, "Primary", "Savings"); // Amount, from, to

        customer1.getPrimaryAccount().DisplayBankAccountInfo(); // Checks Customer1's Primary Bank Information
        System.out.println(" "); // Space for readability
        customer1.getSavingsAccount().DisplayBankAccountInfo();
        System.out.println(" "); // Space for readability

        customer1.getPrimaryAccount().transfer(customer2.getPrimaryAccount(), 500.0); // TRANSFERS 500.0 TO MIYA'S BANK ACCOUNT BALANCE

        customer1.getPrimaryAccount().DisplayBankAccountInfo(); // Checks Customer1's Primary Bank Information
        System.out.println(" "); // Space for readability
        customer2.getPrimaryAccount().DisplayBankAccountInfo(); // Checks Customer2's Primary Bank Information
        System.out.println(" "); // Space for readability

        customer2.getPrimaryAccount().withdraw(1000.0); // WITHDRAWS 1000.0 FROM BANK ACCOUNT
        System.out.println(" "); // Space for readability

        customer1.getPrimaryAccount().DisplayBankAccountInfo(); // Checks Customer1's Primary Bank Information
        System.out.println(" "); // Space for readability
        customer1.getSavingsAccount().DisplayBankAccountInfo(); // Checks Customer1's Savings Bank Information
        System.out.println(" "); // Space for readability
        customer2.getPrimaryAccount().DisplayBankAccountInfo(); // Checks Customer2's Primary Bank Information
        System.out.println(" "); // Space for readability
        customer2.getSavingsAccount().DisplayBankAccountInfo(); // Checks Customer2's Savings Bank Information
        System.out.println(" "); // Space for readability
    }
}