public class Player {
    private String UserName = " ";
    private int Health = 100;
    private String Weapon = " ";
    private int WeaponDamage = 0;

    public Player(String n, int h, String w, int wdmg) {
        this.UserName = n;
        this.Health = h;
        this.Weapon = w;
        this.WeaponDamage = wdmg;
    }

    //=================Setters and Getters=================\\
    public void setUserName(String name) { 
        this.UserName = name;
    }
    public void setHealth(int health) {
        this.Health += health;
    }
    public void setWeapon(String weapon) {
        this.Weapon = weapon;
    }
    public void setWeaponDamage(int weaponDamage) {
        this.WeaponDamage += weaponDamage;
    }
    public void setAll(int health, String weapon, int weaponDamage) {
        this.Health += health;
        this.Weapon = weapon;
        this.WeaponDamage += weaponDamage;
    }


    public String getUserName() {
        return UserName;
    }
    public int getHealth() {
        return Health;
    }
    public String getWeapon() {
        return Weapon;
    }
    public int getWeaponDamage() {
        return WeaponDamage;
    }

    //=================Other Methods=================\\
}

