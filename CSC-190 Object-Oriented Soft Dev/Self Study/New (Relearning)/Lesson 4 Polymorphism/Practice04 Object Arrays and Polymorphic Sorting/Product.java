public class Product {
    //=======VARIABLES=======//
    protected String Name;
    protected double Price;
    protected int StockQuantity;
    protected String ProductID;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Product(String Name, double Price, int StockQuantity, String ProductID) {
        this.Name = Name;
        this.Price = Price;
        this.StockQuantity = StockQuantity;
        this.ProductID = ProductID;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public double getPrice() {
        return Price;
    }
    public int getStockQuantity() {
        return StockQuantity;
    }
    public String getProductID() {
        return ProductID;
    }

    public double calculateValue() {
        return Price * StockQuantity;
    }
    public boolean isInStock() {
        return StockQuantity > 0;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayInfo() {
        System.out.println("Name: "+Name);
        System.out.println("Price: "+Price);
        System.out.println("Stock Quantity: "+StockQuantity);
        System.out.println("Product ID: "+ProductID);
    }
}
