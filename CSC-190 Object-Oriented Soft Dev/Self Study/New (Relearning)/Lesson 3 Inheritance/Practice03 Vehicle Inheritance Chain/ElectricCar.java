public class ElectricCar extends Car {
    //=======VARIABLES=======//
    private double BatteryCapacity; // in kWH
    private int Range; // in Miles

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ElectricCar(String Brand, String Model, int Year, double Price, int NumberOfDoors, double BatteryCapacity, int Range) {
        super(Brand, Model, Year, Price, NumberOfDoors);
        this.BatteryCapacity = BatteryCapacity;
        this.Range = Range;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Charge() {
        System.out.println(Brand + " " + Model + " is charging. Battery capacity: " + BatteryCapacity + "kWH.");
    }

    // @OVERRIDE
    @Override
    public void StartEngine() {
        System.out.println("Electric car started silently");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Battery Capacity: " + BatteryCapacity);
        System.out.println("Range: " + Range);
    }
}
