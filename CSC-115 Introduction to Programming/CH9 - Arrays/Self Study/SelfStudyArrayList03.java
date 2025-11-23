//Oct 17, 2025
//This code is about adding values inside an ArrayList.

import java.util.ArrayList;
import java.util.Scanner;

public class SelfStudyArrayList03 {
    public static void main(String[] args) {
        CustomizeableArrayList();
    }
    
    public static void CustomizeableArrayList() {
        ArrayList<String> Students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What Class?");
        String ClassYear = scanner.nextLine();

        System.out.println("Add a Student: (Input 'Stop' to stop adding) (Input 'Show' to view the current list)");

        boolean Stop = false;
        while(Stop == false) {
            String StudentName = scanner.nextLine();
            if (StudentName.equalsIgnoreCase("STOP")) { //equalsIgnoreCase makes it so that no matter which uppercase or lowercase, as long as the word matches, then it stops.
                Stop = true;
            } else {
                Students.add(StudentName);
            }
            if (StudentName.equalsIgnoreCase("Show")) {
                System.out.println("\nCurrent Students:");
                for (int i = 0; i < Students.size(); i++) {
                        System.out.println((i+1) + ". " + Students.get(i));
                }
                System.out.println();
            }
        }

        scanner.close();

        System.out.println("\nStudents:");
        for (int i = 0; i < Students.size(); i++) {
            System.out.println((i+1) + ". " + Students.get(i));
        }
    }
}
