public class Elephant extends Mammal {
    //=======VARIABLES=======//
    private double TrunkLength; // In Meters

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Elephant(String Name, int Age, String Gender, String FurColor, double TrunkLength) {
        super(Name, Age, Gender, FurColor);
        this.TrunkLength = TrunkLength;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void spray() {
        System.out.println(Name + " sprays water with it's trunk");
    }

    //@OVERRIDE
    public void makeSound() {
        System.out.println("TRUMPET!"+Name+" the elephant trumpets");
    }
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Trunk Length: " + TrunkLength);
    }
}
