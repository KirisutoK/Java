package Interfaces;
import Classes.Course;

// Creation Date: February 27, 2026. at 9:05 PM
// Last Modified: September 22, 2026. at 12:22 PM

public interface Enrollable { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    int getEnrolledCount();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void enroll(Course course);
    void drop(Course course);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// ReuseableMethodsCLI and Interface is static by default
