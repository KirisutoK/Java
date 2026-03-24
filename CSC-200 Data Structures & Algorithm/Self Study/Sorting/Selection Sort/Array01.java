import java.util.Arrays;

public class Array01 {
    public static void main(String[] args) {
        int[] RandomNumbers = {3, 2, 6, 1, 2};

        System.out.println("Original: "+ Arrays.toString(RandomNumbers));

        selectionSort(RandomNumbers);

        System.out.println("Sorted: "+ Arrays.toString(RandomNumbers));


    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {            // OUTER LOOP (Starting: 0, Comparing: n-1)
            int minIndex = i;                                   // Temporary variable to store the index of the current selected value
            for (int j = i+1; j < array.length; j++) {          // INNER LOOP (Starting: i+1, Comparing: n)
                if (array[j] < array[minIndex]) {               // If less than the value of minIndex
                    minIndex = j;                               // Updates the minimum index
                }
            }
            int minValue = array[minIndex];                 // Stores the value of the minimum index
            array[minIndex] = array[i];                     // Changes the minimum index into the current index (outer loop)
            array[i] = minValue;                            // Changes the current index (outer loop) into minimum value
        }
        return array;
    }
}
