// CHILD CLASS 3: Bird inherits from Animal
class Bird extends Animal {
    private double wingspan;
    
    public Bird(String name, int age, double wingspan) {
        super(name, age);
        this.wingspan = wingspan;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }
    
    // Bird's unique method
    public void fly() {
        System.out.println(name + " is flying with a wingspan of " + wingspan + " meters!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Wingspan: " + wingspan + " meters");
        System.out.println("Type: Bird");
    }
}