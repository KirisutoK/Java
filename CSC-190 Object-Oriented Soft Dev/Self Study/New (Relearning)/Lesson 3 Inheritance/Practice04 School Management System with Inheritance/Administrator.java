public class Administrator extends Person {
    //=======VARIABLES=======//
    private static int TotalAdmins = 0;

    private String Position;
    private String OfficeNumber;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Administrator(String Name, int Age, String ID, String Position, String OfficeNumber) {
        super(Name, Age, ID);
        this.Position = Position;
        this.OfficeNumber = OfficeNumber;
        TotalAdmins++;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void handleAdminWork() {
        System.out.println(Position + " " + Name + " is handling administrative tasks in office " + OfficeNumber);
    }

    // @OVERRIDE
    @Override
    public void Introduce() {
        super.Introduce();
        System.out.println("Im the " + Position);
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Position: " + Position);
        System.out.println("Office Number: " + OfficeNumber);
    }
}
