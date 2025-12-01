import java.util.Random;

public class Player {
    static Random random = new Random();

    protected String UserName = " ";
    protected int Health = 0;
    protected String Pet = " ";
    protected int PetDamage = 0;

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

    public String getAttackMessage() {
        switch (this.Pet) {
            case "Cat":
                String[] catAttacks = {"scratched at", "pounces on", "swipes at", "lunges at", "claws", "bites", "hisses at"};
                return catAttacks[random.nextInt(catAttacks.length)];
            case "Dog":
                String[] dogAttacks = {"bites", "lunges at", "nips at", "pounces on", "snaps at", "growls at", "chews on"};
                return dogAttacks[random.nextInt(dogAttacks.length)];
            case "Squirrel":
                String[] squirrelAttacks = {"scratches at", "bites", "nibbles on", "lunges at", "pounces on", "chomps at", "scurries towards", "throws a nut at", "pees on"};
                return squirrelAttacks[random.nextInt(squirrelAttacks.length)];
            case "Crow":
                String[] crowAttacks = {"pecks at", "swoops down on", "scratches with its claws at", "lunges at", "caws at", "flaps wings at", "stabs with beak at"};
                return crowAttacks[random.nextInt(crowAttacks.length)];
            case "Hamster":
                String[] hamsterAttacks = {"nibbles on", "squeaks at", "rolls into", "wiggles nose at", "scurries at", "scratches weakly at"};
                return hamsterAttacks[random.nextInt(hamsterAttacks.length)];
            case "Cow":
                String[] cowAttacks = {"butts", "kicks", "tramples", "headbutts", "moos loudly at", "charges at", "rams"};
                return cowAttacks[random.nextInt(cowAttacks.length)];
            case "Pig":
                String[] pigAttacks = {"rams", "bites", "charges at", "squeals and tackles", "headbutts", "tusks at", "snorts at"};
                return pigAttacks[random.nextInt(pigAttacks.length)];
            case "Chicken":
                String[] chickenAttacks = {"clucks at", "pecks furiously at", "scratches with talons at", "flaps wings at", "charges at", "squawks at"};
                return chickenAttacks[random.nextInt(chickenAttacks.length)];
            case "Goat":
                String[] goatAttacks = {"headbutts", "rams", "kicks", "charges with horns at", "bleats and strikes at", "butts"};
                return goatAttacks[random.nextInt(goatAttacks.length)];
            case "Horse":
                String[] horseAttacks = {"kicks", "tramples", "bites", "rears and strikes at", "charges at", "bucks at", "neighs and stomps on"};
                return horseAttacks[random.nextInt(horseAttacks.length)];
            case "Tyrannosaurus Rex":
                String[] trexAttacks = {"chomps on", "tail-whips", "stomps on", "roars and bites", "crushes with jaws", "slams into"};
                return trexAttacks[random.nextInt(trexAttacks.length)];
            default:
                String[] defaultAttacks = {"attacks", "strikes at", "hits", "charges at", "lunges at"};
                return defaultAttacks[random.nextInt(defaultAttacks.length)];
        }
    }
}

