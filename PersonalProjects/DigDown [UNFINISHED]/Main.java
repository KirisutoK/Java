// Creation Date: March 31, 2026. at 10:55 AM
// Last Modified: April 07, 2026. at 11:49 AM

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Table();

    }

    // ============ METHODS TO WORK ON ============ \\
    // FINISHED

    // UNFINISHED
    public static void Table() {
        int width = 5;
        int height = 10;

        int Background = 0;
        int PlayerPosition = 0;

        for (int i = 0; i < height; i++) { // Height
            System.out.println();
            for (int j = 0; j < width; j++) { // Width
                if (i == 0 && j == 2) { // Play position
                    System.out.print("⬇️");
                } else {
                    System.out.print("🖼️");
                }
            }
        }
        System.out.print("");
    }
}




// Methods to work on:
// Generating random table
// Random generation with new array
//
// Game Functionality:
//
// 1. Ask's user to start game
// 2. displays table 10x15
// 3. there is an odd dot in the upper top middle that stands out and that is the userZ
// 4. tells the user which way to go (Left, right, middle)
// 5. the odd dot changes position on which way the user told them to go.
// 6. each time the whole array shifts, the table generates a random row of array in the bottom.
//
// Game Goal: reaching to the bottom (around 10 blocks down)
//
// Game Logic:
// Bomb = Game Over