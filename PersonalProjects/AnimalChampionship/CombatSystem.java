import java.util.Scanner;
import java.util.Random;

public class CombatSystem {
    
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    
    // Method to pause for dramatic effect
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    // Method to show the introduction
    public static void showIntroduction(Player player, Mob enemy) {
        System.out.println("[[[ " + player.getUserName() + " V.S. " + enemy.getUserName() + " ]]]");
        System.out.println();
        System.out.println(player.getUserName() + ": " + player.getPet() + " (HP: " + player.getHealth() + ") (" + player.getPetDamage() + " DMG)"); //Your Champion: Dog (HP: 100) (20 DMG)
        System.out.println(enemy.getUserName() + ": " + enemy.getPet() + " (HP: " + enemy.getHealth() + ") (" + enemy.getPetDamage() + " DMG)");
        System.out.println();
    }
    
    // Method to wait for player to engage
    public static void waitForPlayerToEngage() {
        System.out.println("Press Enter to ENGAGE FIGHT...");
        scanner.nextLine();
        System.out.println("{  THE FIGHT BEGINS! }");
        System.out.println();
        pause(1500);
    }
    
    // Method to execute player attack
    public static void playerAttack(Player player, Mob enemy) {
        int baseDamage = player.getPetDamage();
        int damageVariation = (int)(baseDamage * 0.2); // 20% variation
        int damage = random.nextInt(damageVariation + 1) + (baseDamage - damageVariation/2);
        
        String attackAction = player.getAttackMessage();
        System.out.println("Your " + player.getPet() + " " + attackAction + " the " + enemy.getPet() + " and dealt " + damage + " damage!");
        
        enemy.setHealth(-damage); // Subtract damage
        pause(1200);
    }
    
    // Method to execute enemy attack
    public static void enemyAttack(Player player, Mob enemy) {
        int baseDamage = enemy.getPetDamage();
        int damageVariation = (int)(baseDamage * 0.2); // 20% variation
        int damage = random.nextInt(damageVariation + 1) + (baseDamage - damageVariation/2);
        
        String attackAction = enemy.getAttackMessage();
        System.out.println("The " + enemy.getPet() + " " + attackAction + " your " + player.getPet() + " and dealt " + damage + " damage!");
        
        player.setHealth(-damage); // Subtract damage
        pause(1200);
    }
    
    // Method to check if enemy is defeated
    public static boolean isEnemyDefeated(Mob enemy) {
        if (enemy.getHealth() <= 0) {
            System.out.println();
            System.out.println("[:D] The " + enemy.getPet() + " has been defeated!");
            return true;
        }
        return false;
    }
    
    // Method to check if player is defeated
    public static boolean isPlayerDefeated(Player player) {
        if (player.getHealth() <= 0) {
            System.out.println();
            System.out.println("[D:] Your " + player.getPet() + " has been defeated!");
            return true;
        }
        return false;
    }
    
    // Method to display current HP status
    public static void displayStatus(Player player, Mob enemy) {
        System.out.println();
        System.out.println(".: " + player.getPet() + " HP: " + player.getHealth());
        System.out.println(".: " + enemy.getPet() + " HP: " + enemy.getHealth());
        System.out.println();
        pause(1500);
    }
    
    // Method to run the main fight loop
    public static boolean startCombat(Player player, Mob enemy) {
        showIntroduction(player, enemy);
        waitForPlayerToEngage();
        
        int round = 1;
        
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("--- ROUND " + round + " ---");
            System.out.println();
            
            // Player attacks first
            playerAttack(player, enemy);
            if (isEnemyDefeated(enemy)) {
                showVictory(player, enemy);
                return true; // Player wins
            }
            
            System.out.println();
            pause(800);
            
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
    
    // Method to show victory message
    public static void showVictory(Player player, Mob enemy) {
        System.out.println();
        System.out.println("════════════════════════════════");
        System.out.println("        FIGHT RESULTS");
        System.out.println("════════════════════════════════");
        System.out.println();
        System.out.println("|--- { VICTORY! } ---|");
        System.out.println("Your " + player.getPet() + " wins with " + player.getHealth() + " HP remaining!");
        System.out.println();

         // Award EXP based on enemy difficulty
        int expGained = calculateExpReward(enemy);
        player.addExp(expGained);
    }
    
    // Calculate EXP reward based on enemy stats
    private static int calculateExpReward(Mob enemy) {
        // Base EXP is related to enemy's power
        int baseExp = (enemy.getHealth() / 2) + (enemy.getPetDamage() * 2);
        return baseExp;
    }
    
    // Method to show defeat message
    public static void showDefeat(Player player, Mob enemy) {
        System.out.println();
        System.out.println("════════════════════════════════");
        System.out.println("        FIGHT RESULTS");
        System.out.println("════════════════════════════════");
        System.out.println();
        System.out.println("|--- { DEFEAT! } ---|");
        System.out.println("Your " + player.getPet() + " was defeated!");
        System.out.println("The " + enemy.getPet() + " had " + enemy.getHealth() + " HP remaining.");
        System.out.println();
    }
}