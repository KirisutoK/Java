// CHILD CLASS 2: Cat inherits from Animal
class Cat extends Animal {
    private String furColor;
    
    public Cat(String name, int age, String furColor) {
        super(name, age);  // Call parent constructor
        this.furColor = furColor;
    }
    
    // Override parent method with cat-specific behavior
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
    
    // Cat's own unique method
    public void scratch() {
        System.out.println(name + " is scratching the furniture!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fur Color: " + furColor);
        System.out.println("Type: Cat");
    }
}