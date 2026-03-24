import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS or INSTANCES
        Electronics Electronics01 = new Electronics("Iphone 16", 1609.99, 3, "E001", 24, "Apple");
        Electronics Electronics02 = new Electronics("Samsung Galaxy", 502.67, 23, "E002", 999, "Android");
        Electronics Electronics03 = new Electronics("Nokia", 5230.75, 1, "E003", 0, "Unbreakable");
        Clothing Clothing01 = new Clothing("Calvin Klein Shirt", 10.50, 25, "C001", "Medium", "Cloth");
        Clothing Clothing02 = new Clothing("Calvin Klein Jeans", 25.67, 12, "C002", "32", "Cloth");
        Clothing Clothing03 = new Clothing("Calvin Klein Hoodies", 56.29, 5, "C003", "Medium", "Cloth");
        Food Food01 = new Food("Pizza", 9.99, 15, "F001", 29, false);
        Food Food02 = new Food("Burger", 12.99, 10, "F002", 15, true);
        Food Food03 = new Food("Noodles", 15.00, 12, "F003", 23, true);
        InventoryManager InvManager01 = new InventoryManager(10); // Array

        // ADDING OBJECTS TO INVENTORY MANAGER
        InvManager01.addProduct(Electronics01);
        InvManager01.addProduct(Electronics02);
        InvManager01.addProduct(Electronics03);
        InvManager01.addProduct(Clothing01);
        InvManager01.addProduct(Clothing02);
        InvManager01.addProduct(Clothing03);
        InvManager01.addProduct(Food01);
        InvManager01.addProduct(Food02);
        InvManager01.addProduct(Food03);
        System.out.println(" "); // Space for Readability

        // DISPLAYING OBJECTS
        InvManager01.DisplayInventory();
        System.out.println("Total Inventory Value: " + InvManager01.getTotalInventoryValue());

        // SORT BY PRICE METHOD
        InvManager01.sortByPrice();

        // DISPLAYING OBJECTS
        System.out.println("=== SORTED BY PRICE ===");
        InvManager01.DisplayInventory();

        // SORT BY VALUE METHOD ---------------->>>> YOU LEFT HERE (FORGOT TO MAKE THE METHOD) [INVENTORY MANAGER]
        System.out.println("=== SORTED BY VALUE ===");
        InvManager01.sortByValue();

        // DISPLAYING OBJECTS
        InvManager01.DisplayInventory();

        // MOST VALUABLE
        System.out.println("=== MOST VALUABLE PRODUCT ===");
        InvManager01.findMostValuableProduct().DisplayInfo();
        System.out.println(" "); // Space for Readability

        // FILTER BY TYPE
        System.out.println("=== FILTER BY TYPE ===");
        ArrayList<Product> ElectronicsList = InvManager01.filterbyType("Electronics");
        for (Product i : ElectronicsList) {
            i.DisplayInfo();
            System.out.println(" "); // Space for readability
        }

        //  FILTER BY LOW STOCK
        System.out.println("=== LOW STOCK PRODUCTS(LESS THAN 10) ===");
        for (Product i : InvManager01.getInventory()) {
            if (i.getStockQuantity() <= 10) {
                i.DisplayInfo();
                System.out.println(" "); // Space for Readability
            }
        }

        // REMOVE PRODUCT BY ID
        System.out.println("=== REMOVE PRODUCT BY ID ===");
        InvManager01.removeProductByID("F003");

        // RESTOCKING A CLOTHING
        System.out.println("=== RESTOCKING A CLOTHING && EXTENDING ELECTRONICS WARRANTY ===");
        int x = 1;
        for (Product i : InvManager01.getInventory()) {
            if (i instanceof Clothing) {
                ((Clothing) i).restock(10);
                System.out.println(i.getName() + "has been restocked.");
                System.out.println(" "); // Space for Readability
            }
            if (i instanceof Electronics) {
                ((Electronics) i).extendWarranty(12 * x);
                x++;
            }
        }

        // DISPLAYING OBJECTS
        InvManager01.DisplayInventory();
        System.out.println("Total Inventory Value: " + InvManager01.getTotalInventoryValue());
    }
}
