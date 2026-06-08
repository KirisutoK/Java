package Interfaces;

// Creation Date: June 08, 2026. at 12:01 PM
// Last Modified: June 08, 2026. at 12:19 PM

public interface ParentActions { // A Template/Contract that gives requirements for a class
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void callFamilyMeeting(String Location, String Time);
    public void groundChildren(Family.FamilyMember member);
}

// Methods and Interfaces are public by default
