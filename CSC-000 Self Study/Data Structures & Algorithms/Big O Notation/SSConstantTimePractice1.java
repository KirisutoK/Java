
public class SSConstantTimePractice1 {

    static String[] Students = new String[500000]; // static makes the code globally acceccisble throughout the whole code
    public static void main(String[] args) {

        //=========Array Values=======\\
        Students[0] = "John";
        Students[500] = "Midoriya";
        Students[999] = "Lastima"; // Creating a 1000 array means from 0-999 (Always starts from 0)

        //=========Method Initatiors=======\\
        BigONotationOperations();
        
    }

    //=================GETTERS=================\\

    public static String getFirstStudent(String[] Students) {
        return Students[0];
    }
    
    public static String getMiddleStudent(String[] Students) {
        return Students[500];
    }

    public static String getLastStudent(String[] Students) {
        return Students[999];
    }


    //=================BIG-O NOTATION=================\\

    

    public static void BigONotationOperations() {

        double StartTime = System.nanoTime();
        System.out.println("(IGNORE THIS ABOVE (REFRESH TIME MEASUREMENT)");
        double EndTime = System.nanoTime();
        double Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);

        System.out.println(" "); // Empty Space (creates more readability)

        StartTime = System.nanoTime();
        System.out.println(getFirstStudent(Students));
        EndTime = System.nanoTime();
        Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);

        System.out.println(" "); // Empty Space (creates more readability)

        StartTime = System.nanoTime();
        System.out.println(getMiddleStudent(Students));
        EndTime = System.nanoTime();
        Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);

        System.out.println(" "); // Empty Space (creates more readability)

        StartTime = System.nanoTime();
        System.out.println(getLastStudent(Students));
        EndTime = System.nanoTime();
        Duration = EndTime - StartTime;
        System.out.println("Duration: " + Duration);
    }
}   