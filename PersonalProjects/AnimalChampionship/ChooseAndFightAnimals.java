// Unfinished
// 
// INTRODUCTION
// 1. Ask the user for its name
// 2. Choose an Animal
// 3. Use that Animal as a Pet
// 4. There are multiple mobs that appears everytime you advance
// 4. There are 10 stages

import java.util.Scanner;
import java.util.Random;

public class ChooseAndFightAnimals {
    // ========== GLOBAL INSTANCES ========= \\
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static Player player1 = new Player(" ", 100, " ", 0); // UserName, Health, Pet, PetDamage

    // ========== GLOBAL VARIABLES =========== \\
    static int DialogueSpeed = 0;


    // ======================================== \\
    public static void main(String[] args) {
        getNameAndDialogueSpeed();

        Introduction();

        Story1();
        int Story1SecretChance = random.nextInt(10)+1;
        if (Story1SecretChance > 2) {
            Story1Secret();
        } else {
            ChooseAnimals();
        }

        showStats();
    }

    // ================================ STORY METHODS ================================ \\
    public static void Introduction() {
        Dialogue("\n|| ================ BECOME THE GREATEST ANIMAL OWNER ================ ||\n\n");

        Dialogue("""
                    One day, you stumbled upon a poster announcing the Grand Animal 
                Championship. The prize? One million dollars and the title of Champion. 
                all yours if you could defeat the current title holder. You knew this was 
                your chance. All you needed was the right companion by your side, and 
                victory would be within reach.
                """);
    }
    public static void Story1() {
        Dialogue("""
                \nWhen you saw the poster, you rushed to a nearby pet store in search of a 
                companion—the next animal champion who could help you win that 
                million-dollar prize.
                """);
    }
    public static void Story1Secret() {
        Dialogue("""
                    \nYou rushed through the store until suddenly, you felt it—your 
                instincts screaming that you had been chosen by something primordial.
                A Tyrannosaurus Rex!
                """);
        Dialogue("\nThe Tyrannosaurus Rex choose you as his Master!");

        player1.setAll(1000, "Tyrannosaurus Rex", 500); // +health, Pet, +Petdamage
    }

    // ======================================  METHODS ====================================== \\
    public static void getNameAndDialogueSpeed() {
        System.out.print("\nLadies and gentlemen... or should I say, FUTURE CHAMPION! Before the games begin, please state your name for the record. ");
        player1.setUserName(scanner.nextLine());

        System.out.println("\nExcellent! " + player1.getUserName() + " has entered the arena!\n");

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
    public static void ChooseAnimals() { // Assigns the Pet & Pet Damage
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
                player1.setAll(100, "Cat", 10); // +health, Pet, +Petdamage
                break;
            case 2: // Dog
                player1.setAll(50, "Dog", 25); // +health, Pet, +Petdamage
                break;
            case 3: // Squirrel
                player1.setAll(1, "Squirrel", 1); // +health, Pet, +Petdamage
                break;
            case 4: // Bird
                player1.setAll(5, "Bird", 20); // +health, Pet, +Petdamage
                break;
            case 5: // Hamster
                player1.setAll(0, "Hamster", 0); // +health, Pet, +Petdamage 
                break;
            case 6: // Cow
                player1.setAll(75, "Cow", 5); // +health, Pet, +Petdamage
                break;
            case 7: // Pig
                player1.setAll(100, "Pig", 10); // +health, Pet, +Petdamage
                break;
            case 8: // Chicken
                player1.setAll(10, "Chicken", 120); // +health, Pet, +Petdamage
                break;
            case 9: // Goat
                player1.setAll(100, "Goat", 200); // +health, Pet, +Petdamage
                break;
            case 10: // Horse
                player1.setAll(500, "Horse", 100); // +health, Pet, +Petdamage
                break;
            default: // Cat
                player1.setAll(100, "Cat", 10); // +health, Pet, +Petdamage
                break;
        }
    }
    
    // ================================ MISCELLANIOUS METHODS ================================ \\

    public static void showStats() {
        Dialogue("""
                \n\n|| ================== USER STATS ================== ||
                Username: """ + player1.getUserName() + """
                \nHealth: """ + player1.getHealth() + """
                \nPet: """ + player1.getPet() + """
                \nDamage: """ + player1.getPetDamage() + """
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
