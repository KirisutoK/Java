//PickTile(int[][] arr, int a, int b)
//   -> takes an array, picks the index using the parameters (a and b) then change the value of that index to be 2, if the index is 0 or 1
//   then change a global boolean Lose to true. each time the tile is showed up, increment a global variable called int points


import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    // CLASS UTIL
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // CLASS VARIABLES
    static int row = 0;
    static int col = 0;
    static int score = 0;

    public static void main(String[] args) {
        // CREATING 2D ARRAY
        int[][] Table = new int[5][5];

        DisplayArray(Table);
        radRandy(Table);
        DisplayArray(Table);
    }


    // ===================== METHODS ======================= \\
    public static void DisplayArray(int[][] arr) { // changes the num
        for (int i = 0; i < arr.length; i++) { // checks the row
            for (int j = 0; j < arr[i].length; j++) { // checks the column
                if (arr[i][j]==0) {
                    System.out.print("❤️ ");
                } else if (arr[i][j]==1) {
                    System.out.print("🗿 ");
                } else if (arr[i][j]==2) {
                    System.out.print("🌹 ");
                }
            }
            System.out.println(" ");
        }
    } // Displays Array
    public static void UserInput(int[][] arr) {
        boolean boo = false;

        System.out.println("Please choose your tile.");
        System.out.print("Row: ");

        while(boo == false) {
            row = scanner.nextInt();
            if (row <= 5) {
                boo = true;
            } else {
                System.out.println("Not a valid response. Please try again: ");
            }
        }

        boo = false;

        System.out.print("Col: ");
        while(boo == false) {
            col = scanner.nextInt();
            if (col <= 5) {
                boo = true;
            } else {
                System.out.println("Not a valid response. Please try again: ");
            }
        }
    } // Changes the Class Variable (By Ava)
    public static void ChangeTile(int[][] arr) {
        // CHECKS IF THE TABLE HAS NO MORE 0s
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // each row
            for (int j = 0; j < arr.length; j++) { // each column
                if (arr[i][j] == 0) {
                    sum++;
                }
            }
        }

        if (sum != 0) {
            if (arr[row][col] == 0) {
                arr[row][col] = 2;
                score++;
            } else if (arr[row][col] == 1) {
                LoseMessage();
            }
        }

        sum = 0; // resets
    } // Changes an index value
    public static void radRandy(int[][] arr) {
        Random randy = new Random();

        boolean oo = false;

        System.out.println("Choose your difficulty: Easy(1), Hard(2), Nightmare(3), or Randy(4): ");
        int difficulty = scanner.nextInt();
        System.out.println(" ");
        int difficultLevel = 0;

        while(oo == false) {
            if(difficulty == 1) {
                difficultLevel = 1;
                oo = true;
            } else if(difficulty == 2) {
                difficultLevel = 3;
                oo = true;
            } else if(difficulty == 3) {
                difficultLevel = 5;
                oo = true;
            } else if(difficulty == 4) {
                difficultLevel = 10;
                oo = true;
            } else {
                System.out.println("Anwser didn't match giving options. Try again.");
            }
        }


        //table[randy.nextInt(0,5)][randy.nextInt(0,5)] = 1;
        int i = 0;
        while(i < difficultLevel) {
            int randRow = randy.nextInt(0,5);
            int randCol = randy.nextInt(0,5);
            if(arr[randRow][randCol] != 1) {
                arr[randRow][randCol] = 1;
                i++;
            }
        }

    } // Randomiz the 2D Array (By Ava)
    public static void LoseMessage() {
        System.out.println("""
                                *****   *******   **
                           *****  *********************  *****
                      ********************************************
                     **********************************************
                        **  *  ******************************  ***
                                   ****************
                                    ****************
                                   ****************
                                     **************
                                      **************                *
                          *          *************           *
                      *               ************      *
                    ****  ***   *   ****************  ****    **   ****
                ********************************************************
                """);
        System.out.println(" "); // Space for Readablity
        System.out.println("""
                ╔═════════════════════════╗
                ║ YOU HAVE LOSE THE GAME! ║
                ╚═════════════════════════╝
                """);
        System.out.println(" ");  // Space for Readability
        System.out.println("Score:"+score);
        System.out.println(" "); // Space for Readability
        System.out.println("""
                ╔══════════════════════════════╗
                ║ Would you like to try again? ║
                ║ 1. Yes             2. No     ║    
                ╚══════════════════════════════╝
                """);
        System.out.print("\nAnswer: ");
        int Answer = 0;
        boolean ValidAnswer = false;
        while (!ValidAnswer) {
            scanner.nextLine();
            Answer = scanner.nextInt();
            if (Answer == 1 || Answer == 2) {
                ValidAnswer = true;
            }
        }
        switch (Answer) {
            case 1:
                /// ////////////// INSERT WHERE IT WILL LEAD TO
                break;
            case 2:
                /// ////////////// INSERT WHERE IT WILL LEAD TO
                break;
        }
    } // Displays score point and lose message
}
