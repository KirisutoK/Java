public class SmartCamera
        extends SmartDevice
        implements Controllable, Programmable {

    //=======VARIABLES=======//
    private boolean isOn;
    private boolean isRecording;
    private String Schedule;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SmartCamera(String DeviceName, String Location) {
        super(DeviceName, Location);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    // --- @OVERRIDE ---
    @Override public String getDeviceType() {
        return "Smart Camera";
    }
    // CONTROLLABLE <==== [INTERFACE]
    @Override public boolean isOn() {
        return true;
    }
    // PROGRAMMABLE <===== [INTERFACE]
    @Override public String getSchedule() {
        return Schedule;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void startRecording() {
        if (isOn) {
            isRecording = true;
            System.out.println("Camera has started recording");
        } else {
            System.out.println("Camera is off");
        }
    }
    public void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println("Camera has stopped recording");
        } else {
            System.out.println("Camera is not recording");
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
    // PROGRAMMABLE <===== [INTERFACE]
    @Override public void setSchedule(String Schedule) {
        this.Schedule = Schedule;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    @Override public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Is On: "+isOn);
        System.out.println("Is Recording: "+isRecording);
        System.out.println("Schedule: "+Schedule);
    }
}
