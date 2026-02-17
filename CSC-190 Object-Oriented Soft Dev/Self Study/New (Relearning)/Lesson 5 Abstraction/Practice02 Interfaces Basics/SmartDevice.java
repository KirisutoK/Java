public abstract class SmartDevice { // ABSTRACTS ARE RULES TO ITS CHILDREN'S, (IT'S A KEY TERM OF "MUST HAVE")
    //=======VARIABLES=======//
    protected String DeviceName;
    protected String Location;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SmartDevice(String DeviceName, String Location) {
        this.DeviceName = DeviceName;
        this.Location = Location;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public abstract String getDeviceName();

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void DisplayInformation() {
        System.out.println("Device Name: "+DeviceName);
        System.out.println("Location: "+Location);
    }
}
