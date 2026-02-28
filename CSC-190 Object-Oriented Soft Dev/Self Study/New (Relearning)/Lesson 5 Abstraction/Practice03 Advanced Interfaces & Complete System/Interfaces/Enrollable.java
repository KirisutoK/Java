package Interfaces;

// Creation Date: February 27, 2026. at 9:05 PM
// Last Modified: February 27, 2026. at 9:23 PM

public interface Enrollable { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    int getEnrolledCount();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void enroll(Course course);
    void drop(Course course);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// Methods and Interface is static by default
