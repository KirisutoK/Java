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
        System.out.println(" "); // Space for Readability

        // DISPLAY SCHEDULES [PROGRAMMABLE]
        System.out.println("================== DISPLAY SCHEDULES [PROGRAMMABLE] ==================");
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Programmable) {
                System.out.println(i.getDeviceType()+" Schedule: "+((Programmable)i).getSchedule()); // too lazy to add getters for device name
            }
        }
        System.out.println(" "); // Space for Readability

        // DIMMABLE INTERFACES [SETTING UP BRIGHTNESS]
        System.out.println("================== DIMMABLE INTERFACES (SETTING UP BRIGHTNESS) ==================");
        for (SmartDevice i:SmartDevices) { // Setting up Brightness to 5
            if (i instanceof Dimmable) {
                ((Dimmable)i).setBrightness(5);
            }
        }
        System.out.println(" "); // Space for Readability

        // DISPLAY BRIGHTNESS [DIMMABLE]
        System.out.println("================== DISPLAY BRIGHTNESS [DIMMABLE] ==================");
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Dimmable) {
                i.DisplayInformation();
            }
            System.out.println(" "); // Space for Readability
        }
        System.out.println(" "); // Space for Readability

        // ADJUSTABLE INTERFACES [SETTING UP TEMPERATURE]
        System.out.println("================== ADJUSTABLE INTERFACES (SETTING UP TEMPERATURE) ==================");
        for (SmartDevice i:SmartDevices) { // Setting up Brightness to 5
            if (i instanceof Adjustable) {
                ((Adjustable)i).setTemperature(67);
            }
        }
        System.out.println(" "); // Space for Readability

        // DISPLAY TEMPERATURE [ADJUSTABLE]
        System.out.println("================== DISPLAY TEMPERATURE [ADJUSTABLE] ==================");
        for (SmartDevice i:SmartDevices) {
            if (i instanceof Adjustable) {
                i.DisplayInformation();
            }
            System.out.println(" "); // Space for Readability
        }
        System.out.println(" "); // Space for Readability

        // DISPLAY MULTIPLE OBJECTS SHOWING ITS IMPLEMENTS
        System.out.println("================== DISPLAY OBJECTS AND ITS IMPLEMENTATIONS ==================");
        int interfacesCount = 0;
        for (SmartDevice i : SmartDevices) {
            System.out.println("Device Name: "+i.DeviceName+" ("+i.getDeviceType()+")");

            if (i instanceof Controllable) {
                System.out.println(" -> Controllable");
                interfacesCount++;
            }
            if (i instanceof Programmable) {
                System.out.println(" -> Programmable");
                interfacesCount++;
            }
            if (i instanceof Dimmable) {
                System.out.println(" -> Dimmable");
                interfacesCount++;
            }
            if (i instanceof Adjustable) {
                System.out.println(" -> Adjustable");
                interfacesCount++;
            }

            System.out.println(" "); // Space for Readability
        }
        System.out.println("Total Interfaces used: "+interfacesCount);
    }
}
