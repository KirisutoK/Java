public class Mammal extends Animal {
    //=======VARIABLES=======//
    protected String FurColor;

    //=======CONSTRUCTOR=======// NOTE: TO USE THIS FILE, WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Mammal(String Name, int Age, String Species, String FurColor) {
        super(Name, Age, Species);
        this.FurColor = FurColor;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println(Name+" makes a mammal sound");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Fur Color: " + FurColor);
    }
}
