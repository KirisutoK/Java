public class Electronics extends Product {
    //=======VARIABLES=======//
    private int WarrantyMonths;
    private String Brand;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Electronics(String Name, double Price, int StockQuantity, String ProductID, int WarrantyMonths, String Brand) {
        super(Name, Price, StockQuantity, ProductID);
        this.WarrantyMonths = WarrantyMonths;
        this.Brand = Brand;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES


    // @OVERRIDE
    @Override
    public double calculateValue() {
        return (Price * StockQuantity) * 1.1;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void extendWarranty(int Months) {
        WarrantyMonths += Months;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Warranty Months: " + WarrantyMonths);
        System.out.println("Brand: " + Brand);
    }
}
