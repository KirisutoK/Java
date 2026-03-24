public class SmartThermostat
        extends SmartDevice
        implements Controllable, Programmable, Adjustable {

    //=======VARIABLES=======//
    private boolean isOn;
    private int Temperature;
    private String Schedule;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public SmartThermostat(String DeviceName, String Location) {
        super(DeviceName, Location);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    // --- @OVERRIDE ---
    @Override public String getDeviceType() {
        return "Smart Thermostat";
    }
    // CONTROLLABLE <==== [INTERFACE]
    @Override public boolean isOn() {
        return true;
    }
    // PROGRAMMABLE <===== [INTERFACE]
    @Override public String getSchedule() {
        return Schedule;
    }
    // ADJUSTABLE <==== [INTERFACE]
    @Override public int getTemperature() {
        return Temperature;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
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
    // ADJUSTABLE <==== [INTERFACE]
    @Override public void setTemperature(int Temperature) {
        this.Temperature = Temperature;
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    // --- @OVERRIDE ---
    @Override public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Is On: "+isOn);
        System.out.println("Temperature: "+Temperature);
        System.out.println("Schedule: "+Schedule);
    }
}