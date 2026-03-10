// Creation Date: March 09, 2026. at 1:18 PM
// Last Modified: March 10, 2026. at 10:00 AM

import Classes.Person.Academic.AP_Professor;
import Classes.Person.Person;
import Classes.Course;

public class University {
    //=======VARIABLES=======//
    private String UniversityName;
    private Person[] People = new Person[20];
    private int PeoplCount;
    private Course[] Courses = new Course[10];
    private int CourseCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public University(String UniversityName) {
        this.UniversityName = UniversityName;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public void addPerson(Person person) {
        // LIMIT NOTIFICATION
        if (PeoplCount == People.length) {
            System.out.println("There are no more open slots for "+UniversityName);
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Person i: People) {
            if (i == person) {
                System.out.println(person.getName()+" is already enrolled at "+UniversityName);
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        People[PeoplCount] = person;
        PeoplCount++;
        System.out.println(person.getName()+" is successfully enrolled at "+UniversityName);
    }
    public void addCourse(Course course) {
        // LIMIT NOTIFICATION
        if (CourseCount == Courses.length) {
            System.out.println(UniversityName+" Has reached the maximum amount of courses they can have");
            return; // Stops the method here.
        }
        // DUPLICATION NOTIFICATION
        for (Course i: Courses) {
            if (i == course) {
                System.out.println(course.getCourseName()+" is already added in "+UniversityName);
                return; // Stops the method here.
            }
        }
        // ADDING COURSE INTO THE ARRAY
        Courses[CourseCount] = course;
        CourseCount++;
        System.out.println(UniversityName+" has successfully added a new course: "+course.getCourseName());
    }
    

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public void displayAllPeople() {
        System.out.println("============ ALL PEOPLE ============");
        for (Person i:People) {
            if (i != null) { // if the position is not empty
                i.displayInformation();
                System.out.println(" "); // Space for Readability
            }
        }
    }

    public void displayAllCourses() {
        
    }
}
