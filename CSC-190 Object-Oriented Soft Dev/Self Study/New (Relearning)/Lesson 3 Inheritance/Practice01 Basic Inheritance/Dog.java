public class Dog extends Animal {
    //=======VARIABLES=======//
    private String Breed;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Dog(String Name, int Age, String Breed) {
        super(Name, Age, "Dog");
        this.Breed = Breed;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Fetch() {
        System.out.println( Name + " is fetching the ball!");
    }
    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Breed: " + Breed);
    }
}
