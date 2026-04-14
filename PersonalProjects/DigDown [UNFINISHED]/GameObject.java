// Creation Date: April 09, 2026. at 1:05 PM
// Last Modified: April 14, 2026. at  1:43 AM

import java.util.Random;
import java.util.Scanner;

public class GameObject {
    static Random random = new Random();
    static Scanner input = new Scanner(System.in);

    //=======VARIABLES=======//
    private int[][] TableNumbers;
    private int PlayerPosition; // Default 0
    private int MaximumBombs = 5;
    private int BombsPlaced = 0;
    private boolean Playing; // Default False

    private boolean isNew = true; // THIS IS TO STOP OVERWRITING THE DATA POSITION EVERY TIME WE GENERATE A TABLE

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GameObject() {
        TableNumbers = new int[10][5]; // there is 10 of a collection of 5 (Row: 10, Col: 5)
        Playing = true;
    }
    public GameObject(int row, int col) {
        TableNumbers = new int[row][col];
        Playing = true;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getTableRow() {
        return TableNumbers.length;
    }
    public int getTableColumn() {
        return TableNumbers[0].length;
    }
    public boolean BombisFull() {
        return BombsPlaced == MaximumBombs;
    }
    private void printTable() {
        //? PRINTS EVERY COLUMN
        for (int i = 0; i < getTableRow(); i++) {
            //? PRINTS EVERY ROW
            for (int j = 0; j < getTableColumn(); j++) {
                if (TableNumbers[i][j] == 0) {
                    System.out.print("🖼️");
                } else if (TableNumbers[i][j] == 1) {
                    System.out.print("⬇️");
                } else if (TableNumbers[i][j] == 2) {
                    System.out.print("💣");
                }
            }
            System.out.println(" "); // Space for Readability
        }
    }
    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    private void generateTable() {
        // 0 IS DEFAULT EMPTY ARRAY

        // PLACING THE PLAYER
        while (isNew) {
            PlayerPosition = getTableColumn()/2; // Updates Player Position (Column Position)
            isNew = false;
        }
        TableNumbers[0][PlayerPosition] = 1;

        // BOMB PLACEMENT
        while (!BombisFull()) { // if bomb is not full
            int randomX = random.nextInt(getTableRow()); // Row
            int randomY = random.nextInt(getTableColumn()); // Column

            // CHECK IF IT'S ALREADY A BOMB OR A PLAYER
            if (TableNumbers[randomX][randomY] != 1 && TableNumbers[randomX][randomY] != 2 ) { // if not
                TableNumbers[randomX][randomY] = 2;
                BombsPlaced++;
            }
        }

        System.out.print("");
    }
    private void gameOver() {
        System.out.println("""
                ╔════════════════╗
                ║   GAME OVER!   ║
                ╚════════════════╝
                """);
        Playing = false;

        // ASKING IF WANNA PLAY AGAIN
        System.out.println(" Would you like to play again? ");
        boolean ValidAnswer = false;
        do {
            try {
                // ASKING FOR INPUT
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.print("\nChoice Box: ");
                int Answer = input.nextInt();

                // CHECK IF ANSWER IS ON RANGE
                if (Answer > 0 && Answer < 3) {
                    ValidAnswer = true;
                } else {
                    throw new Exception();
                }

                // IF RESULTS
                if (Answer == 1) { // TODO: EVERYTIME WE TOUCH A BOMB, WE EITHER DECREASE THE MAXIMUM BOMB FOREVER OR IT JUST GETS MESSY (DOES NOT MEET MAXIMUM BOMB)
                    Playing = true;
                    resetTable();
                    playGame();
                } else if (Answer == 2) {
                    System.out.println("""
                            ╔═════════════════════════╗
                            ║   THANKS FOR PLAYING!   ║
                            ╚═════════════════════════╝
                            """);
                }
            } catch (Exception e) {
                System.out.println("Please choose between 1 or 2");
                input.nextLine();
            }
        } while (!ValidAnswer);
    }

    // [UNFINISHED]
    private void Move() {
        int[] result;

        // CHECKING THE FIRST ROW IF THERE IS A BOMB OR NOT
        for (int i = 0; i < getTableColumn(); i++) {
            //? DECREASE BOMBS PLACED IF THERE IS A BOMB
            if (TableNumbers[0][i] == 2) {
                BombsPlaced--;
            }
        }

        // MOVING THE BACKGROUND
        int[] NewRandomizedRow = new int[getTableColumn()]; //| NOTE: THE TEMPORARY ARRAY HAS 0 AS DEFAULT VALUES WHEN CREATING
        for (int i = 0; i < getTableRow()-1; i++) { // From 0 to TableRow-1
            if (i != getTableRow()) {
                result = TableNumbers[i+1];
                TableNumbers[i] = result;
            }
        }
        TableNumbers[getTableRow()-1] = NewRandomizedRow; // PLACING AN EMPTY ARRAY AT THE LAST ROW
        
        // RANDOMIZING THE NEW ROW (BACKGROUND)
        while (!BombisFull()) { // while it's not full
            int RandomPosition = random.nextInt(getTableColumn()); // Randomized position on where the bomb should be placed
            if (NewRandomizedRow[RandomPosition] != 2) {
                NewRandomizedRow[RandomPosition] = 2;
                BombsPlaced++;
            }

            // PLACING THE NEW GENERATED ARRAY INTO THE TABLE
            TableNumbers[getTableRow()-1] = NewRandomizedRow; // PLACES THE NEW RANDOMIZED ARRAY INTO THE LAST ROW (TableRow - 10 = 9) Note: 0-9 = 10 Rows
        }

        // ASKING WHICH WAY (RIGHT, MIDDLE, LEFT)
        boolean ValidAnswer = false;
        do {
            try {
                System.out.println("Choose a path:");
                if (PlayerPosition == 0) { // IF THE PLAYER IS IN THE LEFT WALL
                    System.out.println("1. Right");
                    System.out.println("2. Middle");
                } else if (PlayerPosition == getTableColumn()-1) { // IF THE PLAYER IS IN THE RIGHT WALL
                    System.out.println("2. Middle");
                    System.out.println("3. Left");
                } else {
                    System.out.println("1. Right");
                    System.out.println("2. Middle");
                    System.out.println("3. Left");
                }
                System.out.print("\nCHOICE: ");

                // ASKS FOR INPUT
                int Answer = input.nextInt();

                // CHECKS IF IT IS A VALID ANSWER
                // TODO: I AM A BIT WORRIED ABOUT THE EXCEPTIONS BECAUSE EACH IF STATEMENT HAS DIFFERENT SCENARIOS OF PROBLEMS SUCH AS FIRST IF STATEMENT CANNOT GO TO BEYOND 0 WHILE THE SECOND ONE CANNOT EXCEED.
                if (PlayerPosition == 0) { // IF THE PLAYER IS IN THE LEFT WALL
                    if (Answer == 1 || Answer == 2) { // if 2 or 3
                        ValidAnswer = true;
                    } else {
                        throw new Exception(); // TODO: CREATE A CUSTOM EXCEPTION
                    }
                } else if (PlayerPosition == getTableColumn()-1) { // IF THE PLAYER IS IN THE RIGHT WALL
                    if (Answer == 2 || Answer == 3) { // if 2 or 3
                        ValidAnswer = true;
                    } else {
                        throw new Exception();
                    }
                } else {
                    if (Answer > 0 && Answer < 4) { // IF ITS IN BETWEEN
                        ValidAnswer = true;
                    } else {
                        throw new Exception();
                    }
                }

                // UPDATING POSITION
                int PlayerPositionMinusOne = PlayerPosition-1; // THIS IS TO AVOID APPLYING CHANGES TO THE PLAYERPOSITION VARIABLE
                int PlayerPositionPlusOne = PlayerPosition+1; // THIS IS TO AVOID APPLYING CHANGES TO THE PLAYERPOSITION VARIABLE

                if (Answer == 1) { // 1. RIGHT
                    PlayerPosition++;
                    if (TableNumbers[0][PlayerPosition] != 2) { // IF IT IS NOT A BOMB
                        TableNumbers[0][PlayerPosition] = 1; // PLACES THE PLAYER
                    } else {
                        gameOver();
                    }
                } else if (Answer == 3) { // 2. LEFT
                    PlayerPosition--;
                    if (TableNumbers[0][PlayerPosition] != 2) { // IF IT IS NOT A BOMB
                        TableNumbers[0][PlayerPosition] = 1; // PLACES THE PLAYER
                    } else {
                        gameOver();
                    }
                }

            } catch (Exception e) { // IF THERE IS AN ERROR WHILE DOING THOSE PROCESS
                System.out.println("\nPlease choose between 1, 2, or 3");
                input.nextLine();
            }
        } while (!ValidAnswer);

        // CHECKS IF THE PLAYER TOUCHES A BOMB
        if (TableNumbers[0][PlayerPosition] == 2) {
            gameOver();
        }
    }
    private void resetTable() { // Makes Table turn into 0s
        for (int i = 0; i < getTableRow(); i++) {
            for (int j = 0; j < getTableColumn(); j++) {
                TableNumbers[i][j] = 0;
            }
        }
        BombsPlaced = 0;
        MaximumBombs = 5;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void playGame() {
        while (Playing) {
            generateTable();
            System.out.println(" "); // Space for Readability
            printTable();
            System.out.println(" "); // Space for Readability
            Move();
            System.out.println(" "); // Space for Readability
        }
    }
}

// TODO: BUG WITH BOMB DETECTION


// NOTES:
// 2dArray[row][col] <- THIS IS BASIC TERMS
// Creating an empty array have a default values of 0
//
// CODING POSITIONS:
// 0 -> SAFE
// 1 -> PLAYER (ALWAYS AT ROW 0)
// 2 -> BOMB
//