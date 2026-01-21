public class Animal {
    //=======VARIABLES=======//
    protected String Name;
    protected int Age;
    protected String Species;
    protected String HealthStatus;

    //=======CONSTRUCTOR=======// NOTE: TO USE THIS FILE, WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Animal(String Name, int Age, String Species) {
        this.Name = Name;
        this.Age = Age;
        this.Species = Species;
        HealthStatus = "Healthy"; // Healthy is the default
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getHealthStatus() {
        return HealthStatus;
    }
    public String getName() {
        return Name;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS TO MEET THE DESIRED RESULTS
    public void makeSound() {
        System.out.println("Some animal sound");
    }
    public void eat(String food) {
        System.out.println(Name + " is eating " + food);
    }
    public void DisplayInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("Species: " + Species);
        System.out.println("Health Status: " + HealthStatus);
    }
}
