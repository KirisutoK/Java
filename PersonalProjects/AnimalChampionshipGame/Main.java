// Unfinished
// 
// INTRODUCTION
// 1. Ask the user for its name
// 2. Choose an Animal
// 3. Use that Animal as a Pet
// 4. There are multiple mobs that appears everytime you advance
// 4. There are 5 stages

import java.util.Scanner;
import java.util.Random;

public class Main {
    // ========== GLOBAL INSTANCES ========= \\
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static Player player1 = new Player(" ", 0, " ", 0); // UserName, Health, Pet, PetDamage

    // ========== GLOBAL VARIABLES =========== \\
    static int DialogueSpeed = 0;
    static boolean hasRolledParkSecret = false;
    static int PlayerChoice = 0;

    // ======================================== \\
    public static void main(String[] args) {
        getNameAndDialogueSpeed();

        // PHASE 1: Introduction and Choosing your Companion
        Introduction();
        Story1();
        int Story1SecretChance = random.nextInt(10)+1;
        if (Story1SecretChance < 2) {
            Story1Secret();
        } else {
            ChooseAnimals();
        }
        Story2();
        showStats();

        // PHASE 2: Getting Started with Fighting 
        Story3();

    }

    // ================================ STORY METHODS ================================ \\
    public static void Introduction() {
        Dialogue("\n");
        Dialogue("""
                ╔═════════════════════════════════════════════════════════════════════╗
                ║                  BECOME THE GREATEST ANIMAL OWNER                   ║
                ╚═════════════════════════════════════════════════════════════════════╝
                """);
        Dialogue("\n");

        Dialogue("""
                    One day, you stumbled upon a poster announcing the Grand Animal 
                Championship. One million dollars and the title of Champion. 
                all yours if you could defeat the current title holder. You knew this was 
                your chance. All you needed was the right companion by your side, and 
                victory would be within reach.
                """);
    }
    public static void Story1() {
        Dialogue("""
                \nWhen you saw the poster, you rushed to a nearby pet store in search of a 
                companion, the next animal champion who could help you win that 
                million-dollar prize.
                """);
    }
    public static void Story1Secret() {
        Dialogue("""
                    \nYou rushed through the store until suddenly, you felt it, your 
                instincts screaming that you had been chosen by something primordial.
                A [Tyrannosaurus Rex]! (2/10 Chance)
                """);
                
        String VisualTREX = ("""


                .       --.                  ╔═══════════════════════════════════════════════════╗                                                                     
      ------.--------+++++++---              ║ The [Tyrannosaurus Rex] choose you as his Master! ║                                                         
    -+++--.--+++++++++++#++-+++--.           ╚═══════════════════════════════════════════════════╝                                                         
   -+----..-------+++++++++---+----                                                               
  -++++----.---..---++++++-.---+--+-                                                                                
 ++++++----......---++++++-...-+-------      ----------                                                   .-++++--  
  +++++++----...---+++++--------++.-----------------------..--------                                .-----+-..      
   . .-....--+++#######++---+++-+---+-.-......-------........-+--------                         .-------.           
             -#######++++++-++--++-.----...-.....----.........----+------                    .-------.              
             .######++++----+---++++------..--....----.........+--++-----..               ---------                 
              ++++#+-++++++++-.-++++++.---...------------......-++++-----.--..       ...---------.                  
              .---+-++++++++-.---+-++++--++-.----+-++------....--+++++++-.-..-.--....--.--------                    
             .--+++#+++++++--.--+++++-++-+++--+++++++-.----......--++++++.-.----....-----.----                      
         +++++++#++++++++-------+++----------++++++++------......-++++++--...------......--+.                       
           .+##+++++++------- .++++++-------++++++++++-.-+--.....-++++++----.--+-.-.----++.                         
         .-++--++------+-..      .-+++++++++++++++++++------.-...++++++++--.---+++++++-.                            
       .--+-++------.              ....--++++++++#++++--------.--++++++++-....-+-----                               
       -++++++---                  -#+-.---+++++##++++++------..-+++++++++-...-++-                                  
         +++-                    #++++.--+-++#+-+#+++--+++---..--+#+++++++--.-.                                     
                               -+##++ .-++++++++++-+++-+++----.-++##+++#++++--                                      
                                -  ..  -++#-+++++++++++--+++-.-++++++++++++++-.                                     
                                        -++++++++++++++++++++++---.  ++++++++--+-                                   
                                        -+++#++++++                   .++#+++--+++                                  
                                         ++++++++++                    .+#+++--+--                                  
                                         .+++++++++                      -+++++++-..                                
                                           +#++++++                        .+++++++-.                               
                                             ++++++.                           -+#++-                               
                                              ++++++                            .++++                               
                                              .++++++                           --+++                               
                                             .+++++++                            --+++                              
                                            -+--#++.                             +.+++-                             
                                          -+++-+-+                          .--++--+++..                            
                                    .----+++---+ .                        -#++++++++++-+-                           
                              +#+++#++++++--#++-                                                                    
                                ------... .-+-             
                                                  
                """);
                
        try { 
            for (char c : VisualTREX.toCharArray()) {
                System.out.print(c);
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            System.out.println("An error occurred during loading.");
        }

        player1.setAll(500, "Tyrannosaurus Rex", 200); // +health, Pet, +Petdamage
    }
    public static void Story2() {
        Dialogue("""
                \nYou stride into the nearest animal center to register your companion.

                The clerk glances at your pet, then slowly looks back at you. A smirk creeps across his face.

                "So... you're entering the Grand Animal Championship?" he asks, barely suppressing a chuckle.

                You meet his gaze with unwavering confidence. "That's right. And I'm not just entering, I'm going to WIN."

                The clerk lets out a mocking laugh. "Well then, best of luck to you both. You're going to need it." 
                
                He slides your registration papers across the counter with a dismissive flick of his wrist. 
                
                "Try not to get too crushed when reality hits."

                Your jaw tightens, but you refuse to give him the satisfaction of a response.

                You snatch the papers, turn on your heel, and leave with your pet at your side.

                The championship awaits. And you're going to prove every doubter wrong.
                """);
    }

    // STORY 3: INTRODUCTION TO SEMI-OPEN WORLD
    public static void Story3() { 
        Dialogue("""
                \n\nAs you exit the animal center, you saw the sun blazing down on the bustling city streets.
                
                The sounds of honking cars and chattering pedestrians filled the air.

                You took a deep breath and decided to think about what your next move would be.
                """);

        Story3Options();
    }
    public static void Story3Options() {
        String VisualCityMap = ("""
                
                
                ═══════════╗
                 CITY...   ║
                ═══════════╝
                                                    +              
                                                   / \\
                 _____        _____     __________/ o \\/\\_________      _________
                |o o o|_______|    |___|               | | # # #  |____|o o o o  | /\\
                |o o o|  * * *|: ::|. .|               |o| # # #  |. . |o o o o  |//\\\\
                |o o o|* * *  |::  |. .| []  []  []  []|o| # # #  |. . |o o o o  |((|))
                |o o o|**  ** |:  :|. .| []  []  []    |o| # # #  |. . |o o o o  |((|))
                |_[]__|__[]___|_||_|__<|____________;;_|_|___/\\___|_.|_|____[]___|  |
                """);
        
        try { 
            for (char c : VisualCityMap.toCharArray()) {
                System.out.print(c);
                Thread.sleep(5);
            }
        } catch (InterruptedException e) {
            System.out.println("An error occurred during loading.");
        }

        Dialogue("\n╔═════════════════════════════════════════════╗");
        Dialogue("\n║ 1. Head to the Forest to train your pet.    ║");
        Dialogue("\n║ 2. Fight with other owners in the Park.     ║");
        Dialogue("\n║ 3. Explore the City for hidden challenges.  ║");
        Dialogue("\n║ 4. Show User ID                             ║");
        Dialogue("\n╚═════════════════════════════════════════════╝");
        Dialogue("\n");
        Dialogue("\nChoose your Next Move: ");
        
        PlayerChoice = scanner.nextInt();

        switch (PlayerChoice) {
            case 1: // FOREST
                String VisualForest = ("""

                ═══════════╗
                 Forest    ║
                ═══════════╝


                                         ^    ^	          
                                  ^     / \\  / \\              (o)
                                 /  \\  /   \\/   \\  ^         
                                /    \\/    /     \\/ \\  
                        ^  ^  ^   ^ \\   /   ^  ^   ^  ^  ^   ^  ^
                        /|\\/|\\/|\\ /|\\ \\     /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\
                        /|\\/|\\/|\\ /|\\       /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\
                        /|\\/|\\/|\\ /|\\.!.,!! /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\ 
                """);

                try { 
                    for (char c : VisualForest.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(5);
                    }
                } catch (InterruptedException e) {
                    System.out.println("An error occurred during loading.");
                }

                Dialogue("""
                        \nYou decided to head to the Forest to train your pet.

                        The dense trees and chirping birds created a serene atmosphere, perfect for honing your pet's skills.
                        """);
                Story3Forest();
                break;
            case 2: // PARK
                String VisualPark = ("""

                ═══════════╗
                 Park      ║
                ═══════════╝

                           _______
                          | []  []|            O
                    _______ []  []|       -
                   | #   # |[]  []|      - -
                   |^  ^ # |[]  []|          ^  ^
                 _ / \\/ \\  _   ...   ^   _  / \\/ \\ _
                | |,,,,,,,| |-------/ \\!| |,,,,,,,| |
                | |!!!!!!!| |  !.       | |!!!!!!!| |
                | |=======| |___________| |=======| |
                """);

                try { 
                    for (char c : VisualPark.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(5);
                    }
                } catch (InterruptedException e) {
                    System.out.println("An error occurred during loading.");
                }

                Dialogue("""
                \nYou went to the City Park.

                The bustling streets and towering skyscrapers offered endless opportunities for adventure and growth.

                In the Park, you encountered many types of animal owners looking to test their pets' skills.

                As you look around, there are animal owners fighting each other.
                """);

                int SecretRouteChance = random.nextInt(10)+1;

                if (hasRolledParkSecret == false) { // Roll only once
                    hasRolledParkSecret = true;
                    if (SecretRouteChance <= 3) { // 30% Chance of falling in love (Rolls once only)
                    Story3ParkSecret();
                    } else {
                        Story3Park();
                    }
                } else {
                    Story3Park();
                }

                break;
            case 3: // EXPLORE CITY
                Story3CityExploration();
                break;


            default:
                break;
                
        }
    }
    public static void Story3Park() { // Creates 3 Random Opponents (Mobs) to choose from
        int RandomPlayer1 = random.nextInt(4)+1;
        Mob ParkEnemy1;
        switch (RandomPlayer1) {
            case 1:
                ParkEnemy1 = new Mob("Mihai", 20, "Dog", 10); // UserName, Health, PetName, PetDamage
                break;
            case 2:
                ParkEnemy1 = new Mob("Mordecai", 15, "Cat", 5); // UserName, Health, PetName, PetDamage
                break;
            case 3:
                ParkEnemy1 = new Mob("Koba", 70, "Horse", 70); // UserName, Health, PetName, PetDamage
                break;
            case 4:
                ParkEnemy1 = new Mob("Sigurd", 2, "Squirrel", 1); // UserName, Health, PetName, PetDamage
                break;
            default: // JUST NEEDED INCASE THERE IS AN ERROR
                ParkEnemy1 = new Mob("ERROR", 0, "error", 0); 
                break;
        }

        int RandomPlayer2 = random.nextInt(4)+1;
        Mob ParkEnemy2;
        switch (RandomPlayer2) {
            case 1:
                ParkEnemy2 = new Mob("Tahir", 1, "Hamster", 1); // UserName, Health, PetName, PetDamage
                break;
            case 2:
                ParkEnemy2 = new Mob("Angele", 50, "Cow", 1); // UserName, Health, PetName, PetDamage
                break;
            case 3:
                ParkEnemy2 = new Mob("Martim", 20, "Chicken", 10); // UserName, Health, PetName, PetDamage
                break;
            case 4:
                ParkEnemy2 = new Mob("Catharina", 65, "Pig", 10); // UserName, Health, PetName, PetDamage
                break;
            default: // JUST NEEDED INCASE THERE IS AN ERROR
                ParkEnemy2 = new Mob("ERROR", 0, "error", 0); 
                break;
        }

        int RandomPlayer3 = random.nextInt(4)+1;
        Mob ParkEnemy3;
        switch (RandomPlayer3) {
            case 1:
                ParkEnemy3 = new Mob("Jamal", 45, "Goat", 40); // UserName, Health, PetName, PetDamage
                break;
            case 2:
                ParkEnemy3 = new Mob("Ava", 5, "Crow", 7); // UserName, Health, PetName, PetDamage
                break;
            case 3:
                ParkEnemy3 = new Mob("Nahal", 150, "Horse", 25); // UserName, Health, PetName, PetDamage
                break;
            case 4:
                ParkEnemy3 = new Mob("Darshan", 100, "Dog", 15); // UserName, Health, PetName, PetDamage
                break;
            default: // JUST NEEDED INCASE THERE IS AN ERROR
                ParkEnemy3 = new Mob("ERROR", 0, "error", 0); 
                break;
        }
        
        Dialogue("\n=================== CHOOSE YOUR OPPONENT ===================");
        Dialogue("\n1. " + ParkEnemy1.getUserName() + " (Pet: " + ParkEnemy1.getPet() + " | Health: " + ParkEnemy1.getHealth() + " | Damage: " + ParkEnemy1.getPetDamage() + ")");
        Dialogue("\n2. " + ParkEnemy2.getUserName() + " (Pet: " + ParkEnemy2.getPet() + " | Health: " + ParkEnemy2.getHealth() + " | Damage: " + ParkEnemy2.getPetDamage() + ")");
        Dialogue("\n3. " + ParkEnemy3.getUserName() + " (Pet: " + ParkEnemy3.getPet() + " | Health: " + ParkEnemy3.getHealth() + " | Damage: " + ParkEnemy3.getPetDamage() + ")");
        Dialogue("\n4. Refresh Opponents");
        Dialogue("\n5. Leave the Park");
        Dialogue("\n=============================================================");
        Dialogue("\n");
        Dialogue("\nYour Choice: ");
        

        PlayerChoice = scanner.nextInt();
        switch (PlayerChoice) {
            case 1:
                boolean FightResult1 = CombatSystem.startCombat(player1, ParkEnemy1);

                if (FightResult1 == true) {
                    Dialogue("\nWould you like to fight again?");
                    Dialogue("\n 1. Yes");
                    Dialogue("\n 2. No");
                    Dialogue("\n");
                    Dialogue("\nYour Choice:");
                    int TryAgain = scanner.nextInt();

                    if (TryAgain == 1) {
                        Story3Park();
                    } else {
                        Story3Options();
                    }
                } 
                break;
            case 2:
                boolean FightResult2 = CombatSystem.startCombat(player1, ParkEnemy2);

                if (FightResult2 == true) {
                    Dialogue("\nWould you like to fight again?");
                    Dialogue("\n 1. Yes");
                    Dialogue("\n 2. No");
                    Dialogue("\n");
                    Dialogue("\nYour Choice:");
                    int TryAgain = scanner.nextInt();

                    if (TryAgain == 1) {
                        Story3Park();
                    } else {
                        Story3Options();
                    }
                }    
                break;
            case 3:
                boolean FightResult3 = CombatSystem.startCombat(player1, ParkEnemy3);

                if (FightResult3 == true) {
                    Dialogue("\nWould you like to fight again?");
                    Dialogue("\n 1. Yes");
                    Dialogue("\n 2. No");
                    Dialogue("\n");
                    Dialogue("\nYour Choice:");
                    int TryAgain = scanner.nextInt();

                    if (TryAgain == 1) {
                        Story3Park();
                    } else {
                        Story3Options();
                    }
                }    
                break;
            case 4:
                Story3Park();
                break;
            case 5:
                Story3Options();
                break;
            default:
                Dialogue("\nInvalid choice. Please select a valid opponent.\n");
                Story3Park();
                break;
        }
    }
    public static void Story3ParkSecret() {
        Dialogue("""

                You bumped into a mysterious animal owner, you look at her feet, then her dress, and then her face. She looks at you with a smile.

                ╔════════════════════════════════════════════╗
                ║  Congratulations! You've fallen in love    ║
                ╚════════════════════════════════════════════╝

                You and the mysterious animal owner started to date, training your pets together and eventually becoming girlfriends and boyfriends.

                After a few years, you both are now married and have a family together, raising your pets and children with love and care.

                Your family opened a business helping other animal owners help improve their performance and health.

                Time passed by and you became wealthy, famous, and is living on happiness.

                Beyond the passion to pursue success, it is not what you always see, but rather the greatest victory is found in places that you dont expect.

                ╔════════════════════════════════════════════╗
                ║   SECRET ROUTE: Falling In Love   (30%)    ║
                ╚════════════════════════════════════════════╝

                """);

    }   
    public static void Story3Forest() {
        int RandomForestMob = random.nextInt(7)+1;
        Mob ForestEnemy;
        
        switch (RandomForestMob) {
            case 1:
                System.out.println("\nA Wild Wolf appears!\n");
                ForestEnemy = new Mob("The Forest", 80, "Wolf", 20); // UserName, Health, PetName, PetDamage
                break;
            case 2:
                System.out.println("\nA Wild Fox appears!\n");
                ForestEnemy = new Mob("The Forest", 50, "Fox", 15);
                break;
            case 3:
                System.out.println("\nA Wild Grizzly Bear appears!\n");
                ForestEnemy = new Mob("The Forest", 150, "Bear", 100);
                break;
            case 4:
                System.out.println("\nA Wild Golden Eagle appears!\n");
                ForestEnemy = new Mob("The Forest", 40, "Eagle", 25);
                break;
            case 5:
                System.out.println("\nA Wild Rabbit appears!\n");
                ForestEnemy = new Mob("The Forest", 20, "Rabbit", 5);
                break;
            case 6:
                System.out.println("\nA Wild Deer appears!\n");
                ForestEnemy = new Mob("The Forest", 70, "Deer", 18);
                break;
            case 7:
                System.out.println("\nA Wild Masked Raccoon appears!\n");
                ForestEnemy = new Mob("The Forest", 45, "Raccoon", 12);
                break;
            default:
                System.out.println("\nA Wild Wolf appears!\n");
                ForestEnemy = new Mob("The Forest", 80, "Wolf", 20);
                break;
        }

        boolean fightResult = CombatSystem.startCombat(player1, ForestEnemy);
    
        // Check if player ran away successfully (fightResult is false but player is still alive)
        if (!fightResult && player1.getHealth() > 0) {  
            Story3Options();
        }
        else if (fightResult) { // If Player Wins the fight
            showStats();
            Dialogue("\n\nChoose your Next Move:");
            Dialogue("\n1. Continue Training in the Forest.");
            Dialogue("\n2. Return to the City.\n");

            // Blank Lines for Readability
            System.out.println();

            System.out.print("Your Choice: ");

            PlayerChoice= scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (PlayerChoice == 1) {
                Dialogue("\nYou went deeper in the woods");
                Dialogue("\n. . . . . . . . . . . . . . .\n");

                Story3Forest(); // Brings him back to the forest
            }
            else {
                Story3Options(); // Brings him back to the city
            }
        } 
        else {
            // Player was defeated in combat
            Dialogue("\n\nYour journey ends here...");
        }
    }
    public static void Story3CityExploration() {
        String VisualExploreCity = ("""

                ═══════════╗
                 CITY      ║
                ═══════════╝


                                     ┌┐                                            
                                     ││             ┌┐             ┌┐              
                                     │└┐           ┌┘│            ┌┘└┐       ╓─╖   
                                     │:└┐          │:│            └┐┌┘       ║:║   
                               ╔═══════╗│        ┌─┘ └───┐      ╔══╧╧═╗  ╓──╥╜:║   
                               ║ ≡≡≡≡≡≡╚╗        │= = = =│     ╔╝┌┬┬┬┐║  ║::║::║   
                               ║ ≡≡≡≡≡≡ ║        │=  = ==└┐    ║┌┼┼┼┼┤╚╗ ║::║::║   
                        ╔═══════╗≡≡≡≡≡≡ ║                      ║├┼┼┼┼├┐║ ║::║::║   
                        ║ [] [] ║≡≡≡≡≡≡ ║           ▓▓▓        ║└┴┴┴┴┴┘╓─╨──╨──╨─╖ 
                        ║ [] [] ║≡≡≡≡≡≡ ║   ▓▓     ▓▓▓▓▓  ╔════╝───────║ () () ()║ 
                        ║ [] [] ║≡≡≡≡≡≡ ║  ▓▓▓▓    ▓▓▓▓▓  ║ ┌┐┌┐┌┐┌┐┌┐ ║ () () ()║ 
                        ║       ║       ║  ▓▓▓▓     ├┼┤   ║ └┘└┘└┘└┘└┘ ║ () () ()║ 
                        ║ ┌───┐ ║    ╔╖ ║   ├┤      ├┼┤   ║ ┌┬┬┬┬┬┬┬┬┐ ║ ╔══════╗║ 
                        ▒▒▒░░░░░▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒░░░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                        """);

                try { 
                    for (char c : VisualExploreCity.toCharArray()) {
                        System.out.print(c);
                        Thread.sleep(5);
                    }
                } catch (InterruptedException e) {
                    System.out.println("An error occurred during loading.");
                }

                Dialogue("\n╔═════════════════════════════════════════════╗");
                Dialogue("\n║ 1. Go to the Hospital.                      ║");
                Dialogue("\n║ 2. Follow the Suspicious Man                ║");
                Dialogue("\n║ 3. Enter the Arena.                         ║");
                Dialogue("\n║ 4. Show User ID                             ║");
                Dialogue("\n╚═════════════════════════════════════════════╝");
                Dialogue("\n");
                Dialogue("\nChoose your Next Move: ");

                PlayerChoice = scanner.nextInt();

                switch (PlayerChoice) {
                    case 1: // Hospital
                        Dialogue("\nYou went inside the hospital to heal your animal");
                        Dialogue("\n");
                        Dialogue("\nHealing");

                        String HealingLoading = ". . . ";
                        try { 
                            for (char c : HealingLoading.toCharArray()) {
                                System.out.print(c);
                                Thread.sleep(500);
                            }
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred during loading.");
                        }

                        player1.fullHeal();

                        Dialogue("\n");
                        Dialogue("\nYour pet has successfuly healed!");

                        Story3CityExploration();
                        break;


                    case 2: // Follow the Suspicious Man
                        Dialogue("You follow the suspicious man ");

                        String FollowingLoading = ". . . ";
                        try { 
                            for (char c : FollowingLoading.toCharArray()) {
                                System.out.print(c);
                                Thread.sleep(500);
                            }
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred during loading.");
                        }

                        GameOverDisplay();
                        break;
                    case 3: // Arena
                        Arena();
                        break;
                    case 4:
                        showStats();
                        Story3CityExploration();
                        break;

                    default:
                        Story3CityExploration();
                        break;
                }

    }
    public static void Arena() { //Initiated by going through Exploration City 
        String VisualArenaMap = ("""
                ═══════════╗
                  ARENA    ║
                ═══════════╝


                                                  ô            
                     ô                            │            
                     │                            │            
                     │                           ┌┼┐           
                    ┌┼┐              ô       ╔╦╦╦╦╦╦╦╦╦╗       
                ╔═══╧╧╧═══╗          │       ║╫╫╫╫╫╫╫╫╫║       
                ║ ┌ ┐ ┌ ┐ ║          │       ╚╩╬╩╩╩╩╩╬╩╝       
                ║ ╔══════════════════╗┐        ║     ║         
                ║-║ ╔╗  ╔╗╔╗  ╔╗╔╗╔╗ ╚╧═══╗┐   ║     ║         
                ║-║ ╚╝  ╚╝╚╝  ╚╝╚╝╚╝      ╚╧═╗┐║     ║──┐      
                ║-║ ╔╗╔╗      ╔╗╔╗  ╔╗╔╗╔╗╔╗ ╚══════════╗      
                ║-║ ╚╝╚╝      ╚╝╚╝  ╚╝╚╝╚╝╚╝            ║      
                ║-║ ╔╗  ╔╗╔╗    ╔╗╔╗╔╗╔╗  ╔╗╔╗  ╔╗  ╔╗  ║      
                ║-║ ╚╝  ╚╝╚╝    ╚╝╚╝╚╝╚╝  ╚╝╚╝  ╚╝  ╚╝  ║      
                ║-║----   ---          -----      ----- ║      
                ║-║╔╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╦╗║      
            ▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓

                """);
        
            try { 
                for (char c : VisualArenaMap.toCharArray()) {
                    System.out.print(c);
                        Thread.sleep(5);
                    }
                } catch (InterruptedException e) {
                    System.out.println("An error occurred during loading.");
                }
        
        

        Dialogue("""

            ╔═════════════════════════════════════════════════════════════════════════╗
            ║ WELCOME TO THE [ARENA] WHERE THE STRONGEST SURIVE WHILE THE WEAKEST DIE ║
            ╚═════════════════════════════════════════════════════════════════════════╝

                """);

        Dialogue("\nThere Are 5 opponents that you have to beat to get the Championship: ");
        Dialogue("\n1. ");
        Dialogue("\n2. ");
        Dialogue("\n3. ");
        Dialogue("\n4. ");
        Dialogue("\n5. ");
        Dialogue("\n");
        Dialogue("\n╔═════════════════════════════════════════════╗");
        Dialogue("\n║ 1. Participate in the Arena                 ║");
        Dialogue("\n║ 2. Leave                                    ║");
        Dialogue("\n║ 3. Show User ID                             ║");
        Dialogue("\n╚═════════════════════════════════════════════╝");
        Dialogue("\n");
        Dialogue("\nChoose your Next Move: ");

        PlayerChoice = scanner.nextInt();

        switch (PlayerChoice) {
            case 1:
                ArenaBattle();
                break;
            case 2:
                Story3CityExploration();
                break;
            case 3:
                showStats();
                Arena();
                break;
            default:
                Story3CityExploration();
                break;
        }
    }
    public static void ArenaBattle() {
        Mob ArenaEnemy1 = new Mob("Brenna", 70, "Crocodile", 100); // UserName, Health, PetName, PetDamage
        Mob ArenaEnemy2 = new Mob("Laren", 50, "Lion", 70);
        Mob ArenaEnemy3 = new Mob("Qaranih", 1000, "Mammoth", 500);
        Mob ArenaEnemy4 = new Mob("Jabez", 2000, "Kraken", 1500);
        Mob ArenaEnemy5 = new Mob("Samuel", 5000, "Dragon", 4200);

        CombatSystem.startCombat(player1, ArenaEnemy1);
        CombatSystem.startCombat(player1, ArenaEnemy2);
        CombatSystem.startCombat(player1, ArenaEnemy3);
        CombatSystem.startCombat(player1, ArenaEnemy4);
        CombatSystem.startCombat(player1, ArenaEnemy5);

        Dialogue("""

            
                ╔═══════════════════════════════════════════╗
                ║ CONGRATULATIONS YOU HAVE BEATEN THE GAME  ║
                ╚═══════════════════════════════════════════╝
                """);
    }
    // ====================================== SET METHODS ====================================== \\
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
        CombatSystem.setDialogueSpeed(DialogueSpeed);
    }
    public static void ChooseAnimals() { // Assigns the Pet & Pet Damage
        Dialogue("""
                \n||========================= CHOOSE AN ANIMAL ========================= ||
                1. Cat                                     6. Cow  
                2. Dog                                     7. Pig 
                3. Squirrel                                8. Chicken 
                4. Crow                                    9. Goat 
                5. Hamster                                10. Horse 
                ========================================================================
                \n""");

        int AnimalChoices = scanner.nextInt();
        switch (AnimalChoices) {  
            case 1: // Cat
                player1.setAll(15, "Cat", 5); // +health, Pet, +Petdamage
                break;
            case 2: // Dog
                player1.setAll(20, "Dog", 10); // +health, Pet, +Petdamage
                break;
            case 3: // Squirrel
                player1.setAll(2, "Squirrel", 1); // +health, Pet, +Petdamage
                break;
            case 4: // Crow
                player1.setAll(5, "Crow", 7); // +health, Pet, +Petdamage
                break;
            case 5: // Hamster
                player1.setAll(1, "Hamster", 1); // +health, Pet, +Petdamage 
                break;
            case 6: // Cow
                player1.setAll(50, "Cow", 1); // +health, Pet, +Petdamage
                break;
            case 7: // Pig
                player1.setAll(65, "Pig", 10); // +health, Pet, +Petdamage
                break;
            case 8: // Chicken
                player1.setAll(20, "Chicken", 10); // +health, Pet, +Petdamage
                break;
            case 9: // Goat
                player1.setAll(45, "Goat", 40); // +health, Pet, +Petdamage
                break;
            case 10: // Horse
                player1.setAll(70, "Horse", 70); // +health, Pet, +Petdamage
                break;
            default: // Cat
                player1.setAll(15, "Cat", 5); // +health, Pet, +Petdamage
                break;
        }
    }

    // ================================ MISCELLANIOUS METHODS ================================ \\
    public static void showStats() {
        Dialogue("\n\n||================== USER STATS ==================||");
        Dialogue("\n Username:  " + player1.getUserName());
        Dialogue("\n Level:  " + player1.getLevel());
        Dialogue("\n EXP:  " + player1.getExp() + " / " + player1.getExpToNextLevel());
        Dialogue("\n Health:  " + player1.getHealth() + " / " + player1.getMaxHealth());
        Dialogue("\n Pet:  " + player1.getPet());
        Dialogue("\n PetDamage:  " + player1.getPetDamage());
        Dialogue("\n=================================================");
    }
    public static void GameOverDisplay() {
        Dialogue("\n╔════════════════════════════════════╗");
        Dialogue("\n║            GAME OVER!              ║");
        Dialogue("\n╚════════════════════════════════════╝");
        Dialogue("\n");
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
