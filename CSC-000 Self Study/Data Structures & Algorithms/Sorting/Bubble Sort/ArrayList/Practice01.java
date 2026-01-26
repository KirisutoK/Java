import java.util.ArrayList;
import java.util.Arrays;

public class Practice01 {
    public static void main(String[] args) {
        ArrayList<Integer> RandomNumbers = new ArrayList<>(); // Arraylist (not a regular array)

        RandomNumbers.add(1);
        RandomNumbers.add(6);
        RandomNumbers.add(1);
        RandomNumbers.add(2);
        RandomNumbers.add(3);
        RandomNumbers.add(5);

        // ======== PROCESS ======== \\

        System.out.println("Original: "+RandomNumbers.toString()); // Prints out the arraylist

        int[] RegularArrayRandomNumbers = ArraylistToArray(RandomNumbers); // Converts the arraylist into a regular array

        // BubbleSort(RandomNumbers); ----->> THIS DOES NOT WORK BECAUSE BUBBLESORT ONLY WORKS WITH REGULAR ARRAYS
        BubbleSort(RegularArrayRandomNumbers);

        System.out.println("Sorted: "+Arrays.toString(RegularArrayRandomNumbers));  // Prints out the sorted array



    }

    public static int[] BubbleSort(int[] array) { // Sorts the array from minimum to maximum
        for (int i = 0; i < array.length - 1; i++) { // n-1
            for (int j = 0; j < array.length - i - 1; j++) { // n-i-1
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] ArraylistToArray(ArrayList<Integer> arrlist) { // Converts the arraylist into a regular array
        int[] result = new int[arrlist.size()];
        for (int i = 0; i < arrlist.size(); i++) {
            result[i] = arrlist.get(i);
        }
        return result;
    }
}
