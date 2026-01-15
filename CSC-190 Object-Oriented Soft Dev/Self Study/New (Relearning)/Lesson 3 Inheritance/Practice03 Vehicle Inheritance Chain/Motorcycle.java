public class Motorcycle extends Vehicle {
    //=======VARIABLES=======//
    private boolean HasHelmet;
    private final int MaxSpeed = 200; // final means the value will not be changed no matter what

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Motorcycle(String Brand, String Model, int Year, double Price, boolean HasHelmet) {
        super(Brand, Model, Year, Price);
        this.HasHelmet = HasHelmet;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Wheelie() {
        if (HasHelmet) {
            System.out.println("Doing a wheelie safely!");
        } else {
            System.out.println("Put on a helmet first!");
        }
    }

    // @OVERRIDE
    @Override
    public void StartEngine() {
        System.out.println("Motorcycle engine started with a vroom");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Has Helmet: " + HasHelmet);
        System.out.println("Max Speed: " + MaxSpeed);
    }
}
