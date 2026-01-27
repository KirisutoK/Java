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
    public void sortByPrice() {
        // already has an array list
        // LEFT HERE:
        // INITIAL PLAN WAS TO CONVERT THE ARRAYLIST TO AN ARRAY
        // USE THAT ARRAY TO SORT AND THEN PRINT

        // SELECTION SORT
        for (int i = 0; i < Inventory.size(); i++) { // OUTER LOOP
            int MinIndex = i;
            for (int j = i + 1; j < Inventory.size(); j++) { // INNER LOOP
                if (Inventory.get(j).getPrice() < Inventory.get(MinIndex).getPrice()) {
                    MinIndex = j;
                }
            }

            Product temp = Inventory.get(i);
            Inventory.set(i, Inventory.get(MinIndex));
            Inventory.set(MinIndex, temp);
        }

        // DISPLAY
        System.out.println("SORTED BY PRICE: "+Inventory.);
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
