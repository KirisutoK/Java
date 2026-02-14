//PickTile(int[][] arr, int a, int b)
//   -> takes an array, picks the index using the parameters (a and b) then change the value of that index to be 2, if the index is 0 or 1
//   then change a global boolean Lose to true. each time the tile is showed up, increment a global variable called int points


import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    static Scanner scanner = new Scanner(System.in);

    // GLOBAL VARIABLES
    static int a = 0;
    static int b = 0;


    public static void main(String[] args) {


        // 2D ARRAY (RANDOMIZED)
        int hiddenI = 0;
        int hiddenJ = 0;
        int[][] realNumber = new int[3][3];
        for ( hiddenI = 0; hiddenI < realNumber.length; hiddenI++) {
            for (hiddenJ = 0; hiddenJ < realNumber.length; hiddenJ++) {
                Random rd = new Random();
                int random = rd.nextInt(0, 2);
                realNumber[hiddenI][hiddenJ] = random;
                System.out.print(realNumber[hiddenI][hiddenJ] + " ");


            }
            System.out.println();
        }

        // METHODS
        DisplayArray(realNumber); // DISPLAYS ARRAY

    }



    // ===================== METHODS ======================= \\
    public static void DisplayArray(int[][] arr) { // changes the num
        for (int i = 0; i < arr.length; i++) { // checks the row
            for (int j = 0; j < arr[i].length; j++) { // checks the column
                if (arr[i][j]==0) {
                    System.out.print("❤️ ");
                } else if (arr[i][j]==1) {
                    System.out.print("❤️ ");
                }
            }
            System.out.println(" ");
        }
    }
    public static void TakeInput() {
        System.out.println("Choose which row: ");
    }
}
