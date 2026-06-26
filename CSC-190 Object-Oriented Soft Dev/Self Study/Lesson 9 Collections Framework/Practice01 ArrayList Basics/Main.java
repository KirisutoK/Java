// Creation Date: June 24, 2026. at 11:51 PM
// Last Modified: June 25, 2026. at 12:42 AM

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS =======//
        Roster R01 = new Roster();

        //======= ADDING STUDENTS =======//
        R01.addStudents("Christ");
        R01.addStudents("Shan");
        R01.addStudents("Carl");
        R01.addStudents("Sophia");
        R01.addStudents("Random Kid");

        R01.displayRoster();
        System.out.println();

        //======= CONTAINS =======//
        System.out.println(R01.hasStudent("Sophia"));
        System.out.println(R01.hasStudent("Chris"));
        System.out.println();

        //======= REMOVING STUDENTS =======//
        R01.removeStudents("Chris"); //... This will trigger a message
        R01.removeStudents("Christ");
        System.out.println();

        R01.displayRoster();
        System.out.println();

        //======= GET STUDENT =======//
        System.out.println(R01.getStudent(-1)); //... This will trigger a message
        System.out.println(R01.getStudent(3));
        System.out.println();

        //======= CLEARING THE ROSTER =======//
        R01.clearRoster();

        R01.displayRoster();
        System.out.println();

    }
}

// TODO: THIS IS ALREADY FINISHED, YOU JUST HAVE TO SUBMIT IT TO PROFESSOR CLAUDE IN ZIP FORM