public class Food extends Product {
    //=======VARIABLES=======//
    private int ExpirationDate; // from String to int (CHANGED)
    private boolean isOrganic;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Food(String Name, double Price, int StockQuantity, String ProductID, int ExpirationDate, boolean isOrganic) {
        super(Name, Price, StockQuantity, ProductID);
        this.ExpirationDate = ExpirationDate;
        this.isOrganic = isOrganic;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public boolean isExpired(int currentdate) {
        return currentdate > ExpirationDate;
    }

    // @OVERRIDE
    @Override
    public double calculateValue() {
        if (isOrganic) { // if isOrganic is true
            return (Price * StockQuantity) * 1.2;
        }
        return Price * StockQuantity;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // @OVERRIDE
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Expiration Date: " + ExpirationDate);
        System.out.println("Is Organic: " + isOrganic);
    }
}
