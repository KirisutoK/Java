public class Main {
    public static void main(String[] args) {
        // Create different animals
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, "Orange");
        Bird bird = new Bird("Tweety", 1, 0.3);
        
        System.out.println("=== DOG ===");
        dog.displayInfo();
        dog.eat();        // Inherited from Animal
        dog.makeSound();  // Overridden in Dog
        dog.fetch();      // Unique to Dog
        System.out.println();
        
        System.out.println("=== CAT ===");
        cat.displayInfo();
        cat.sleep();      // Inherited from Animal
        cat.makeSound();  // Overridden in Cat
        cat.scratch();    // Unique to Cat
        System.out.println();
        
        System.out.println("=== BIRD ===");
        bird.displayInfo();
        bird.eat();       // Inherited from Animal
        bird.makeSound(); // Overridden in Bird
        bird.fly();       // Unique to Bird
    }
}