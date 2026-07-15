// Creation Date: June 30, 2026. at 1:38 AM
// Last Modified: June 30, 2026. at  1:49 AM

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> Inventory = new ArrayList<>();

        Inventory.add("Apple");
        Inventory.add("Banana");
        Inventory.add("Apple");
        Inventory.add("Milk");
        Inventory.add("Banana");
        Inventory.add("Bread");

        System.out.println(getUniqueItems(Inventory));

    }

    public static HashSet<String> getUniqueItems(ArrayList<String> arr) {
        HashSet<String> UniqueItems = new HashSet<>(arr); //... This automatically puts all the value when initializing the array (This was recommended by IntelliJ IDEA)
        // UniqueItems.addAll(arr); //... addAll() parameters only receive collections array (This was recommended by IntelliJ IDEA)

        return UniqueItems;
    }
}

// Problem 2 — Easy (Real-World)
// A grocery store wants to remove duplicate item names from their inventory list (they accidentally scanned some items twice).
// Given an ArrayList<String> of item names, return a HashSet<String> containing only the unique items.
//
// Input:  ["Apple", "Banana", "Apple", "Milk", "Banana", "Bread"]
//Output: [Apple, Banana, Milk, Bread]  (order may vary since HashSet is unordered)
//
//Input:  ["Eggs", "Eggs", "Eggs"]
//Output: [Eggs]

