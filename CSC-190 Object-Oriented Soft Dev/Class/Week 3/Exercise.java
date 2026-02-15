import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
         //user input - number of rows and columns
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter the number of rows and columns of the array: ");
         int rows = sc.nextInt();
         int cols = sc.nextInt();

         //create a new array using user-provided # of rows and cols
         double[][] array = new double[rows][cols];

         System.out.println("Enter the array:");
         for (int r = 0; r < array.length; r++) {
             for (int c = 0; c < array[0].length; c++) {
                 array[r][c] = sc.nextDouble();
             }
         }

         int[] results = locateLargest(array);
         System.out.println("The location of the largest element is at (" + results[0] + "," + results[1] + ")");
//        for (int r = 0; r < array.length; r++) {
//            for (int c = 0; c < array[0].length; c++) {
//                System.out.print(array[r][c] + " ");
//            }
//            System.out.println();
//        }
    }
    public static int[] locateLargest(double[][] a) {
        double largestValue = a[0][0];
        int[] locationLargest = {0, 0};
        for (int i = 0; i<a.length; i++) {
            for (int j = 0; j<a[0].length; j++) {
                if (a[i][j] > largestValue) {
                    largestValue = a[i][j];
                    locationLargest[0] = i;
                    locationLargest[1] = j;
                }
            }
        }
        return locationLargest;
    }
}