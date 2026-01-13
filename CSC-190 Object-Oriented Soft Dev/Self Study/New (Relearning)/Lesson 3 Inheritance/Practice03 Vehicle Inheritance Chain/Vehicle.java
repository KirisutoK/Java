public class Vehicle {
    //=======VARIABLES=======//
    protected String Brand;
    protected String Model;
    protected int Year;
    protected double Price;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Vehicle(String Brand, String Model, int Year, double Price) {
        this.Brand = Brand;
        this.Model = Model;
        this.Year = Year;
        this.Price = Price;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getVehicleAge() {
        return 2026 - Year;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void StartEngine() {
        System.out.println("Vehicle engine started");
    }
    public void DisplayInfo() {
        System.out.println("Brand: " + Brand);
        System.out.println("Model: " + Model);
        System.out.println("Year: " + Year);
        System.out.println("Price: " + Price);
    }
}
