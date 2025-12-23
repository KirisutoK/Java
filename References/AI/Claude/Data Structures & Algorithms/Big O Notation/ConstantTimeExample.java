public class ConstantTimeExample {
    
    // Example 1: Get the first element from an array
    public static String getFirstStudent(String[] students) {
        return students[0];  // Just return the first position
    }
    
    // Example 2: Get the last element from an array
    public static String getLastStudent(String[] students) {
        return students[students.length - 1];  // Last position is length - 1
    }
    
    // Example 3: Get element at any position
    public static String getStudentAt(String[] students, int index) {
        return students[index];  // Return element at given position
    }
    
    public static void main(String[] args) {
        System.out.println("=== CONSTANT TIME O(1) DEMONSTRATION ===\n");
        
        // Create arrays of different sizes
        String[] smallClass = {"Alice", "Bob", "Charlie"};
        
        String[] mediumClass = new String[1000];
        mediumClass[0] = "First Student";
        mediumClass[999] = "Last Student";
        mediumClass[500] = "Middle Student";
        
        String[] hugeClass = new String[1000000];
        hugeClass[0] = "First Student";
        hugeClass[999999] = "Last Student";
        hugeClass[500000] = "Middle Student";
        
        // TEST 1: Small array (3 students)
        System.out.println("--- Testing SMALL array (3 students) ---");
        
        long startTime = System.nanoTime();
        String result1 = getFirstStudent(smallClass);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        
        System.out.println("Result: " + result1);
        System.out.println("Time taken: " + duration + " nanoseconds");
        System.out.println();
        
        // TEST 2: Medium array (1,000 students)
        System.out.println("--- Testing MEDIUM array (1,000 students) ---");
        
        startTime = System.nanoTime();
        String result2 = getFirstStudent(mediumClass);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println("Result: " + result2);
        System.out.println("Time taken: " + duration + " nanoseconds");
        System.out.println();
        
        // TEST 3: Huge array (1,000,000 students)
        System.out.println("--- Testing HUGE array (1,000,000 students) ---");
        
        startTime = System.nanoTime();
        String result3 = getFirstStudent(hugeClass);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        
        System.out.println("Result: " + result3);
        System.out.println("Time taken: " + duration + " nanoseconds");
        System.out.println();
        
        // TEST 4: Compare getting first vs last vs middle from HUGE array
        System.out.println("--- Comparing positions in HUGE array ---");
        
        // Get first
        startTime = System.nanoTime();
        getStudentAt(hugeClass, 0);
        endTime = System.nanoTime();
        System.out.println("Getting FIRST element: " + (endTime - startTime) + " nanoseconds");
        
        // Get middle
        startTime = System.nanoTime();
        getStudentAt(hugeClass, 500000);
        endTime = System.nanoTime();
        System.out.println("Getting MIDDLE element: " + (endTime - startTime) + " nanoseconds");
        
        // Get last
        startTime = System.nanoTime();
        getStudentAt(hugeClass, 999999);
        endTime = System.nanoTime();
        System.out.println("Getting LAST element: " + (endTime - startTime) + " nanoseconds");
        
        System.out.println("\n=== CONCLUSION ===");
        System.out.println("Notice: All times are roughly the SAME!");
        System.out.println("Array size doesn't matter - that's O(1) Constant Time!");
    }
}