import java.util.ArrayList;
import java.util.Arrays;

public class Concatenation {
    public static void main(String[] args) {
        ArrayList<Integer> ArrayListRandomNumber = new ArrayList<>();

        ArrayListRandomNumber.add(1);
        ArrayListRandomNumber.add(6);
        ArrayListRandomNumber.add(1);
        ArrayListRandomNumber.add(2);
        ArrayListRandomNumber.add(3);
        ArrayListRandomNumber.add(5);

        System.out.println("Array List: "+ArrayListRandomNumber.toString()); // Prints out the arraylist
        int[] RegularArrayRandomNumbers = ArraylistToArray(ArrayListRandomNumber);
        System.out.println("Regular Array: "+Arrays.toString(RegularArrayRandomNumbers)); // Prints out the regular array
    }

    // (Integer is an object/wrapper class or data type while int is a primitive data type)
    // Converting an arraylist Integer into a regular array int
    public static int[] ArraylistToArray(ArrayList<Integer> arrlist) {
        int[] result = new int[arrlist.size()];
        for (int i = 0; i < arrlist.size(); i++) {
            result[i] = arrlist.get(i);
        }
        return result;
    }
}
