// Creation Date: April 09, 2026. at 1:05 PM
// Last Modified: April 11, 2026. at 10:49 AM

import java.util.Random;

public class GameObject {
    //=======VARIABLES=======//
    private int[][] TableNumbers;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GameObject() {
        TableNumbers = new int[5][10];
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
    public void printTable() {
        //? PRINTS EVERY COLUMN
        for (int i = 0; i < TableNumbers[0].length; i++) {
            //? PRINTS EVERY ROW
            for (int j = 0; j < TableNumbers.length; j++) {
                if (TableNumbers[j][i] == 0) {
                    System.out.print("🖼️");
                } else if (TableNumbers[j][i] == 1) {
                    System.out.print("⬇️");
                } else if (TableNumbers[j][i] == 2) {
                    System.out.print("💣");
                }
            }
            System.out.println(" "); // Space for Readability
        }
    }
    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void generateTable() {
        Random random = new Random();

        // PLACING THE PLAYER
        TableNumbers[TableNumbers.length/2][0] = 1;

        // FOR EVERY ROW
        for (int col = 0; col < TableNumbers[0].length; col++) {
            // FOR EVERY COLUMN
            for (int row = 0; row < TableNumbers.length; row++) {
                if (TableNumbers[row][col] != 1) {
                    TableNumbers[row][col] = 0;
                }
            }
        }

        // TODO: RANDOMIZING DEATH POSITION

        // if its 1 then throw an error

        TableNumbers[random.nextInt(5)][random.nextInt(10)] = 2;
        TableNumbers[random.nextInt(5)][random.nextInt(10)] = 2;
        TableNumbers[random.nextInt(5)][random.nextInt(10)] = 2;
        TableNumbers[random.nextInt(5)][random.nextInt(10)] = 2;
        // generate 5 bombs in random

        // as player moves down, generating new, the maximum bomb increases by 1


        

        System.out.print("");
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

/// I dont know but its just here (THIS IS JUST TO MAKE MY GITHUB LOOK NICE)