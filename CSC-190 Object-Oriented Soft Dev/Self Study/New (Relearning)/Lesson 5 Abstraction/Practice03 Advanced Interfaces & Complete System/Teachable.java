public interface Teachable { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    int getTeachingLoad(); // Number of courses teaching

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void teach(Course course);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// Methods and Interface is static by default
