// First box is x or Row
// Second box is y or Columns
import java.util.Arrays;

public class MyArray {
    public static void main(String[] args) {
        // CREATING 2D ARRAY
        int[][] MyArray = {
                {0, 0, 3},
                {0, 0, 0},
                {7, 0, 0}};

        // PRINTING
        for (int i = 0; i < MyArray.length; i++) { // for each row
            for (int j = 0; j < MyArray[i].length; j++) { // for each index in the row
                System.out.println(MyArray[i][j]+" ");
            }
            System.out.println(" ");
        }

        // PRINTING WITH toString()
        System.out.println(Arrays.deepToString(MyArray)); // needs import java.util.Arrays
    }

}
