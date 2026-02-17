import com.sun.source.tree.WhileLoopTree;

import java.lang.classfile.instruction.TableSwitchInstruction;
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
    static boolean isAlive = true;

    static int[][] Table; // CREATING TABLE

    public static void main(String[] args) {
        // MAIN GAME
        Start();
        while (isAlive = true) {
            Play();
        }
    }


    // ===================== METHODS ======================= \\

    // MAIN GAME
    public static void Play() {
        UserInput();
        ChangeTile();
    }
    public static void Start() {
        Table = radRandy();
        DisplayArray();
        Play();
    }

    // FINISHED
    public static int[][] radRandy() {
        int value = 0;
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
                value = 5;
                oo = true;
            } else if(difficulty == 2) {
                difficultLevel = 3;
                value = 10;
                oo = true;
            } else if(difficulty == 3) {
                difficultLevel = 5;
                value = 15;
                oo = true;
            } else if(difficulty == 4) {
                difficultLevel = 10;
                value = 20;
                oo = true;
            } else {
                System.out.println("ERROR 67: Anwser didn't match giving options. Try again.");
            }
        }

        int[][] Table = new int[value][value]; //creates new array based on choosen difficulty

        System.out.println(" "); //prints empty line for spacing

        //table[randy.nextInt(0,5)][randy.nextInt(0,5)] = 1;
        int i = 0;
        while(i < difficultLevel) {
            int randRow = randy.nextInt(0, Table.length);
            int randCol = randy.nextInt(0,Table.length);
            if(Table[randRow][randCol] != 1) {
                Table[randRow][randCol] = 1;
                i++;
            }
        }

        return Table; //returns array

    }  // Randomize the 2D Array (By Ava) [FINISHED]
    public static void ChangeTile() {
        // CHECKS IF THE TABLE HAS NO MORE 0s
        int sum = 0;
        for (int i = 0; i < Table.length; i++) { // each row
            for (int j = 0; j < Table.length; j++) { // each column
                if (Table[i][j] == 0) {
                    sum++;
                }
            }
        }

        // IF THERE IS STILL 0
        if (sum != 0) {
            if (Table[row][col] == 0) {
                Table[row][col] = 2;
                score++;
                DisplayArray(); // Shows display
                Play(); // runs play method
            } else if (Table[row][col] == 1) {
                isAlive = false;
                LoseMessage();
            }
        } else {
            WinMessage();
        }

        sum = 0; // resets
    } // Changes an index value [FINISHED]

    // UNFINISHED
    public static void DisplayArray() { // changes the num
        int cols = Table[0].length; // AUTOSCALE WITH ARRAY SIZE
        String StraightLine = "═".repeat(cols*4); // *4 because each emoji takes ~4 chars width

        // DISPLAY
        System.out.println(" ".repeat(StraightLine.length() / 6) + "[ MINESWEEPER ]");
        System.out.println("╔"+StraightLine+"╗");                           // TOP BORDER


        for (int i = 0; i < Table.length; i++) { // checks the row
            System.out.print("║ ");                                                  // LEFT BORDER

            for (int j = 0; j < Table[i].length; j++) { // checks the column
                if (Table[i][j]==0) { // EMPTY
                    System.out.print("❤️ ");
                } else if (Table[i][j]==1) { // BOMB
                    System.out.print("💣 ");
                } else if (Table[i][j]==2) { // FILLED IN
                    System.out.print("🌹 ");
                }
            }


            System.out.println("║");                                                 // RIGHT BORDER
        }
        System.out.println("╚"+StraightLine+"╝");                           // BOTTOM BORDER
    } // Displays Array [UNFINISHED: NEEDS VISUAL INCREMENTATION]
    public static void WinMessage() {
        System.out.println("""
                ╔═════════════════════════╗
                ║ YOU HAVE LOSE THE GAME! ║
                ╚═════════════════════════╝
                """);
    } // Displays Win  message [UNFINISHED: NEEDS ASK RETRY AND VISUAL ENHANCMENT]
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
                Start();
                break;
            case 2:
                System.out.println("GOODBYE");
                break;
        }
    } // Displays score point. lose message [UNFINISHED: NEED ASK RETRY]

    public static void UserInput() {
        boolean boo = false;

        System.out.println("Please choose your tile.");
        System.out.print("Row: ");

        while(boo == false) {
            row = scanner.nextInt();
            if (row <= 4) {
                boo = true;
            } else {
                System.out.println("Not a valid response. Please try again: ");
            }
        }

        boo = false;

        System.out.print("Col: ");
        while(boo == false) {
            col = scanner.nextInt();
            if (col <= 4) {
                boo = true;
            } else {
                System.out.println("Not a valid response. Please try again: ");
            }
        }
    } // Changes the Class Variable (By Ava) [UNFINISHED: THERE'S A BUG HERE!]
    // ===================== INITIAL METHODS ======================= \\

    // ================= COMMENT ====================== \\
    // CHRIST: HI KEVIN!
    // ava was here
    // CHRIST: HELLO
}
