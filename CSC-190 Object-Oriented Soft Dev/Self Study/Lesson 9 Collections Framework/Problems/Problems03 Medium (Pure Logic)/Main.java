// Creation Date: June 30, 2026. at 1:52 AM
// Last Modified: June 30, 2026. at  2:08 AM

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> Store = new HashMap<>();

        Store.put("Apple", 3);
        Store.put("Banana", 7);
        Store.put("Cherry", 2);

        System.out.println(getHighestValue(Store));

    }

    public static String getHighestValue(HashMap<String, Integer> arr) {
        if (arr.isEmpty()) {
            return null;
        }

        String HighestValue = "";
        // int HighestPrice = 0; // My Initial Code
        int HighestPrice = Integer.MIN_VALUE; // This is the safest way to make sure that it is actually below to all the values (even negative)
        for (String i: arr.keySet()) {
            if (arr.get(i) > HighestPrice) {
                HighestPrice = arr.get(i);
                HighestValue = i;
            }
        }

        return HighestValue;
    }
}

// Problem 3 — Medium (Pure Logic)
// Given a HashMap<String, Integer> representing word counts, return the key (word) that has the highest value (count). If the map is empty, return null.
//
// Input:  {"apple": 3, "banana": 7, "cherry": 2}
// Output: "banana"
//
// Input:  {"dog": 5, "cat": 5, "bird": 2}
// Output: "dog" or "cat"  (either is acceptable since they're tied)
//
// Input:  {}
// Output: null