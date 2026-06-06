// Creation Date: June 05, 2026. at 9:23 PM
// Last Modified: June 05, 2026. at  9:27 PM

public interface Notifiable { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    String getType();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    void sendNotification(String message);

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}

// Methods and Interfaces are public by default
