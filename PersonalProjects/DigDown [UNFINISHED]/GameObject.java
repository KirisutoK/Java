// Creation Date: April 09, 2026. at 1:05 PM
// Last Modified: April 09, 2026. at  1:24 PM

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
                }
            }
            System.out.println(" "); // Space for Readability
        }
    }
    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void generateTable() {
        //? FOR EVERY ROW
        for (int col = 0; col < TableNumbers[0].length; col++) {
            //? FOR EVERY COLUMN
            for (int row = 0; row < TableNumbers.length; row++) {
                // TODO: DO SOME MATH HERE TO SCALE WHERE THE PLAYER WILL BE (RULE IS THAT THE PLAYER MUST BE IN THE MIDDLE TOP OF THE TABLE WHICH IS AN ARROW)
                if (TableNumbers[2][])
                TableNumbers[row][col] = 0;
            }
        }

        System.out.print("");
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}