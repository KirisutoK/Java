import java.util.ArrayList;

public class InventoryManager {
    //=======VARIABLES=======//
    private ArrayList<Product> Inventory = new ArrayList<>();

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public InventoryManager() { // I DON'T THINK WE NEED A CONSTNRUCTOR BECAUSE WE ONLY HAVE AN ARRAYLIST

    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getTotalInventoryValue() {
        double TotalValue = 0;
        for (Product i : Inventory) {
            TotalValue += i.calculateValue();
        }
        return TotalValue;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addProduct(Product product) {
        Inventory.add(product); 
    }
    public void removeProduct(Product product) {
        Inventory.remove(product);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
