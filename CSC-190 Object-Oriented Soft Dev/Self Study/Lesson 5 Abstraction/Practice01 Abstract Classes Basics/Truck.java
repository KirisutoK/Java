public class Truck extends Vehicle{
    //=======VARIABLES=======//
    private double CargoCapacity;
    private boolean RequiresCommercialLicense;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Truck(String VehicleID, String Brand, String Model, double DailyRate, double CargoCapacity, boolean RequiresCommercialLicense) {
        super(VehicleID, Brand, Model, DailyRate);
        this.CargoCapacity = CargoCapacity;
        this.RequiresCommercialLicense = RequiresCommercialLicense;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // @OVERRIDE
    @Override
    public double calculateRentalCost(int day) {
        return (DailyRate * day) + (CargoCapacity * 10 * day); // extra charge based on cargo capacity
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("Cargo Capacity: "+CargoCapacity);
        System.out.println("Requires Commercial License: "+RequiresCommercialLicense);
    }
}
