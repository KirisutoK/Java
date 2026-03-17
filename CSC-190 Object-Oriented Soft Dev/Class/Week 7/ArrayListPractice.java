// Creation Date: March 12, 2026. at 10:45 AM
// Last Modified: March 16, 2026. at 11:08 PM

import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList<String> studentRoster = new ArrayList<String>();
        studentRoster.add("Gavin");
        studentRoster.add("Test");
        studentRoster.add("Run");


        System.out.println(studentRoster);
        studentRoster.sort(null);
        System.out.println();
    }
}
