public class Player {
    private String name;
    private int health;
    private int damage;

    public Player(String n, int h, int d) {
        this.name = n;
        this.health = h;
        this.damage = d;
    }

    //=================SETTERS & GETTERS================\\

    public String getName(String n) {
        name = n;
        return name;
    }


    //===================VOID==================\\
    public void displayUserStats() {
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