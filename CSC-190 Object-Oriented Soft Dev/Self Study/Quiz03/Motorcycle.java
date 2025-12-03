public class Motorcycle extends Vehicle {
    private boolean hasSidecar = false;

    public Motorcycle(String brand, int year, double price, boolean hasSidecar) {
        super(brand, year, price);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSidecar);
        System.out.println("Type: Motorcycle");
    }

    public void wheelie() {
        System.out.println("doing a wheelie!");
    }
}