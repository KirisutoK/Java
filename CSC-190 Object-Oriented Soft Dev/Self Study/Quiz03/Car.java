public class Car extends Vehicle {
    private int numberOfDoors = 0;

    public Car(String brand, int year, double price, int numberOfDoors) {
        super(brand, year, price);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Type: Car");
    }

    public void openTrunk() {
        System.out.println("Trunk is opening...");
    }
}
