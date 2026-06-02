package Report;

// Creation Date: June 01, 2026. at 11:29 PM
// Last Modified: June 02, 2026. at  1:58 PM

import Core.GradeBook;
import Utilites.ArrayUtils;

public class ReportCard {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void printReport(GradeBook gbook) {
        System.out.println("Student Name: "+gbook.getStudentName());
        System.out.println("Grades: "+ ArrayUtils.toStringArrayNoZero(gbook.getGrades()));
        System.out.println("Average: "+ gbook.getAverage());
        System.out.println("Letter Grade: "+gbook.getLetterGrade());
    }
}
