public class Practice01 {
    public static void main(String[] args) {
        int[] RandomNumbers = {3, 2, 6, 1, 2};


    }

    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {            // OUTER LOOP (Starting: 0, Comparing: n-1)
            int minIndex = 0;                                   // Temporary variable to store the index of the smallest value
            for (int j = i+1; j < array.length; j++) {          // INNER LOOP (Starting: i+1, Comparing: n)
                if (array[j] < array[minIndex]) {               // If less than the value of minIndex
                    minIndex = j;                               // Updates the minimum index
                }
            }

            // SWAP FUNCTION --->>  YOU LEFT HERE!!
        }
        return array;
    }
}
