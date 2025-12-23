/*
    NOTES

1. CONSTANT TIME
    o(1) → Looking up a word you already know (always instant)
2. LINEAR TIME
    o(n) → Reading a book page by page (doubles if book doubles)
3. QUADRATIC TIME
    o(n²) → Comparing every student with every other student in class

*/


public class SSGeneralBigONotation {

    // This is O(1) - always takes the same time
    public static int getFirstElement(int[] array) {
        return array[0];  // One operation, regardless of array size
    }

    public static void main(String[] args) {
        int[] small = {1, 2, 3};
        int[] huge = new int[1000000];
        huge[0] = 42;
        
        // Both take the same time!
        System.out.println(getFirstElement(small));  // Instant
        System.out.println(getFirstElement(huge));   // Also instant
    }
}
