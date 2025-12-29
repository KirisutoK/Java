public class Customers {
    //=======VARIABLES=======//
    private String CustomerName = "";
    private int CustomerID = 0;
    private BankAccounts PrimaryAccount; // has default values but not changeable values
    private BankAccounts SavingsAccount; // has default values but not changeable values

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Customers(String customername, int customerid) {
        this.CustomerName = customername;
        this.CustomerID = customerid;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getCustomerName() {
        return CustomerName;
    }
    public int getCustomerID() {
        return CustomerID;
    }
    public BankAccounts getPrimaryAccount() {
        return PrimaryAccount;
    }
    public BankAccounts getSavingsAccount() {
        return SavingsAccount;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void openAccount(BankAccounts account, String accounttype) {
        if (accounttype.equalsIgnoreCase("Primary")) {
            PrimaryAccount = account;
            System.out.println("you have successfully opened a primary banking account");
        } else if (accounttype.equalsIgnoreCase("Savings")) {
            SavingsAccount = account;
            System.out.println("you have successfully opened a savings banking account");
        }
    }

    public void transferMoneyBetweenOwnAccounts(double amount, String fromAccount, String toAccount) {

    }
}