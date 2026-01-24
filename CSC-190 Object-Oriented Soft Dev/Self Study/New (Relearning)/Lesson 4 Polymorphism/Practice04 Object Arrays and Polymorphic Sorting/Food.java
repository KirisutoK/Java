public class Food extends Product {
    //=======VARIABLES=======//
    private String ExpirationDate;
    private boolean isOrganic;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Food(String Name, double Price, int StockQuantity, String ProductID, String ExpirationDate, boolean isOrganic) {
        super(Name, Price, StockQuantity, ProductID);
        this.ExpirationDate = ExpirationDate;
        this.isOrganic = isOrganic;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public boolean isExpired(String currentdate) {
        return Integer.parseInt(ExpirationDate) < ; // THIS IS WHERE YOU LEFT, YOU HAD QUESTIONS WHY THE VARIABLES ARE STRING INSTEAD OF INT (TAKE A  LOOK AT CompareTo())
    }

    // @OVERRIDE
    @Override
    public double calculateValue() {
        return (Price * StockQuantity) * 1.1;
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
