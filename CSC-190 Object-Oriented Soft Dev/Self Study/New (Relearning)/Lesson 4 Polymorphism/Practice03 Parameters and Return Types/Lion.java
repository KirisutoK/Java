public class Lion extends  Mammal{
    //=======VARIABLES=======//
    private int PrideSize;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Lion(String Name, int Age, String Species, String FurColor, int PrideSize) {
        super(Name, Age, Species, FurColor);
        this.PrideSize = PrideSize;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void hunt() {
        System.out.println(Name+" is hunting");
    }

    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println("ROAR! "+Name+" the lion roars");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Pride Size: " + PrideSize);
    }
}
