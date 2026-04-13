// Creation Date: April 09, 2026. at 1:05 PM
// Last Modified: April 12, 2026. at 11:48 PM

import java.util.Random;

public class GameObject {
    static Random random = new Random();

    //=======VARIABLES=======//
    private int[][] TableNumbers;
    private int MaximumBombs = 5;
    private int BombsPlaced = 0;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GameObject() {
        TableNumbers = new int[10][5]; // there is 10 of a collection of 5 (Row: 10, Col: 5)
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
    public void copyTableArrayRow() {
        int[] TestArray = TableNumbers[1];

        for (int i:TestArray) {
            System.out.print(i);
        }
    }
    public void moveMiddle() {
        int[] result = TableNumbers[1];
        TableNumbers[0] = result;
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

// NOTES:
// 2dArray[col][row] <- THIS IS BASIC TERMS
// Creating an empty array have a default values of 0
//
// CODING POSITIONS:
// 0 -> SAFE
// 1 -> PLAYER
// 2 -> BOMB