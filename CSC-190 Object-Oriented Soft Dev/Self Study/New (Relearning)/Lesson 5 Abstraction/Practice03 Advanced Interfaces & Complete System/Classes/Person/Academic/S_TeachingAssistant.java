package Classes.Person.Academic;

// Creation Date: March 01, 2026. at 11:19 AM
// Last Modified: March 08, 2026. at 11:44 PM

import Classes.Course;

public class S_TeachingAssistant
        extends AP_Student {

    //=======VARIABLES=======//
    private double HourlyRate;
    private int HoursPerWeek;
    private Course[] AssistingCourses = new Course[2];
    private int AssistCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public S_TeachingAssistant(String Name, String ID, int Age, String Department, double HourlyRate, int HoursPerWeek) {
        super(Name, ID, Age, Department);
        this.HourlyRate = HourlyRate;
        this.HoursPerWeek = HoursPerWeek;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}


// <======================== YOU LEFT HERE!!!!!