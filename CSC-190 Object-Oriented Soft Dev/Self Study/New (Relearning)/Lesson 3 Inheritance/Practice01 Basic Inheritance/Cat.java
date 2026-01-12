public class Cat extends Animal{
    //=======VARIABLES=======//
    private String Color;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Cat(String Name, int Age, String  Color) {
        super(Name, Age, "Cat");
        this.Color = Color;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Scratch() {
        System.out.println(Name + " Is scratching the furniture!");
    }
    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Color: " + Color);
    }
}
