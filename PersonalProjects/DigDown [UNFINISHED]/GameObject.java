// Creation Date: April 09, 2026. at 1:05 PM
// Last Modified: April 13, 2026. at 12:50 PM

import java.util.Random;

public class GameObject {
    static Random random = new Random();

    //=======VARIABLES=======//
    private int[][] TableNumbers;
    private int PlayerPosition;
    private int MaximumBombs = 5;
    private int BombsPlaced = 0;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GameObject() {
        TableNumbers = new int[10][5]; // there is 10 of a collection of 5 (Row: 10, Col: 5)
        PlayerPosition = getTableColumn()/2;
    }
    public GameObject(int row, int col) {
        TableNumbers = new int[row][col];
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
    public void printTable() {
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
    public void generateTable() {
        // 0 IS DEFAULT EMPTY ARRAY

        // PLACING THE PLAYER
        TableNumbers[0][getTableColumn()/2] = 1;

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

    // [TEST PURPOSES]
    // TODO: YOU WERE TRYIGN TO SASVE AN ARRAY FROM BELOW IN ORDER TO MOVE THE BACKGROUND
    // TODO: YOU ALREADY CREATED THE COPY ARRAY, NOW YOU JUST NEED TO IMPLEMENT ON HOW TO MOVE IT FOR THE REST OF THE OTHER ROWS
    public void moveMiddle() {
        int [] result;

        // TEST
        System.out.println("Bombs Placed: "+BombsPlaced);
        System.out.println("Maximum Bombs: "+MaximumBombs);
        // CHECKING IF THE BOMB IS REMOVED OR NOT
        for (int i = 0; i < getTableColumn(); i++) {
            //? DECREASE BOMBS PLACED IF THERE IS A BOMB THAT IS REMOVED
            if (TableNumbers[0][i] == 2) {
                BombsPlaced--;
            }
        }
        // TEST
        System.out.println("Bombs Placed: "+BombsPlaced);
        System.out.println("Maximum Bombs: "+MaximumBombs);

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
            }

            // PLACING THE NEW GENERATED ARRAY INTO THE TABLE
            TableNumbers[getTableRow()-1] = NewRandomizedRow; // PLACES THE NEW RANDOMIZED ARRAY INTO THE LAST ROW (TableRow - 10 = 9) Note: 0-9 = 10 Rows
            BombsPlaced++;
        }


        //! PLACING THE PLAYER ======>>> THE HITTING THE BOMB DID NOT ACTIVATE.
        if (TableNumbers[0][getTableColumn()/2] == 1) {
            System.out.println("You hit a bomb");
            return; //! breaks the method (NOT SURE)
        } else {
            TableNumbers[0][getTableColumn()/2] = 1;
        }

//        int[] result = TableNumbers[1];
//        TableNumbers[0] = result;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public int[] generateTableArrayRow() {
        int[] result = new int[getTableRow()]; // Creating a new 1D Array

        // CHECK IF WE HAVE ENOUGH BOMB
        while (!BombisFull()) { // WHILE IT'S NOT FULL
            int RandomPosition = random.nextInt(TableNumbers.length);

            // CHECK IF IT'S ALREADY A BOMB
            if (result[RandomPosition] != 2) {
                result[RandomPosition] = 2;
                BombsPlaced++;
            }
        }


        return result;
    }
}

// TODO: SOMETHING IS WRONG WITH THE TABLE WHEN A BOMB IS REMOVED FROM THE TABLE

// NOTES:
// 2dArray[row][col] <- THIS IS BASIC TERMS
// Creating an empty array have a default values of 0
//
// CODING POSITIONS:
// 0 -> SAFE
// 1 -> PLAYER
// 2 -> BOMB