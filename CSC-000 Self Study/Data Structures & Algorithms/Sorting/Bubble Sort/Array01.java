import java.util.Arrays; // This is a regular array with multiple convenient methods. this can be such as toString()

public class Array01 {
    public static void main(String[] args) {
        int[] RandomNumbers = {1, 3, 8, 21, 3}; // Array

        System.out.println("Original:" + Arrays.toString(RandomNumbers));
        BubbleSort(RandomNumbers);
        System.out.println("Sorted:" + Arrays.toString(RandomNumbers)); // Prints out the sorted array
    }


    public static int[] BubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) { // OUTER LOOPS
            for (int j = 0; j < array.length-i-1; j++) { // INNER LOOPS
                if (array[j] > array[j+1]) { // if Left > Right then
                    int temp = array[j]; // stores the left value into a temporary variable
                    array[j] = array[j+1]; // the left value will become the right value
                    array[j+1] = temp; // the right value will become the temporary variable value
                }
            }
        }

        return array;
    }
}
