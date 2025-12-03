public class Main { // Inheritance
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 2020, 25000.0, 4); // Brand, Year, Price, Number of Doors
        Motorcycle myMotorcycle = new Motorcycle("Harley-Davidson", 2019, 15000.0, true); // Brand, Year, Price, Has Sidecar

        myCar.displayInfo();
        myCar.startEngine();
        myCar.openTrunk();

        System.out.println();

        myMotorcycle.displayInfo();
        myMotorcycle.startEngine();
        myMotorcycle.wheelie();
    }
}
