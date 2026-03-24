public class SmartFan
        extends SmartDevice
        implements Controllable {

    //=======VARIABLES=======//
    private boolean isOn;
    private int Speed;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SmartFan(String DeviceName, String Location) {
        super(DeviceName, Location);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    // --- @OVERRIDE ---
    @Override public String getDeviceType() {
        return "Smart Fan";
    }
    // CONTROLLABLE <==== [INTERFACE]
    @Override public boolean isOn() {
        return true;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setSpeed(int Speed) { // 1-5 range
        if (Speed <= 5 && Speed > 0) {
            this.Speed = Speed;
        } else {
            System.out.println("Speed is out of range.");
        }
    }
    // --- @OVERRIDE ---
    // CONTROLLABLE <==== [INTERFACE]
    @Override public void turnOn() {
        if (isOn) { // if isOn == true
            System.out.println(DeviceName+" has already been turned on.");
        } else {
            isOn = true;
            System.out.println(DeviceName+" has been turned on.");
        }
    }
    @Override public void turnOff() {
        if (!isOn) { //if isOn == false
            System.out.println(DeviceName+" is off");
        } else {
            isOn = false;
            System.out.println(DeviceName+" has been turned off");
        }
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // --- @OVERRIDE ---
    @Override public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Is On: "+isOn);
        System.out.println("Speed: "+Speed);
    }
}
