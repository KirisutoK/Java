public class Car extends Vehicle {
    //=======VARIABLES=======//
    private int NumOfDoors;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Car(String VehicleID, String Brand, String Model, double DailyRate, int NumOfDoors) {
        super(VehicleID, Brand, Model, DailyRate);
        this.NumOfDoors = NumOfDoors;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // @OVERRIDE
    @Override
    public double calculateRentalCost(int day) {
        return DailyRate * day;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void DisplayDetails() {
        super.DisplayDetails();
        System.out.println("Number of Doors: "+NumOfDoors);
    }
}
