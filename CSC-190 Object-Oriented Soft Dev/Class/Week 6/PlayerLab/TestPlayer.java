// Creation Date: March 05, 2026. at 9:59 AM
// Last Modified: March 05, 2026. at 11:09 AM

import java.util.Scanner;

public class TestPlayer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // CREATING PLAYER
        System.out.print("Enter your Name: ");
        String ChosenName = input.nextLine();
        System.out.print("Enter your Gamer Tag: ");
        String ChosenTag = input.nextLine();
        System.out.print("Enter your Age: ");
        int ChosenAge = input.nextInt();

        // CREATING INSTANCES AND OBJECTS
        Player Player01 = new Player(ChosenName, ChosenTag, ChosenAge);
        GameObject LOL = new GameObject(1, 2, 3);

        // DISPLAY
        Player01.displayInformation();

        // PLAYING
        for (int i = 0; i < 50; i++) {
            LOL.playGame(Player01);
            System.out.println(" "); // Space for readability
        }

        // DISPLAY
        Player01.displayInformation();
        
    }
}
