// Creation Date: June 30, 2026. at 2:09 AM
// Last Modified: June 30, 2026. at  2:49 AM

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> StudentsAndClub = new ArrayList<>();

        StudentsAndClub.add("Alice,Chess");
        StudentsAndClub.add("Bob,Art");
        StudentsAndClub.add("Charlie,Chess");
        StudentsAndClub.add("Eve,Chess");

        System.out.println(StudentClubTracker(StudentsAndClub));
    }

    public static HashMap<String, ArrayList<String>> StudentClubTracker(ArrayList<String> arr) {
        HashMap<String, ArrayList<String>> Result = new HashMap<>();

        // ADDING THE ARR INTO THE HASHMAP
        for (String i:arr) { // For every value in the Arraylist
            String[] Split = i.split(",");
            // Split[0] == Name;
            // Split[1] == Club;

            // CHECK IF CLUB ALREADY EXISTS
            if (Result.containsKey(Split[1])) { // If Club Exists
                Result.get(Split[1]).add(Split[0]);
            } else { // If Club does not exist
                ArrayList<String> Students = new ArrayList<>();
                Students.add(Split[0]);
                Result.put(Split[1], Students);
            }
        }
        return  Result;
    }

}

// Problem 4 — Hard (Real-World)
// A teacher wants to track which students are enrolled in which clubs. Given an ArrayList<String> of "StudentName,ClubName" pairs (comma-separated),
// build a HashMap<String, ArrayList<String>> where each key is a club name and the value is an ArrayList of all students in that club.
//
// Input:  ["Alice,Chess", "Bob,Art", "Charlie,Chess", "Diana,Art", "Eve,Chess"]
// Output: {"Chess": [Alice, Charlie, Eve], "Art": [Bob, Diana]}
//
// Input:  ["Frank,Music"]
// Output: {"Music": [Frank]}
//
// Input:  []
// Output: {}
