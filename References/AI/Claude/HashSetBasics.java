import java.util.HashSet;
import java.util.Iterator;

public class HashSetBasics {
    public static void main(String[] args) {
        
        // ========== WHAT IS A HASHSET? ==========
        
        // HashSet is a collection that stores UNIQUE items (no duplicates)
        // - Items are stored in NO PARTICULAR ORDER
        // - Very FAST for adding, removing, and checking if item exists
        // - Does NOT allow duplicate values
        
        
        // ========== CREATING A HASHSET ==========
        
        // Create an empty HashSet that stores Strings
        HashSet<String> fruits = new HashSet<>();
        
        // Create a HashSet that stores Integers
        HashSet<Integer> numbers = new HashSet<>();
        
        System.out.println("Created empty HashSets");
        System.out.println();
        
        
        // ========== ADDING ITEMS ==========
        
        // Use .add() to put items into the HashSet
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        
        System.out.println("Fruits: " + fruits);
        
        // Try to add a duplicate - it won't be added!
        boolean added = fruits.add("Apple");  // Returns false if already exists
        System.out.println("Was 'Apple' added again? " + added);
        System.out.println("Fruits after duplicate: " + fruits);
        System.out.println();
        
        
        // ========== CHECKING SIZE ==========
        
        // Use .size() to count how many items are in the HashSet
        int count = fruits.size();
        System.out.println("Number of fruits: " + count);
        System.out.println();
        
        
        // ========== CHECKING IF ITEM EXISTS ==========
        
        // Use .contains() to check if an item is in the HashSet
        boolean hasApple = fruits.contains("Apple");
        boolean hasGrape = fruits.contains("Grape");
        
        System.out.println("Has Apple? " + hasApple);
        System.out.println("Has Grape? " + hasGrape);
        System.out.println();
        
        
        // ========== REMOVING ITEMS ==========
        
        // Use .remove() to delete an item from the HashSet
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
        
        // Try to remove something that doesn't exist
        boolean removed = fruits.remove("Grape");  // Returns false if not found
        System.out.println("Was Grape removed? " + removed);
        System.out.println();
        
        
        // ========== CHECKING IF EMPTY ==========
        
        // Use .isEmpty() to check if HashSet has no items
        boolean empty = fruits.isEmpty();
        System.out.println("Is fruits empty? " + empty);
        System.out.println();
        
        
        // ========== LOOPING THROUGH HASHSET ==========
        
        System.out.println("Looping through all fruits:");
        
        // Method 1: Enhanced for loop (easiest way)
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        System.out.println();
        
        // Method 2: Using Iterator
        System.out.println("Using Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("- " + fruit);
        }
        System.out.println();
        
        // Method 3: Using forEach with lambda (modern Java)
        System.out.println("Using forEach:");
        fruits.forEach(fruit -> System.out.println("- " + fruit));
        System.out.println();
        
        
        // ========== CLEARING ALL ITEMS ==========
        
        // Create a new HashSet for demo
        HashSet<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        
        System.out.println("Colors before clear: " + colors);
        
        // Use .clear() to remove ALL items
        colors.clear();
        System.out.println("Colors after clear: " + colors);
        System.out.println("Is colors empty? " + colors.isEmpty());
        System.out.println();
        
        
        // ========== WORKING WITH NUMBERS ==========
        
        HashSet<Integer> scores = new HashSet<>();
        scores.add(100);
        scores.add(85);
        scores.add(92);
        scores.add(100);  // Duplicate - won't be added
        scores.add(78);
        
        System.out.println("Scores: " + scores);
        System.out.println("Number of unique scores: " + scores.size());
        System.out.println();
        
        
        // ========== SET OPERATIONS ==========
        
        // Create two HashSets
        HashSet<String> set1 = new HashSet<>();
        set1.add("A");
        set1.add("B");
        set1.add("C");
        
        HashSet<String> set2 = new HashSet<>();
        set2.add("B");
        set2.add("C");
        set2.add("D");
        
        // UNION: Combine both sets (all unique items)
        HashSet<String> union = new HashSet<>(set1);
        union.addAll(set2);  // Adds all items from set2
        System.out.println("Union (all items): " + union);
        
        // INTERSECTION: Find common items
        HashSet<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);  // Keeps only items in both sets
        System.out.println("Intersection (common items): " + intersection);
        
        // DIFFERENCE: Items in set1 but not in set2
        HashSet<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);  // Removes items that are in set2
        System.out.println("Difference (set1 - set2): " + difference);
        System.out.println();
        
        
        // ========== CONVERTING TO ARRAY ==========
        
        HashSet<String> animals = new HashSet<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Bird");
        
        // Convert HashSet to Array
        String[] animalArray = animals.toArray(new String[0]);
        System.out.println("Array from HashSet:");
        for (String animal : animalArray) {
            System.out.println("- " + animal);
        }
        System.out.println();
        
        
        // ========== PRACTICAL EXAMPLE: REMOVING DUPLICATES ==========
        
        System.out.println("Practical Example - Removing Duplicates:");
        
        // Suppose we have a list with duplicates
        String[] listWithDuplicates = {"Apple", "Banana", "Apple", "Orange", "Banana", "Mango"};
        
        System.out.println("Original list:");
        for (String item : listWithDuplicates) {
            System.out.print(item + " ");
        }
        System.out.println();
        
        // Put into HashSet - automatically removes duplicates!
        HashSet<String> uniqueItems = new HashSet<>();
        for (String item : listWithDuplicates) {
            uniqueItems.add(item);
        }
        
        System.out.println("After removing duplicates: " + uniqueItems);
        System.out.println();
        
        
        // ========== KEY POINTS TO REMEMBER ==========
        
        System.out.println("=== KEY POINTS ===");
        System.out.println("1. HashSet stores UNIQUE items only (no duplicates)");
        System.out.println("2. Items are in NO particular order");
        System.out.println("3. Very FAST for add, remove, and contains operations");
        System.out.println("4. Cannot access items by index (no get(0))");
        System.out.println("5. Perfect for checking if item exists quickly");
        System.out.println("6. Great for removing duplicates from a collection");
    }
}