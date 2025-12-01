// CHILD CLASS 1: Dog inherits from Animal
class Dog extends Animal {
    // Dog has its own unique attribute
    private String breed;
    
    // Dog constructor
    public Dog(String name, int age, String breed) {
        super(name, age);  // Call parent constructor first!
        this.breed = breed;
    }
    
    // Override parent method with dog-specific behavior
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
    
    // Dog's own unique method
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
    // Override displayInfo to include breed
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent's displayInfo
        System.out.println("Breed: " + breed);
        System.out.println("Type: Dog");
    }
}
