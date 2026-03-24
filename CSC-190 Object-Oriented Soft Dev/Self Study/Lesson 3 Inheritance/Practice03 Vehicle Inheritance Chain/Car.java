public class Car extends Vehicle{
    //=======VARIABLES=======//
    private int NumberOfDoors;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Car(String Brand, String Model, int Year, double Price, int NumberOfDoors) {
        super(Brand, Model, Year, Price);
        this.NumberOfDoors = NumberOfDoors;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Honk() {
        System.out.println("Honk! Honk!");
    }

    // @OVERRIDE
    @Override
    public void StartEngine() {
        System.out.println("Car engine started with a roar");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Number of Doors: " + NumberOfDoors);
    }
}
