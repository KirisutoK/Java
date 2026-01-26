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

        System.out.println("Original: "+RandomNumbers.toString()); // Prints out the arraylist

        // BubbleSort(RandomNumbers); ----->> THIS DOES NOT WORK BECAUSE BUBBLESORT ONLY WORKS WITH REGULAR ARRAYS


    }

    public static int[] BubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        return array;
    }
}
