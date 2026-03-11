package Classes.Person.Academic;

// Creation Date: March 01, 2026. at 11:19 AM
// Last Modified: March 11, 2026. at  7:03 PM

import Classes.Course;
import Interfaces.Payable;
import Interfaces.Teachable;

public class S_TeachingAssistant
        extends AP_Student
        implements Teachable, Payable {

    //=======VARIABLES=======//
    private double HourlyRate;
    private int HoursPerWeek;
    private Course[] AssistingCourses = new Course[2];
    private int AssistCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public S_TeachingAssistant(String Name, String ID, int Age, String Department, double HourlyRate, int HoursPerWeek) {
        super(Name, ID, Age, Department);
        this.HourlyRate = HourlyRate;
        this.HoursPerWeek = HoursPerWeek;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // --- @OVERRIDE
    // TEACHABLE <==== [INTERFACE]
    @Override public int getTeachingLoad() {
        return AssistCount;
    }
    // PAYABLE <==== [INTERFACE]
    @Override public double calculateSalary() {
        return HourlyRate*HoursPerWeek*4; // hourlyRate × hoursPerWeek × 4 (monthly)
    }
    @Override public void displayPayInfo() {
        System.out.println("Hourly Rate: $"+HourlyRate);
        System.out.println("Hours per Week: "+HoursPerWeek);
        System.out.println("Monthly Salary: $"+calculateSalary());
    }
    // PERSON <==== [ABSTRACT]
    @Override public String getRole() {
        return "Teaching Assistant";
    }
    // ACADEMICPERSON <==== [ABSTRACT]


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    // --- @OVERRIDE
    // TEACHABLE <==== [INTERFACE]
    @Override public void teach(Course course) {
        // LIMIT NOTIFICATION
        if (AssistCount == AssistingCourses.length) {
            System.out.println(Name+"have reached the limit for assisting on teaching courses");
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Course i: AssistingCourses) {
            if (i == course) {
                System.out.println(Name+" is already assisting on teaching "+i.getCourseName());
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        AssistingCourses[AssistCount] = course;
        AssistCount++;
        System.out.println(Name+" has started assisting on teaching "+course.getCourseName());
    }
    // PAYABLE <==== [INTERFACE]
    // PERSON <==== [ABSTRACT]
    // ACADEMICPERSON <==== [ABSTRACT]


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    @Override public void displayInformation() {
        super.displayInformation();
        System.out.print("Assisting Courses:"); for (int i = 0; i < AssistCount; i++) {System.out.print(" "+AssistingCourses[i].getCourseName()+" |");}
        System.out.println(" "); // Space for Readability
        displayPayInfo();
    }
}