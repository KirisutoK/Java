// ABSTRACTS ARE RULES TO ITS CHILDREN'S, (IT'S A KEY TERM OF "MUST HAVE")

public abstract class Vehicle {
    //=======VARIABLES=======//
    protected String VehicleID;
    protected String Brand;
    protected String Model;
    protected double DailyRate;
    protected boolean isRented = false;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Vehicle(String VehicleID, String Brand, String Model, double DailyRate) {
        this.VehicleID = VehicleID;
        this.Brand = Brand;
        this.Model = Model;
        this.DailyRate = DailyRate;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getVehicleID() {
        return VehicleID;
    }
    public String getBrand() {
        return Brand;
    }
    public String getModel() {
        return Model;
    }
    public double getDailyRate() {
        return DailyRate;
    }


    // ABSTRACT
    public abstract double calculateRentalCost(int day);

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void rent() {
        if (isRented == true) {
            System.out.println("Vehicle is already rented!");
        } else {
            isRented = true;
            System.out.println("Vehicle has been rented");
        }
    }
    public void returnVehicle() {
        if (isRented == false) {
            System.out.println("Vehicle is not rented!");
        } else {
            isRented = false;
            System.out.println("Vehicle has been returned");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public void DisplayDetails() {
        System.out.println("Vehicle ID: "+VehicleID);
        System.out.println("Brand: "+Brand);
        System.out.println("Model: "+Model);
        System.out.println("Daily Rate: $"+DailyRate);
        System.out.println("Rented: "+isRented);
    }
}
