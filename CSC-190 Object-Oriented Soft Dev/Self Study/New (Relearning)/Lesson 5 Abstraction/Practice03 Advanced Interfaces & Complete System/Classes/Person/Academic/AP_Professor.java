package Classes.Person.Academic;

// Creation Date: March 01, 2026. at 11:11 AM
// Last Modified: March 10, 2026. at  9:58 AM

import Interfaces.Payable;
import Interfaces.Teachable;
import Classes.Course;

public class AP_Professor
        extends AcademicPerson
        implements Teachable, Payable {
    //=======VARIABLES=======//
    private double BaseSalary;
    private int YearsOfExperience;
    private Course[] TeachingCourses = new Course[4];
    private int CourseCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public AP_Professor(String Name, String ID, int Age, String Department, double BaseSalary, int YearsOfExperience) {
        super(Name, ID, Age, Department);
        this.BaseSalary = BaseSalary;
        this.YearsOfExperience = YearsOfExperience;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // --- @OVERRIDE
    // TEACHABLE <==== [INTERFACE]
    @Override public int getTeachingLoad() {
        return CourseCount;
    }
    // PAYABLE <==== [INTERFACE]
    @Override public double calculateSalary() {
        return BaseSalary + (YearsOfExperience * 1000);
    }
    @Override public void displayPayInfo() {
        System.out.println("Base Salary: $"+BaseSalary);
        System.out.println("Experience Bonus: $"+(YearsOfExperience*1000));
        System.out.println("Total: $"+calculateSalary());
    }
    // PERSON <==== [ABSTRACT]
    @Override public String getRole() {
        return "Professor";
    }
    // ACADEMICPERSON <==== [ABSTRACT]
    @Override public String getAcademicStatus() {
        if (YearsOfExperience < 5) {
            return "Assistant Professor";
        } else if (YearsOfExperience < 10) {
            return "Associate Professor";
        }
        return "Full Professor";
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void unteach(Course course) {
        boolean hasCourse = false;
        // REMOVING THE COURSE
        for (int i = 0; i < CourseCount; i++) { // for every CourseCount
            if (TeachingCourses[i] == course) { // if it matches
                CourseCount--;
                hasCourse = true;
                for (int j = i; j < CourseCount; j++) { // for every CourseCount starting from where the course is found
                    if (j != TeachingCourses.length-1) { // if the index is NOT in the last position of the array
                        TeachingCourses[j] = TeachingCourses[j+1];
                    }
                }
                System.out.println(Name+" has stopped teaching "+course.getCourseName());
            }
        }
        // NOTIFIES IF YOU ARE NOT TEACHING THAT COURSE
        if (!hasCourse) {
            System.out.println(Name+" is not teaching "+course.getCourseName());
        }
    }

    // --- @OVERRIDE
    // TEACHABLE <==== [INTERFACE]
    @Override public void teach(Course course) {
        // LIMIT NOTIFICATION
        if (CourseCount == TeachingCourses.length) {
            System.out.println(Name+"have reached the limit for teaching courses");
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Course i: TeachingCourses) {
            if (i == course) {
                System.out.println(Name+" is already teaching "+i.getCourseName());
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        TeachingCourses[CourseCount] = course;
        CourseCount++;
        System.out.println(Name+" has started teaching "+course.getCourseName());
    }
    // PAYABLE <==== [INTERFACE]
    // PERSON <==== [ABSTRACT]
    // ACADEMICPERSON <==== [ABSTRACT]

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THEE DESIRED RESULTS
    @Override public void displayInformation() {
        super.displayInformation();
        System.out.println("Salary: "+calculateSalary());
        System.out.println("Years of Experience: "+YearsOfExperience);
        System.out.print("Teaching Courses: "); for (int i = 0; i < CourseCount; i++) {System.out.print(" "+ TeachingCourses[i].getCourseName()+" |");}
        System.out.println(" "); // Space for Readability
    }
}
