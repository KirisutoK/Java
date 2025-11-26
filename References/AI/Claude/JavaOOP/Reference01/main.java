public class main {
    public static void main(String[] args) {
        // Creating OBJECTS from the Dog class
        Dog dog1 = new Dog("Buddy", "Golden Retriever", 3);
        Dog dog2 = new Dog("Max", "German Shepherd", 5);
        
        // Using the objects
        dog1.displayInfo();
        dog1.bark();
        
        System.out.println(); // Empty line for spacing
        
        dog2.displayInfo();
        dog2.bark();
    }
}