// Creation Date: March 03, 2026. at 10:30 AM
// Last Modified: March 03, 2026. at 11:07 AM

public class Time {
    //=======VARIABLES=======//
    private int hour;
    private int minute;
    private int second;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Time() {
        this(System.currentTimeMillis()); // PASSES THE VARIABLE AROUND TO WHERE IT CAN BE STORED (2nd Constructor)
    }
    public Time(long elapseTime) {
        setTime(elapseTime);
    }
    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setTime(long elapseTime) { // I DONT UNDERSTAND THE MATH
        long totalSeconds = elapseTime/1000; // Convert miliseconds to seconds
        this.second = (int)(totalSeconds % 60); //

        long totalMinutes = totalSeconds/60; // Converts seconds to minutes
        this.minute = (int)(totalMinutes % 60); //

        int totalHours = (int)(totalMinutes/60); // Converts minutes to hours
        this.hour = (int)(totalHours % 24); //
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
