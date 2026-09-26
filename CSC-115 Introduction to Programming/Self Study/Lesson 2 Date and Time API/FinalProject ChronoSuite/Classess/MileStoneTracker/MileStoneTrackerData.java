package Classess.MileStoneTracker;

// Creation Date: August 26, 2026. at 11:59 PM
// Last Modified: September 25, 2026. at 11:54 PM

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
    public int getAge() {
        if (!LoggedIn) System.out.println("[ERROR] User is not logged in!");
        return (LoggedIn) ? Age: 0;
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
    public boolean getLoggedIn() {
        return LoggedIn;
    }
    public boolean getEmptyPassword() {
        return EmptyPassword;
    }

    public boolean DayMilestoneIsEmpty() {
        return DayBasedMilestone.isEmpty();
    }
    public boolean AgeMilestoneIsEmpty() {
        return AgeBasedMilestone.isEmpty();
    }

    // [FOR MENU PRINTING] NOTE: I feel ashamed having to be able to call this when its supposed to be "secure"
    public HashMap<Integer, String> getAgeBasedMilestone() {
        return AgeBasedMilestone;
    }
    public HashMap<Integer, String> getDayBasedMilestone() {
        return DayBasedMilestone;
    }

    public ArrayList<Integer> getSortedAgeKeys() {
        ArrayList<Integer> sortedAge = new ArrayList<>(AgeBasedMilestone.keySet());
        Collections.sort(sortedAge);
        return sortedAge;
    }
    public ArrayList<Integer> getSortedDayKeys() {
        ArrayList<Integer> sortedDay = new ArrayList<>(DayBasedMilestone.keySet());
        Collections.sort(sortedDay);
        return sortedDay;
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

    // [MILESTONES]
    public boolean addDayBasedMilestone(int day, String message) {
        // [SECURITY]
        if (day < 0 || day > 45000) {
            // System.out.println("[ERROR] Day can not be less than 0 or greater than 45000 days");
            return false;
        }

        // [PRINT]
        if (DayBasedMilestone.containsKey(day)) {
            // System.out.println("(Day: "+day+") {Message: "+message+"} has been successfully overwritten!");
        } else {
            // System.out.println("(Day: "+day+") {Message: "+message+"} has been successfully added!");
        }

        // [PROCESS]
        DayBasedMilestone.put(day, message);

        return true;
    }
    public boolean removeDayBasedMilestone(int day) {

        if (DayBasedMilestone.containsKey(day)) {
            DayBasedMilestone.remove(day);
            System.out.println("day "+day+" has been successfully been removed!");
            System.out.println();
            return true; // true means that it has successfully been deleted
        }

        System.out.println("day "+day+" does not exist!");
        return false; // false means that it did get successfully deleted
    }
    public boolean addAgeBasedMilestone(int age, String message) {
        // [SECURITY]
        if (age < 0 || age > 130) {
            System.out.println("[ERROR] Age can not be less than 0 or greater than 130");
            return false;
        }

        // [PRINT]
        if (AgeBasedMilestone.containsKey(age)) {
            System.out.println("(Age: "+age+") {Message: "+message+"} has been successfully overwritten!");
        } else {
            System.out.println("(Age: "+age+") {Message: "+message+"} has been successfully added!");
        }

        // [PROCESS]
        AgeBasedMilestone.put(age, message);

        return true;
    }
    public boolean removeAgeBasedMilestone(int age) {

        if (AgeBasedMilestone.containsKey(age)) {
            System.out.println("age "+age+" has been successfully been removed!");
            System.out.println();
            AgeBasedMilestone.remove(age);
            return true; // true means that it has successfully been deleted
        }

        System.out.println("age "+age+" does not exist!");
        return false; // false means that it did get successfully deleted
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void printDayMilestones() {
        // [SORTING]
        ArrayList<Integer> sortedDays = new ArrayList<>(DayBasedMilestone.keySet());
        Collections.sort(sortedDays);

        // [PRINT]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         DAY MILESTONES                          ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        for (int d: sortedDays) {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ (Day: "+d+") {Message: "+DayBasedMilestone.get(d)+"} ", 67));
        }
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"-1\" to exit.                                       ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    public void printAgeMilestones() {
        // [SORTING]
        ArrayList<Integer> sortedAges = new ArrayList<>(AgeBasedMilestone.keySet());
        Collections.sort(sortedAges);

        // [PRINT]
        System.out.println("╔═════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         AGE MILESTONES                          ║");
        System.out.println("╟─────────────────────────────────────────────────────────────────╢");
        for (int a: sortedAges) {
            System.out.println(ReuseableMethodsCLI.softWrapping("║ (Age: "+a+") {Message: "+AgeBasedMilestone.get(a)+"} ", 67));
        }
        System.out.println("╠═════════════════════════════════════════════════════════════════╣");
        System.out.println("║[NOTE] Input \"-1\" to exit.                                       ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }


    // ================================================== OTHER CLASSES ================================================== \\
}

// TODO: WE NEED TO ENCRYPT THIS! in the object file, it shows the password.
// TODO: WE SHOULD ADD A LAST MODIFIED BY AUTHOR IF AUTHOR IS A DIFFERENT PERSON THEN ADD IF NOT THEN NO.
