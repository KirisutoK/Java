public class Clothing extends Product {
    //=======VARIABLES=======//
    private String Size;
    private String Material;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Clothing(String Name, double Price, int StockQuantity, String ProductID, String Size, String Material) {
        super(Name, Price, StockQuantity, ProductID);
        this.Size = Size;
        this.Material = Material;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void restock(int quantity) {
        StockQuantity += quantity;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Size: " + Size );
        System.out.println("Material: " + Material);
    }
}
