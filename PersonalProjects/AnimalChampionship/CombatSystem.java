import java.util.Scanner;
import java.util.Random;

public class CombatSystem {
    
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    
    // Original enemy stats  [THIS IS USED FOR EXP CALCULATION]
    static int EnemyMaxHealth = 0;
    static int EnemyMaxDamage = 0;

    // Dialogue Speed
    static int DialogueSpeed = 1; // Default speed
    
    // Method to show the introduction
    public static void showIntroduction(Player player, Mob enemy) {
        Dialogue("\n[[[ " + player.getUserName() + " V.S. " + enemy.getUserName() + " ]]]");
        Dialogue("\n");
        Dialogue("\n" + player.getUserName() + ": " + player.getPet() + " (HP: " + player.getHealth() + ") (" + player.getPetDamage() + " DMG)"); //Your Champion: Dog (HP: 100) (20 DMG)
        Dialogue("\n" + enemy.getUserName() + ": " + enemy.getPet() + " (HP: " + enemy.getHealth() + ") (" + enemy.getPetDamage() + " DMG)");
        Dialogue("\n");

        EnemyMaxDamage = enemy.getPetDamage();
        EnemyMaxHealth = enemy.getHealth();
    }
    // Method to wait for player to engage
    public static void waitForPlayerToEngage() {
        Dialogue("\nPress Enter to ENGAGE FIGHT...");
        scanner.nextLine();
        Dialogue("\n{  THE FIGHT BEGINS! }");
        Dialogue("\n");
    }
    



    //=============== COMBAT EXECUTION (MATH) ================\\
    // Method to execute player attack
    public static void playerAttack(Player player, Mob enemy) {
        int baseDamage = player.getPetDamage();
        int damageVariation = (int)(baseDamage * 0.2); // 20% variation
        int damage = random.nextInt(damageVariation + 1) + (baseDamage - damageVariation/2);
        
        String attackAction = player.getAttackMessage(); // This method should return a string like "bites", "claws", etc.

        Dialogue("\nYour " + player.getPet() + " " + attackAction + " the " + enemy.getPet() + " and dealt " + damage + " damage!");
        
        enemy.setHealth(-damage); // Subtract damage
    }
    // Method to execute enemy attack
    public static void enemyAttack(Player player, Mob enemy) {
        int baseDamage = enemy.getPetDamage();
        int damageVariation = (int)(baseDamage * 0.2); // 20% variation
        int damage = random.nextInt(damageVariation + 1) + (baseDamage - damageVariation/2);
        
        String attackAction = enemy.getAttackMessage();
        Dialogue("\nThe " + enemy.getPet() + " " + attackAction + " your " + player.getPet() + " and dealt " + damage + " damage!");
        
        player.setHealth(-damage); // Subtract damage
    }
    // Main combat loop
    public static boolean startCombat(Player player, Mob enemy) {
        showIntroduction(player, enemy);
        waitForPlayerToEngage();
        
        int round = 1;
        
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            Dialogue("\n--- ROUND " + round + " ---");
            Dialogue("\n");
            
            // Player attacks first
            playerAttack(player, enemy);
            if (isEnemyDefeated(enemy)) {
                showVictory(player, enemy);
                return true; // Player wins
            }
            
            Dialogue("\n");
            
            // Enemy attacks
            enemyAttack(player, enemy);
            if (isPlayerDefeated(player)) {
                showDefeat(player, enemy);
                return false; // Player loses
            }
            
            // Display current status
            displayStatus(player, enemy);
            round++;
        }
        
        return player.getHealth() > 0; // Return true if player won
    }
    
    //=======================================================\\






    //=================== CHECKERS ===================\\
    // Method to check if enemy is defeated
    public static boolean isEnemyDefeated(Mob enemy) {
        if (enemy.getHealth() <= 0) {
            Dialogue("\n");
            Dialogue("\n[:D] The " + enemy.getPet() + " has been defeated!");
            return true;
        }
        return false;
    }
    // Method to check if player is defeated
    public static boolean isPlayerDefeated(Player player) {
        if (player.getHealth() <= 0) {
            Dialogue("\n");
            Dialogue("\n[D:] Your " + player.getPet() + " has been defeated!");
            return true;
        }
        return false;
    }
    
    //=======================================================\\






    //=================== DISPLAY STATUS ===================\\
    // Method to display current HP status
    public static void displayStatus(Player player, Mob enemy) {
        Dialogue("\n");
        Dialogue("\n.: " + player.getPet() + " HP {" + player.getHealth() + "/" + player.getMaxHealth() + "} ");
        Dialogue("\n.: " + enemy.getPet() + " HP {" + enemy.getHealth() + "/" + enemy.getMaxHealth() + "} ");
        Dialogue("\n");
    }
    // Method to show victory message
    public static void showVictory(Player player, Mob enemy) {
        Dialogue("\n");
        Dialogue("\n════════════════════════════════");
        Dialogue("\n        FIGHT RESULTS");
        Dialogue("\n════════════════════════════════");
        Dialogue("\n");
        Dialogue("\n|--- { VICTORY! } ---|");
        Dialogue("\n");
        Dialogue("\nYour " + player.getPet() + " wins with " + player.getHealth() + "/" + player.getMaxHealth() + " HP remaining!\n");
    }
    // Method to show defeat message
    public static void showDefeat(Player player, Mob enemy) {
        Dialogue("\n");
        Dialogue("\n════════════════════════════════");
        Dialogue("\n        FIGHT RESULTS");
        Dialogue("\n════════════════════════════════");
        Dialogue("\n");
        Dialogue("\n|--- { DEFEAT! } ---|");
        Dialogue("\n\nYour " + player.getPet() + " was defeated!");
        Dialogue("\n\nThe " + enemy.getPet() + " had " + enemy.getHealth() + "/" + enemy.getMaxHealth() + " HP remaining.");
        Dialogue("\n");
    }
    //=======================================================\\



    //=================== EXP CALCULATION ===================\\
    // Calculate EXP reward based on enemy stats
    public static int calculateExpReward() {
        // Base EXP is related to enemy's power
        int baseExp = (EnemyMaxHealth / 2) + (EnemyMaxDamage * 2);
        return baseExp;
    }
    //=======================================================\\



    //=================== UTILITY METHODS ===================\\
    //get Dialogue Speed
    public static void setDialogueSpeed(int DialogueSpeedI) {
        DialogueSpeed = DialogueSpeedI;
    }
    // Type Effect 
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
    //=======================================================\\
}
