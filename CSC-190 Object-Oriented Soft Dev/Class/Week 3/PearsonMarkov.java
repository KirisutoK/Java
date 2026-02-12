import java.util.Scanner;

public class PearsonMarkov {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ThreeByThree[][] = new double[3][3];

        // SCANNER / INPUT
        System.out.println("Enter a 3-by-3 matrix row by row:");
        for (int i = 0; i < ThreeByThree.length; i++) { // Checks each row
            for (int j = 0; j < ThreeByThree[i].length; j++) { // Checks each index in the row
                ThreeByThree[i][j] = scanner.nextDouble();
            }
        }

        // CHECKS IF MARKOV
       if (isMarkovMatrix(ThreeByThree)) {
           System.out.println("It is not a Markov matrix");
       } else {
           System.out.println("It is a Markov matrix");
       }
    }

    // ========== METHODS ==========

    public static boolean isMarkovMatrix(double[][] arr) {
        // SUMS UP EACH COLUMN
        int sum = 0;
        for (int i = 0; i < arr[0].length; i++) { // each column (y axis)
            for (int j = 0; j < arr.length; j++) { // each row (x axis)
                sum += arr[j][i];
                if (sum >= 1) {
                    return true;
                }
            }
            sum = 0;
        }


        // CHECKS IF THE ARRAY HAS A NEGATIVE INT VALUE //////// ------------------->>>>>>> LEFT HERE (SUPPOSED TO CHECK EACH COLLUMN TOO (SUM EACH COLLUMN CONDITION)
        for (int i = 0; i < arr.length; i++) { // Checks each row
            for (int j = 0; j < arr[i].length; j++) { // Checks each index in the row
                if (arr[i][j] < 0); // if less than 0 (negative)
                return false;
            }
        }
        return true;
    }

    public static void Display(double[][] arr) {
        // DISPLAY (TEST)
        for (int i = 0; i < arr.length; i++) { // Checks each row
            for (int j = 0; j < arr[i].length; j++) { // Checks each index in the row
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}
