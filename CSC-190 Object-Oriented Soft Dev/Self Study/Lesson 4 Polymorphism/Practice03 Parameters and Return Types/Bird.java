public class Bird extends Animal {
    //=======VARIABLES=======//
    protected double WingSpan; // in Meters

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Bird(String Name, int Age, String Species, double WingSpan) {
        super(Name, Age, Species);
        this.WingSpan = WingSpan;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println(Name+" chirps");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Wing Span: " + WingSpan);
    }
}
