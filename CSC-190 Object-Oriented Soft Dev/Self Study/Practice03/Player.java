public class Player {
    private String name;
    private int health;
    private int damage;

    public Player(String n, int h, int d) {
        this.name = n;
        this.health = h;
        this.damage = d;
    }

    //=================RETURNS================\\
    public String setName(String n) {
        name = n;
    }

    //===================VOID==================\\
    public static void displayUserStats() {
        System.out.println("Username: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
    }
    public static void displayDeathMessage(int RandomNumber) {
        String[] DeathMessages = {
            "Fuck you",
            "Stupid",
            "I'll get revenge!",
            "I hate you",
            "MOTHERFUCKER!!"
        };

        System.out.println(DeathMessages[RandomNumber]);        
    }
}