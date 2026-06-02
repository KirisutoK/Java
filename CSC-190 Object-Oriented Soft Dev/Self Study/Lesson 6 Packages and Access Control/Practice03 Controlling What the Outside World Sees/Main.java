// Creation Date: June 01, 2026. at 11:28 PM
// Last Modified: June 02, 2026. at  1:58 PM

import Core.*;
import Report.*;

public class Main {
    public static void main(String[] args) {
        // ==================== CREATING INSTANCES OR OBJECTS ==================== \\
        ReportCard reportCard = new ReportCard(); // This only consists of methods
        GradeBook Student01 = new GradeBook("Christ Aerjil Dampog");
        GradeBook Student02 = new GradeBook("Zhiannelle Gravino");

        // ==================== GRADES ==================== \\
        // [ADDING GRADES]
        Student01.addGrade(90);
        Student01.addGrade(98.9);
        Student01.addGrade(84.10);
        Student01.addGrade(79.67);

        Student02.addGrade(60.67);
        Student02.addGrade(75.55);
        Student02.addGrade(96.27);
        Student02.addGrade(60.67);
        Student02.addGrade(75.55);
        Student02.addGrade(96.27);
        
        // ==================== REPORT CARD ==================== \\
        reportCard.printReport(Student01);
        System.out.println(" "); // Space for Readability
        reportCard.printReport(Student02);

        // GRADE CALCULATOR CANNOT BE ACCESSED BECAUSE IT IS PACKAGE PRIVATE, WE CANNOT CREATE AN OBJECT/INSTANCE IN THE MAIN BUT WE CAN MAKE ONE IN THE GRADEBOOK CLASS AND ACCESS GRADECALCULATOR THROUGH GRADEBOOK CLASS (SIMILAR TO A MIDDLEMAN)

    }
}
