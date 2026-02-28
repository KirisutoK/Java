package Classes.Person;

// Creation Date: February 27, 2026. at 9:12 PM
// Last Modified: February 28, 2026. at 11:09 AM

// ABSTRACTS ARE RULES TO ITS CHILDREN'S, (IT'S A KEY TERM OF "MUST HAVE")
public abstract class Person { // this is a normal person (Broad Category)
    //=======VARIABLES=======//
    protected String Name;
    protected String ID;
    protected int Age;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Person(String Name, String ID, int Age) {
        this.Name = Name;
        this.ID = ID;
        this.Age = Age;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    abstract String getRole(); // its children's must have this method

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Name: "+Name);
        System.out.println("ID: "+ID);
        System.out.println("Age: "+Age);
    }
}
