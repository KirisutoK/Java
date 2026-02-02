public class Motorcycle extends Vehicle {
    //=======VARIABLES=======//
    private int EngineSize;


    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Motorcycle(String VehicleID, String Brand, String Model, double DailyRate, int EngineSize) {
        super(VehicleID, Brand, Model, DailyRate);
        this.EngineSize = EngineSize;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // @OVERRIDE
    @Override
    public double calculateRentalCost(int day) {
        return (DailyRate * day) * 0.8; // 20% Discount for motorcycles
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("Engine Size: " + EngineSize);
    }
}
