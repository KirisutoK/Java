public class Main {
    public static void main(String[]args) {
        Customers customer1 = new Customers("John", 123);
        Customers customer2 = new Customers("Miya", 321);

        BankAccounts Primary1 = new BankAccounts(customer1.getCustomerName(), String.valueOf(customer1.getCustomerID()));
        BankAccounts Primary2 = new BankAccounts();
        BankAccounts Savings1 = new BankAccounts();
        BankAccounts Savings2 = new BankAccounts();

        customer1.openAccount(Primary1,"Primary");
    }
}