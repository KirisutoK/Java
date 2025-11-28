public class Player {
    private String UserName = " ";
    private int Health = 100;
    private String Pet = " ";
    private int PetDamage = 0;

    public Player(String n, int h, String w, int wdmg) {
        this.UserName = n;
        this.Health = h;
        this.Pet = w;
        this.PetDamage = wdmg;
    }

    //=================Setters and Getters=================\\
    public void setUserName(String name) { 
        this.UserName = name;
    }
    public void setHealth(int health) {
        this.Health += health;
    }
    public void setPet(String Pet) {
        this.Pet = Pet;
    }
    public void setPetDamage(int PetDamage) {
        this.PetDamage += PetDamage;
    }
    public void setAll(int health, String Pet, int PetDamage) {
        this.Health += health;
        this.Pet = Pet;
        this.PetDamage += PetDamage;
    }


    public String getUserName() {
        return UserName;
    }
    public int getHealth() {
        return Health;
    }
    public String getPet() {
        return Pet;
    }
    public int getPetDamage() {
        return PetDamage;
    }

    //=================Other Methods=================\\
}

