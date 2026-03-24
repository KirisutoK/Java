public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS or INSTANCES
        Car Car01 = new Car("Buick", "Encore", 2015, 16000, 4);
        ElectricCar ElectricCar01 = new ElectricCar("Tesla", "ElonMusk67", 2022, 160000, 4, 100, 10000);
        Motorcycle Motorcycle01 = new Motorcycle("Chevot", "UYYPH", 2000, 16000, true);
        Truck Truck01 = new Truck("Lowes", "America", 1985, 57000, 100);

        // START ENGINE METHOD
        Car01.StartEngine();
        ElectricCar01.StartEngine();
        Motorcycle01.StartEngine();
        Truck01.StartEngine();
        System.out.println(" "); // Space for Readability

        // HONK METHOD

        // DISPLAY INFO METHODS
        Car01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        ElectricCar01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Motorcycle01.DisplayInfo();
        System.out.println(" "); // Space for Readability
        Truck01.DisplayInfo();
        System.out.println(" "); // Space for Readability

        // GET VEHICLE AGE METHOD (PARENT)
        System.out.println(Car01.getVehicleAge());
        System.out.println(ElectricCar01.getVehicleAge());
        System.out.println(Motorcycle01.getVehicleAge());
        System.out.println(Truck01.getVehicleAge());

        // CHILDREN'S METHODS
        Car01.Honk();
        ElectricCar01.Honk();
        ElectricCar01.Charge();
        Truck01.LoadCargo();
        Truck01.UnloadCargo();
        Motorcycle01.Wheelie();
    }
}
