public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS or INSTANCES
        Dog Solo = new Dog("Solo", 5, "Askal");
        Cat Princess = new Cat("Princess", 3, "Black");
        Bird Bird0 = new Bird("Brazil", 3, true);
        Bird Bird1 = new Bird("Pengu", 5, false);

        // PARENT METHODS
        Solo.makeSound();
        Princess.makeSound();
        Bird0.makeSound();
        Bird1.makeSound();
        System.out.println(" "); // Space for Readability

        Solo.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Princess.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Bird0.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Bird1.DisplayInfo();
        System.out.println(" "); // Space for Readability

        // CHILDREN METHODS
        Solo.Fetch();
        Princess.Scratch();
        Bird0.Fly();
        Bird1.Fly();




    }
}
