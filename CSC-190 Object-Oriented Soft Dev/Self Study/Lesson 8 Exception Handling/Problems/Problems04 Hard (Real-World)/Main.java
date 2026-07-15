// Creation Date: June 20, 2026. at 11:29 PM
// Last Modified: June 21, 2026. at 11:39 PM

public class Main {
    public static void main(String[] args) {
        double[] RandomStudentGrades01 = {85.0, 90.0, 78.0};
        double[] RandomStudentGrades02 = {85.0, 110.0, 78.0};
        addGrades(RandomStudentGrades01);
        addGrades(RandomStudentGrades02);
    }

    public static void addGrades(double[] grades) {
        try {
            double totalGrades = 0;
            int countGrades = 0;
            for (double i:grades) { // for every index inside grades
                if (i < 0 || i > 100) {
                    throw  new InvalidGradeException(i);
                }

                totalGrades += i;
                countGrades++;
            }

            System.out.println("Average:"+ totalGrades/countGrades);
        } catch (InvalidGradeException e) {
            System.out.println(e.getMessage());
        }
    }

}

