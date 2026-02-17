public class SmartLight extends SmartDevice implements Controllable, Programmable, Dimmable, Adjustable  {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SmartLight(String DeviceName, String Location) {
        super(DeviceName, Location);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // @OVERRIDE
    @Override
    public String getDeviceName() {
        return DeviceName;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}


/// YOU LEFT ON CREATING THE MTHODS FOR INTERFACES