public class Main {
    public static void main(String[] args) {
        // CREATING INSTANCES/OBJECTS
        SmartLight SLight01 = new SmartLight("Smart Light 01", "Front Door");
        SmartLight SLight02 = new SmartLight("Smart Light 02", "Kitchen");
        SmartThermostat SThermostat01 = new SmartThermostat("Smart Thermostat 01", "Living Room");
        SmartFan SFan01 = new SmartFan("Smart Fan 01", "Bedroom");
        SmartCamera SCamera01 = new SmartCamera("Smart Camera 01", "Front Door");
        SmartCamera SCamera02 = new SmartCamera("Smart Camera 02", "Back Door");

        SmartDevice[] SmartDevices = {SLight01, SLight02, SThermostat01, SFan01, SCamera01, SCamera02};

        // DISPLAY INFORMATION
        System.out.println("================== DISPLAY ==================");
        for (SmartDevice i:SmartDevices) {
            i.DisplayInformation();
            System.out.println(" "); // Space for Readability
        }

        // CONTROLLABLE INTERFACES (Turn on all SmartDevices using instanceOf)
        System.out.println("================== CONTROLLABLE INTERFACES (TURNING ON ALL DEVICES) ==================");
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Controllable) {
                ((Controllable) i).turnOn(); // changes the object type from SmartDevice into Controllable
                ((Controllable) i).turnOn();
            }
        } // Upcasting
        // Turning off
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Controllable) {
                ((Controllable) i).turnOff(); // changes the object type from SmartDevice into Controllable
                ((Controllable) i).turnOff();
            }
        } // Upcasting
        // Turning on
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Controllable) {
                ((Controllable) i).turnOn(); // changes the object type from SmartDevice into Controllable
                ((Controllable) i).turnOn();
            }
        } // Upcasting
        System.out.println(" "); // Space for Readability

        // PROGRAMMABLE INTERFACES (Set Schedule for all to be "6:00 AM - 10:00 PM" using instanceOf)
        System.out.println("================== PROGRAMMABLE INTERFACES (SETTING UP SCHEDULE) ==================");
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Programmable) {
                ((Programmable)i).setSchedule("6:00AM - 10:00PM");
            }
        }
        // DISPLAY SCHEDULES (PROGRAMMABLE)
        System.out.println("================== DISPLAY SCHEDULES [PROGRAMMABLE] ==================");
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Programmable) {
                System.out.println(i.getDeviceType()+" Schedule: "+((Programmable)i).getSchedule()); // too lazy to add getters for device name
            }
        }
        System.out.println(" "); // Space for Readability

        // DIMMABLE INTERFACES
        // <================================================== YOU LEFT HERE!!!!!!!!!!!!!!
    }
}
