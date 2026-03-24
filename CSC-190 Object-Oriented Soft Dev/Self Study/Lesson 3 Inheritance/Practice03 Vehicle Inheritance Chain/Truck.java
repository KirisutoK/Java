public final class Truck extends Vehicle {
    //=======VARIABLES=======//
    private double CargoCapacity; // in Tons
    private boolean IsLoaded; // Default: false

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Truck(String Brand, String Model, int Year, double Price, double CargoCapacity) {
        super(Brand, Model, Year, Price);
        this.CargoCapacity = CargoCapacity;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void LoadCargo() {
        if (!IsLoaded) { // if IsLoaded == false
            System.out.println("Cargo Loaded");
            IsLoaded = true;
        } else {
            System.out.println("Cargo is already loaded");
        }
    }

    public void UnloadCargo() {
        if (IsLoaded) { // if IsLoaded == true
            System.out.println("Cargo Unloaded");
            IsLoaded = false;
        } else {
            System.out.println("Cargo is not loaded");
        }
    }



    // @OVERRIDE
    @Override
    public void StartEngine() {
        System.out.println("Truck engine started with a rumble");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Cargo Capacity: " + CargoCapacity);
        System.out.println("Is Loaded: " + IsLoaded);
    }
}
