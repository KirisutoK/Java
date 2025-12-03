// This is the CLASS - the blueprint for all dogs
class Dog {
    // ATTRIBUTES (properties/characteristics of a dog)
    String name;
    String breed;
    int age;
    
    // CONSTRUCTOR - special method to create a dog object
    public Dog(String name, String breed, int age) {
        this.name = name;      // 'this' refers to the current object
        this.breed = breed;
        this.age = age;
    }
    
    // METHODS (actions/behaviors a dog can do)
    public void bark() {
        System.out.println(name + " says: Woof! Woof!");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age + " years old");
    }
}