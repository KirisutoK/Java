// Creation Date: October 27, 2026. at 12:10 PM
// Last Modified: October 27, 2026. at  3:45 PM

// LINK: https://leetcode.com/problems/create-grid-with-exactly-one-path/?envType=daily-question&envId=2026-10-27

import java.util.Scanner;

public class CreateGridWithExactlyOnePath {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // [INPUT]
        System.out.print("Row: ");
        int m = input.nextInt(); // Row
        System.out.print("Column: ");
        int n = input.nextInt(); // Col
        System.out.println();

        // Display
        createGrid(m, n);

    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public static void createGrid(int m, int n) {
        // INITIALIZING STANDARD GRID
        for (int i = 0; i < m; i++) { // for every row
            for (int j = 0; j < n; j++) { // for every col
                if (i == 0) {
                    System.out.print(".");
                } else if (j == n-1) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}

// Note: I took many hours because i read the question/problem wrong.