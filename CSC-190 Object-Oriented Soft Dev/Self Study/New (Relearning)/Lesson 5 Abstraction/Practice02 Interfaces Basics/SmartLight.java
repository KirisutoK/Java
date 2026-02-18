public class SmartLight
        extends SmartDevice
        implements Controllable, Programmable, Dimmable  {

    //=======VARIABLES=======//
    private boolean isOn;
    private int Brightness;
    private String Schedule;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES/OBJECTS FROM OTHER FILES
    public SmartLight(String DeviceName, String Location) {
        super(DeviceName, Location);
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES


    // --- @OVERRIDE ---
    @Override
    public String getDeviceType() {
        return "Smart Light";
    }

    // CONTROLABLE <===== [INTERFACE]
    @Override
    public boolean isOn() {
        return isOn;
    }

    // PROGRAMMABLE <===== [INTERFACE]
    @Override
    public String getSchedule() {
        return Schedule;
    }

    // DIMMABLE <===== [INTERFACE]
    @Override
    public int getBrightness() {
        return Brightness;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE


    // CONTROLABLE <===== [INTERFACE]
    @Override
    public void turnOn() {
        if (isOn == true) {
            System.out.println(DeviceName+" has already been turned on.");
        } else {
            isOn = true;
            System.out.println(DeviceName+" has been turned on.");
        }
    }
    @Override
    public void turnOff() {
        if (isOn == false) {
            System.out.println(DeviceName+" is off");
        } else {
            isOn = false;
            System.out.println(DeviceName+" has been turned off");
        }
    }

    // PROGRAMMABLE <===== [INTERFACE]
    @Override
    public void setSchedule(String Schedule) {
        this.Schedule = Schedule;
    }

    // DIMMABLE <===== [INTERFACE]
    @Override
    public void setBrightness(int Brightness) {
        this.Brightness = Brightness;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    // @OVERRIDE
    @Override
    public void DisplayInformation() {
        super.DisplayInformation();
        System.out.println("Is On: "+isOn);
        System.out.println("Brightness: "+Brightness);
        System.out.println("Schedule: "+Schedule);
    }
}
