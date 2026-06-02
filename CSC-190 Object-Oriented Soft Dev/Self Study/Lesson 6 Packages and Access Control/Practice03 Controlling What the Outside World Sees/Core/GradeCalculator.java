package Core;

// Creation Date: June 01, 2026. at 11:29 PM
// Last Modified: June 02, 2026. at 12:11 AM

class GradeCalculator { // <========= PACKAGE-PRIVATE
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    static double calculateAverage(double[] grades) {

        double totalGrades = 0;
        int totalCountGrades = 0;
        for (int i = 0; i < grades.length; i++) {
            totalGrades += grades[i];
            if (grades[i] > 0) {totalCountGrades++;}; // The grade must be greater than 0 in order for it to be a valid grade
        }

        return totalGrades/totalCountGrades;
    } // Package-Private
    static String getLetterGrade(double average) {

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        }
        
        return "F";
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
