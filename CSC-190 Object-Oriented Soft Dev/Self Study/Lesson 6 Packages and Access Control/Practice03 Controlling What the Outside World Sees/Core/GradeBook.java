package Core;

// Creation Date: June 01, 2026. at 11:29 PM
// Last Modified: June 02, 2026. at 12:14 AM

public class GradeBook {
    //=======VARIABLES=======//
    private String StudentName;
    private double[] Grades;
    private int GradeCount;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public GradeBook(String StudentName) {
        this.StudentName = StudentName;
        Grades = new double[10];
        GradeCount = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getStudentName() {
        return StudentName;
    }
    public double[] getGrades() {
        return Grades;
    }
    public double getAverage() {
        return GradeCalculator.calculateAverage(Grades);
    }
    public String getLetterGrade() {
        return GradeCalculator.getLetterGrade(GradeCalculator.calculateAverage(Grades));
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addGrade(double grade) {
        //? CHECKS IF GRADE IS FULL
        if (GradeCount >= Grades.length) {
            System.out.println("Grades Array is full!");
            return; // Stops the whole method here
        }

        //? ADDING THE GRADE TO GRADES
        Grades[GradeCount] = grade;
        GradeCount++;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
