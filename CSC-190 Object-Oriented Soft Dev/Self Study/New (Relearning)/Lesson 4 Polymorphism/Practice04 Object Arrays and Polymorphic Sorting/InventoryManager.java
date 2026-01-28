import java.util.ArrayList;

public class InventoryManager {
    //=======VARIABLES=======//
    private ArrayList<Product> Inventory = new ArrayList<>();
    private int Capacity;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILE WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public InventoryManager(int Capacity) {
        this.Capacity = Capacity;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getTotalInventoryValue() {
        double TotalValue = 0;
        for (Product i : Inventory) {
            TotalValue += i.calculateValue();
        }
        return TotalValue;
    }
    public Product findMostValuableProduct() {
        Product MostValuabe = Inventory.get(0); // First Product in the Arraylist

        for (Product i : Inventory) {
            if (i.calculateValue() > MostValuabe.calculateValue()) { // Checks all the stuff in the inventory which one has the highest calculateValue
                MostValuabe = i;
            }
        }

        return MostValuabe;
    }
    public ArrayList<Product> filterbyType(String type) {
        ArrayList<Product> TempFilteredInventory = new ArrayList<>();

        for (Product i : Inventory) {
            if (i.getClass().getSimpleName().equalsIgnoreCase(type)) { // if the name of the class is equal(ignoreCases) to type(string)
                TempFilteredInventory.add(i);
            }
        }

        return TempFilteredInventory;
    }
    public ArrayList<Product> getLowStockProducts(int threshold) {
        ArrayList<Product> Result = new ArrayList<>();

        for (Product i : Inventory) {
            if (i.getStockQuantity() <= threshold) {
                Result.add(i);
            }
        }

        return Result;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addProduct(Product product) {
        if (Inventory.size() >= Capacity) {
            System.out.println("Inventory is full!");
        } else {
            Inventory.add(product);
            System.out.println(product.Name+" added successfully!");
        }
    }
    public void removeProduct(Product product) {
        Inventory.remove(product);
    }
    public void sortByPrice() {
        // ARRAYLIST INTO ARRAY
        Product[] TempArrayInventory = new Product[Inventory.size()];

        for (int i = 0; i < Inventory.size(); i++) {
            TempArrayInventory[i] = Inventory.get(i);
        }

        // SELECTION SORT
        for (int i = 0; i < TempArrayInventory.length-1; i++) {                                  // OUTER LOOP
            for (int j = i+1; j < TempArrayInventory.length; j++) {                              // INNER LOOP
                if (TempArrayInventory[i].getPrice() > TempArrayInventory[j].getPrice()) {       // SWAPPING PART
                    Product temp = TempArrayInventory[i];
                    TempArrayInventory[i] = TempArrayInventory[j];
                    TempArrayInventory[j] = temp;
                }
            }
        }

        // APPLY THE SORTING INTO THE ARRAYLIST
        Inventory.clear();
        for (Product i : TempArrayInventory) {
            Inventory.add(i);
        }

    }
    public void soryByValue() {
        // ARRAYLIST INTO ARRAY
        Product[] result = new Product[Inventory.size()];


    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayInventory() {
        System.out.println("===INVENTORY===");
        for (Product i : Inventory) {
            i.DisplayInfo();
            System.out.println(" "); // Space for Readability
        }
    }
}
