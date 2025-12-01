public class Mob extends Player {
    
    public Mob(String n, int h, String w, int wdmg) {
        super(n, h, w, wdmg);
    }
    
    // Override getAttackMessage for mob-specific attacks
    @Override
    public String getAttackMessage() {
        switch (this.Pet) {
            // Forest Mobs
            case "Wolf":
                String[] wolfAttacks = {"bites", "lunges at", "howls and attacks", "snarls at", "claws at", "pounces on", "snaps jaws at"};
                return wolfAttacks[random.nextInt(wolfAttacks.length)];
            case "Fox":
                String[] foxAttacks = {"bites", "pounces on", "scratches at", "leaps at", "nips at", "yips and lunges at", "darts at"};
                return foxAttacks[random.nextInt(foxAttacks.length)];
            case "Bear":
                String[] bearAttacks = {"swipes at", "mauls", "roars and charges at", "slams into", "claws at", "bites", "tackles"};
                return bearAttacks[random.nextInt(bearAttacks.length)];
            case "Eagle":
                String[] eagleAttacks = {"swoops down on", "claws at", "pecks at", "dive-bombs", "screeches and strikes at", "talons"};
                return eagleAttacks[random.nextInt(eagleAttacks.length)];
            case "Rabbit":
                String[] rabbitAttacks = {"scratches at", "kicks at", "bites", "thumps at", "hops at", "nibbles on"};
                return rabbitAttacks[random.nextInt(rabbitAttacks.length)];
            case "Deer":
                String[] deerAttacks = {"kicks at", "headbutts", "charges at", "stomps on", "bucks at", "antlers strike"};
                return deerAttacks[random.nextInt(deerAttacks.length)];
            case "Raccoon":
                String[] raccoonAttacks = {"scratches at", "bites", "lunges at", "swipes at", "tackles", "chatters and attacks"};
                return raccoonAttacks[random.nextInt(raccoonAttacks.length)];
            default:
                // Use parent class attack message if mob type not found
                return super.getAttackMessage();
        }
    }
}