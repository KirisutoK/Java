// Creation Date: March 05, 2026. at 9:59 AM
// Last Modified: March 05, 2026. at 11:08 AM

import java.util.Random;
import java.util.Scanner;

public class GameObject {


    //=======VARIABLES=======//
    private int x;
    private int y;
    private int layer;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GameObject() {

    }
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public GameObject(int x, int y, int layer) {
        this.x = x;
        this.y = y;
        this.layer = layer;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getLayer() {
        return layer;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setLayer(int layer) {
        this.layer = layer;
    }

    // [ORIGINAL METHODS]
    public void playGame(Player player) {
        player.addGamesPlayed();

        Scanner input = new Scanner(System.in);
        System.out.print("Choose a number between 0 and 1: ");
        int ChosenNumber = input.nextInt();

        // CHECK IF THE CHOSEN NUMBER IS 0 AND 1
        while (ChosenNumber != 0 && ChosenNumber != 1) {
            System.out.print("Please choose between 0 and 1: ");
            ChosenNumber = input.nextInt();
        }

        // RANDOMIZING THE ANSWERS
        Random random = new Random();
        int RandomNumbers = random.nextInt(2); // 0 to 1

        // CHECK IF WIN OR NOT
        if (RandomNumbers == 0) {
            System.out.println(player.getName()+"Has lose the game");
        } else {
            player.addWin();
            System.out.println(player.getName()+"Has won the game");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

//    Random random = new Random(USERNUMBER);
//
//    char uppercase = (char)(random.nextInt(26) + 65);
//    char lowercase = (char)(random.nextInt(26) + 97);
//    char digit = (char)(random.nextInt(10)+48);
}
