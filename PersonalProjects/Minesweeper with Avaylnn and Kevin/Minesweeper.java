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

        // RANDOMIZING 2D ARRAY BASED ON DIFFICULTY
        radRandy(Table);
        DisplayArray(Table);

        // PICKING A TILE
        UserInput(Table);
        System.out.println(" "); // Space for Readability
        ChangeTile(Table);
        System.out.println(" "); // Space for Readability
        DisplayArray(Table);
    }


    // ===================== METHODS ======================= \\

    // FINISHED
    public static void radRandy(int[][] table) {
        Random randy = new Random();

        boolean oo = false;

        System.out.println("""
                ╔═════════════════════════╗
                ║ CHOOSE YOUR DIFFICULTY: ║
                ║ 1. Easy                 ║
                ║ 2. Hard                 ║
                ║ 3. Nightmare            ║
                ║ 4. Randy                ║
                ╚═════════════════════════╝
                """);

        System.out.print("Answer: ");

        int difficultLevel = 0;

        while(oo == false) {
            int difficulty = scanner.nextInt(); //i moved this because earlier it was not int the while loop
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
                System.out.println("ERROR 67: Anwser didn't match giving options. Try again.");
            }
        }

        System.out.println(" "); //prints empty line for spacing

        //table[randy.nextInt(0,5)][randy.nextInt(0,5)] = 1;
        int i = 0;
        while(i < difficultLevel) {
            int randRow = randy.nextInt(0, table.length);
            int randCol = randy.nextInt(0,table.length);
            if(table[randRow][randCol] != 1) {
                table[randRow][randCol] = 1;
                i++;
            }
        }

    }  // Randomize the 2D Array (By Ava) [FINISHED]
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

        // IF THERE IS STILL 0
        if (sum != 0) {
            if (arr[row][col] == 0) {
                arr[row][col] = 2;
                score++;
            } else if (arr[row][col] == 1) {
                LoseMessage();
            }
        } else {
            WinMessage();
        }

        sum = 0; // resets
    } // Changes an index value [FINISHED]

    // UNFINISHED
    public static void DisplayArray(int[][] arr) { // changes the num
        int cols = arr[0].length; // AUTOSCALE WITH ARRAY SIZE
        String StraightLine = "═".repeat(cols*4); // *4 because each emoji takes ~4 chars width

        // DISPLAY
        System.out.println(" ".repeat(StraightLine.length() / 6) + "[ MINESWEEPER ]");
        System.out.println("╔"+StraightLine+"╗");                           // TOP BORDER
        for (int i = 0; i < arr.length; i++) { // checks the row
            System.out.print("║ ");                                                  // LEFT BORDER

            for (int j = 0; j < arr[i].length; j++) { // checks the column
                if (arr[i][j]==0) {
                    System.out.print("❤️ ");
                } else if (arr[i][j]==1) {
                    System.out.print("❤️ ");
                } else if (arr[i][j]==2) {
                    System.out.print("🌹 ");
                }
            }
            System.out.println("║");                                                 // RIGHT BORDER
        }
        System.out.println("╚"+StraightLine+"╝");                           // BOTTOM BORDER
    } // Displays Array [UNFINISHED: NEEDS VISUAL INCREMENTATION]
    public static void WinMessage() {
        System.out.println("YOU HAVE WON!");
    } // Displayers Win  message [UNFINISHED: NEEDS ASK RETRY AND VISUAL ENHANCMENT]
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
    } // Displays score point. lose message [UNFINISHED: NEED ASK RETRY]

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
    } // Changes the Class Variable (By Ava) [UNFINISHED: NO INPUT LIMIT]


    // ===================== INITIAL METHODS ======================= \\



    // ================= COMMENT ====================== \\
    // CHRIST: HI KEVIN!
}
