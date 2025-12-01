// PARENT CLASS (Superclass)
class Animal {
    // Protected allows child classes to access these
    protected String name;
    protected int age;
    
    // Parent constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Methods all animals share
    public void eat() {
        System.out.println(name + " is eating...");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }
    
    public void makeSound() {
        System.out.println(name + " makes a sound");
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}