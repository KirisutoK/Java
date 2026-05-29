package Customers;

// Creation Date: May 29, 2026. at 3:21 AM
// Last Modified: May 29, 2026. at  3:31 AM

class CustomerDatabase {
    //=======VARIABLES=======//
    private Customer[] Customers = new Customer[20];
    private int CustomerCount = 0;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public boolean isFull() {
        return CustomerCount > Customers.length;
    }
    Customer findCustomer(String customerID) {
        for (int i = 0; i < CustomerCount; i++) {
            if (Customers[i].getCustomerID().equals(customerID)) {
                return Customers[i];
            }
        }

        return null;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void addCustomer(Customer customer) {
        //? CHECK IF IT'S FULL
        if (isFull()) { // if it is full
            System.out.println("Customers is full: ["+CustomerCount+"/20]");
            return; // stops the whole method here
        }

        //? ADDING CUSTOMER INTO THE DATABASE
        Customers[CustomerCount] = customer;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
