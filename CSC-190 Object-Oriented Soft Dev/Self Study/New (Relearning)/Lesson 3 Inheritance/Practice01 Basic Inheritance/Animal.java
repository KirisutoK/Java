public class Animal {
    //=======VARIABLES=======//
    protected String Name;
    protected int Age;
    protected String Species;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Animal(String Name, int Age, String Species) {
        this.Name = Name;
        this.Age = Age;
        this.Species = Species;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return Name;
    }
    public int getAge() {
        return Age;
    }
    public String getSpecies() {
        return Species;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
    public void DisplayInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("Species: " + Species);
    }
}
