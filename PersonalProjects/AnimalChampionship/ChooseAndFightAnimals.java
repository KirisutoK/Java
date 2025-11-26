// Unfinished
// 
// INTRODUCTION
// 1. Ask the user for its name
// 2. Choose an Animal
// 3. Use that Animal as a Weapon
// 4. There are multiple mobs that appears everytime you advance
// 4. There are 10 stages

import java.util.Scanner;
import java.util.Random;

public class ChooseAndFightAnimals {
    // ========== GLOBAL INSTANCES ========= \\
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // ========== GLOBAL VARIABLES =========== \\
    static int DialogueSpeed = 0;

    // ======================================== \\
    public static void main(String[] args) {

        getNameAndDialogueSpeed();

        Player player1 = new Player(" ", ) //////////// THIS IS WHERE YOU LEFT OFF

        Introduction();

        Story1();
        int Story1SecretChance = random.nextInt(10)+1;
        if (Story1SecretChance < 2) {
            Story1Secret();
        } else {

        }

        showStats();

    }

    // ================================ Story METHODS ================================ \\

    public static void getNameAndDialogueSpeed() {
        System.out.print("\nLadies and gentlemen... or should I say, FUTURE CHAMPION! Before the games begin, please state your name for the record. ");
        UserName = scanner.nextLine();

        System.out.println("\nExcellent! " + UserName + " has entered the arena!\n");

        System.out.println("How fast would you like the dialogue to be?");
        System.out.println("""
                1. Fast
                2. Normal
                3. Slow
                """);

        int DialogueSpeedChoice = scanner.nextInt();
        int[] DialogueSpeedArray = {1, 2, 3, 0}; // Choices
        DialogueSpeed = DialogueSpeedArray[DialogueSpeedChoice-1]; // -1 in order to meet the required slot
    }
    public static void Introduction() {
        Dialogue("\n|| ================ BECOME THE GREATEST ANIMAL OWNER ================ ||\n\n");

        Dialogue("""
                    One day, you stumbled upon a poster announcing the Grand Animal 
                Championship. The prize? One million dollars and the title of Champion. 
                all yours if you could defeat the current title holder. You knew this was 
                your chance. All you needed was the right companion by your side, and 
                victory would be within reach.\n\n.
                """);
    }
    public static void ChooseAnimals() { // Assigns the Weapon & Weapon Damage
        Dialogue("""
                ||========================= CHOOSE AN ANIMAL ========================= ||
                1. Cat                                     6. Cow  
                2. Dog                                     7. Pig 
                3. Squirrel                                8. Chicken 
                4. Bird                                    9. Goat 
                5. Hamster                                10. Horse 
                ========================================================================
                \n""");

        int AnimalChoices = scanner.nextInt();
        switch (AnimalChoices) {
            case 1: // Cat
                Weapon = "Cat";
                WeaponDamage += 10;
                Health += 100;
                break;
            case 2: // Dog
                Weapon = "Dog";
                WeaponDamage += 25;
                Health += 50;
                break;
            case 3: // Squirrel
                Weapon = "Squirrel";
                WeaponDamage += 1;
                Health += 1;
                break;
            case 4: // Bird
                Weapon = "Bird";
                WeaponDamage += 20;
                Health += 5;
                break;
            case 5: // Hamster
                Weapon = "Hamster";
                WeaponDamage += 0;
                Health += 0;
                break;
            case 6: // Cow
                Weapon = "Cow";
                WeaponDamage += 5;
                Health += 75;
                break;
            case 7: // Pig
                Weapon = "Pig";
                WeaponDamage += 10;
                Health += 100;
                break;
            case 8: // Chicken
                Weapon = "Chicken";
                WeaponDamage += 120;
                Health += 10;
                break;
            case 9: // Goat
                Weapon = "Goat";
                WeaponDamage += 200;
                Health += 100;
                break;
            case 10: // Horse
                Weapon = "Horse";
                WeaponDamage += 100;
                Health += 500;
                break;
            default: // Cat
                Weapon = "Cat";
                WeaponDamage += 10;
                Health += 100;
                break;
        }
    }
    public static void Story1() {
        Dialogue("""
                When you saw the poster, you rushed to a nearby pet store in search of a 
                companion—the next animal champion who could help you win that 
                million-dollar prize.
                """);
    }
    public static void Story1Secret() {
        Dialogue("""
                    You rushed through the store until suddenly, you felt it—your 
                instincts screaming that you had been chosen by something primordial.
                A Tyrannosaurus Rex!
                """);
        Dialogue("The Tyrannosaurus Rex choose you as his Master!");

        Weapon = "Tyrannosaurus Rex";
        WeaponDamage += 5000;
        Health += 10000;
    }
    // ================================ MISCELLANIOUS METHODS ================================ \\

    public static void showStats() {
        Dialogue("""
                \n|| ================== USER STATS ================== ||
                Username: """ + UserName + """
                \nHealth: """ + Health + """
                \nWeapon: """ + Weapon + """
                \nDamage: """ + WeaponDamage+ """
                \n=================================================\n               
                """
                        );
    }
    public static String Dialogue(String Dialogue) { // Prints each word by word with a delay making it look like a typing effect
        try { 
            for (char Characters : Dialogue.toCharArray()) {
                System.out.print(Characters);
                Thread.sleep(25 * DialogueSpeed);
            }
        } catch (InterruptedException e) {
            Dialogue("An error occurred during loading.");
        }
        return Dialogue;
    }
}
