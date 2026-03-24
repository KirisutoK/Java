public class Person {
    //=======VARIABLES=======//
    protected static int TotalPeople = 0;

    protected String Name;
    protected int Age;
    protected String ID;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Person(String Name, int Age, String ID) {
        this.Name = Name;
        this.Age = Age;
        this.ID = ID;
        TotalPeople++;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getTotalPeople() {
        return TotalPeople;
    }
    public boolean isAdult() {
        return Age >= 18; // If Age is greater than 18 then true if not false
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void Introduce() {
        System.out.println("Hi, im " + Name);
    }
    public void DisplayInfo() {
        System.out.println("Name: " + Name);
        System.out.println("Age: " + Age);
        System.out.println("ID: " + ID);
    }
}
