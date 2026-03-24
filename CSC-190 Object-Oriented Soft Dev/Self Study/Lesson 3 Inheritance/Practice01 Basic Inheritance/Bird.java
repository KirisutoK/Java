public class Bird extends Animal{
    //=======VARIABLES=======//
    private boolean canFly;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Bird(String Name, int Age, Boolean canFly) {
        super(Name, Age, "Bird");
        this.canFly = canFly;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Fly() {
        if (canFly) { // Checks if canFly is true
            System.out.println(Name + " is Flying");
        } else { // Checks if canFly is false
            System.out.println(Name + " cannot fly");
        }
    }
    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println("Chirp! Chirp!");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Can fly: " + canFly);
    }
}
