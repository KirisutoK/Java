public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS or INSTANCES
        ZooKeeper ZooKeeper01 = new ZooKeeper("Christ");
        Lion Lion01 = new Lion("Savannah", 23, "Lion", "Brown", 35);
        Lion Lion02 = new Lion("Mustafa", 14, "Lion", "Gold", 10);
        Elephant Elephant01 = new Elephant("Mohammad", 16, "Elephant", "Gray", 2);
        Elephant Elephant02 = new Elephant("Mia", 12, "Elephant", "White", 1);
        Parrot Parrot01 = new Parrot("Gerald", 4, "Parrot", 1.3, 20);
        Parrot Parrot02 = new Parrot("Josh", 1, "Parrot", 0.5, 5);
        Bird Bird01 = new Bird("Rio", 13, "Bird", 2);

        Animal[] Animals = {Lion01, Lion02, Elephant01, Elephant02, Parrot01, Parrot02, Bird01};

        // ZOOKEEPER FEED METHOD
        System.out.println("=== ZOOKEEPER FEED METHOD ===");
        for (Animal i: Animals) {
            if (i instanceof Lion) {
                ZooKeeper01.feedAnimal(i, "Meat");
            } else if (i instanceof Elephant) {
                ZooKeeper01.feedAnimal(i, "Nuts");
            } else if (i instanceof Bird) { // Bird is a parent so this also applies to Parrot(Child)
                ZooKeeper01.feedAnimal(i, "Seeds");
            }
        }
        System.out.println(" "); // Space for Readability

        // ZOOKEEPER CHECK HEALTH METHOD
        System.out.println("=== ZOOKEEPER CHECK HEALTH METHOD ===");
        for (Animal i: Animals) {
            ZooKeeper01.checkHealth(i);
            System.out.println(" "); // Space for Readability
        }

        // ZOOKEEPER PLAY WITH ANIMALS METHOD
        System.out.println("=== ZOOKEEPER PLAY WITH ANIMALS METHOD ===");
        for (Animal i: Animals) {
            ZooKeeper01.playWithAnimal(i);
            System.out.println(" "); // Space for Readability
        }

        // ZOOKEEPER POLYMORPHIC RETURN TYPES
        System.out.println("=== ZOOKEEPER POLYMORPHIC RETURN TYPES ===");
        Animal MostActiveAnimal = ZooKeeper01.getMostActiveAnimal(Animals);
        System.out.println("Most Active Animal: "+MostActiveAnimal.getName()+" ("+MostActiveAnimal.Age+") "); // Youngest TBH (IDK WHAT AI IS THINKING)
        System.out.println("Mammals:");
        Mammal[] Mammals = ZooKeeper01.seperateMammals(Animals);
        for (Mammal i: Mammals) {
            System.out.println(">" + i.getName() + " (" + i.Species + ")");
        }
        System.out.println(" "); // Space for Readability

        // MAKE SOUND METHOD
        System.out.println("=== MAKE SOUND METHOD ===");
        for (Animal i: Animals) {
            i.makeSound();
        }
    }
}
