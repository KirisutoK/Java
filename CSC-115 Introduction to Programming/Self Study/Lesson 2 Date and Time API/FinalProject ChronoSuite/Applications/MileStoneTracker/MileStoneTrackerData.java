package Applications.MileStoneTracker;

// Creation Date: August 26, 2026. at 11:59 PM
// Last Modified: September 26, 2026. at  1:32 AM

import Misc.ReuseableMethodsCLI;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MileStoneTrackerData implements Serializable {
    //=======VARIABLES=======//
    // [Class Data]
    private static final long serialVersionUID = 1L; // this is for serialization versions of the class

    // [Security]
    private String Password; // TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password. (DO THIS AFTER LEARNING HOW TO ENCRYPT AND HASHING [Cryptography Lessons: Not OOP])
    private boolean EmptyPassword;
    private boolean LoggedIn = false;

    // [Basic Data]
    private String Username;
    private int Age;
    private LocalDate Birthday;
    private LocalDate Today;

    // [Milestones Data]
    private HashMap<Integer, String> AgeBasedMilestone; // Age, Message
    private HashMap<Integer, String> DayBasedMilestone; // Day, Message

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    MileStoneTrackerData(String Username, String Password, LocalDate Birthday) {
        this.Username = Username;
        this.Password = Password;
        this.EmptyPassword = false;
        this.Birthday = Birthday;
        this.Today = LocalDate.now();
        this.Age = ReuseableMethodsCLI.getAge(Birthday);
        this.AgeBasedMilestone = new HashMap<>();
        this.DayBasedMilestone = new HashMap<>();
    }
    MileStoneTrackerData(String Username, LocalDate Birthday) {
        this.Username = Username;
        this.EmptyPassword = true;
        this.Birthday = Birthday;
        this.Today = LocalDate.now();
        this.Age = ReuseableMethodsCLI.getAge(Birthday);
        this.AgeBasedMilestone = new HashMap<>();
        this.DayBasedMilestone = new HashMap<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // [Basic Getters]
    // +[PERSONAL]+
    public int getAge() {
        return (LoggedIn) ? Age: -1; // -1 means age that it did not logged in
    }
    public String getUsername() {
        return (LoggedIn) ? Username: "[ERROR] User is not logged in!";
    }
    public String getNextBirthday() {
        LocalDate nextBirthday = LocalDate.of(Today.getYear(), Birthday.getMonth(), Birthday.getDayOfMonth());

        if (nextBirthday.isBefore(Today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        return nextBirthday.getMonth()+" "+nextBirthday.getDayOfMonth()+" "+nextBirthday.getYear();
    }
    public long getTotalDaysAlive() {
        return ChronoUnit.DAYS.between(Birthday, Today);
    }

    // +[SECURITY]+
    public boolean getLoggedIn() {
        return LoggedIn;
    }
    public boolean getEmptyPassword() {
        return EmptyPassword;
    }

    // +[DATA]+
    // +[<======== Day
    public boolean DayMilestoneIsEmpty() {
        return DayBasedMilestone.isEmpty();
    }
    public boolean DayMilestoneContains(int day) {
        return DayBasedMilestone.containsKey(day);
    }
    public String getDayMilestoneMessage(int day) {
        return DayBasedMilestone.get(day);
    }
    public ArrayList<Integer> getSortedDayKeys() {
        ArrayList<Integer> sortedDay = new ArrayList<>(DayBasedMilestone.keySet());
        Collections.sort(sortedDay);
        return sortedDay;
    }
    // +[<======== Age
    public boolean AgeMilestoneIsEmpty() {
        return AgeBasedMilestone.isEmpty();
    }
    public boolean AgeMilestoneContains(int age) {
        return AgeBasedMilestone.containsKey(age);
    }
    public String getAgeMilestoneMessage(int age) {
        return AgeBasedMilestone.get(age);
    }
    public ArrayList<Integer> getSortedAgeKeys() {
        ArrayList<Integer> sortedAge = new ArrayList<>(AgeBasedMilestone.keySet());
        Collections.sort(sortedAge);
        return sortedAge;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // [SECURITY]
    public boolean logIn(String input) {
        if (Password.equals(input)) {
            LoggedIn = true;
            return true; // true means that it has succefully logged in
        }

        return false; // false means that it did not logged-in successsfully
    }
    public void logOut() {
        LoggedIn = false;
    }
    public void setPassword(String HashedPassword) {
        this.Password = HashedPassword;
        this.EmptyPassword = false;
    }

    // [MILESTONES] NOTE: This can only be accessed with the same level of the class (which is the MST Handler)
    boolean addDayBasedMilestone(int day, String message) {
        // [SECURITY]
        if (day < 0 || day > 45000) {
            return false;
        }

        // [PROCESS]
        DayBasedMilestone.put(day, message);
        return true;
    }
    boolean removeDayBasedMilestone(int day) {

        if (DayBasedMilestone.containsKey(day)) {
            DayBasedMilestone.remove(day);

            return true; // true means that it has successfully been deleted
        }

        return false; // false means that it did get successfully deleted
    }
    boolean addAgeBasedMilestone(int age, String message) {
        // [SECURITY]
        if (age < 0 || age > 130) {
            return false;
        }

        // [PROCESS]
        AgeBasedMilestone.put(age, message);

        return true;
    }
    boolean removeAgeBasedMilestone(int age) {

        if (AgeBasedMilestone.containsKey(age)) {
            AgeBasedMilestone.remove(age);
            return true; // true means that it has successfully been deleted
        }

        return false; // false means that it did get successfully deleted
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS



    // ================================================== OTHER CLASSES ================================================== \\
}

// TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password.
// TODO: WE SHOULD ADD A LAST MODIFIED BY AUTHOR IF AUTHOR IS A DIFFERENT PERSON THEN ADD IF NOT THEN NO.
