// Creation Date: June 26, 2026. at 12:55 AM
// Last Modified: June 26, 2026. at  1:36 AM

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS/INSTANCES =======//
        GradeTracker GTracker01 = new GradeTracker();

        //======= ADDING Key, Values INTO THE HASHMAP  =======//
        GTracker01.addGrade("Christ", 97.53);
        GTracker01.addGrade("Shan", 89.67);
        GTracker01.addGrade("Carl", 95.74);
        GTracker01.addGrade("Sophia", 85.20);
        GTracker01.addGrade("Bella", 81.94);
        System.out.println();

        GTracker01.displayAll();
        System.out.println();

        //======= UPDATING A HASHMAP  =======//
        GTracker01.updateGrade("Shan", 99.67);
        GTracker01.updateGrade("Skibidi Toilet", 67.67); // ... THIS IS TO TRIGGER IF THERE IS NO KEY PAIR FOUND IN THE HASHMAP
        System.out.println();

        //======= GETTERS FOR HASHMAP  =======//
        System.out.println(GTracker01.getGrade("Bella"));
        System.out.println(GTracker01.getHighestGrade());
        System.out.println(GTracker01.getClassAverage());

        //======= REMOVING A KEY IN THE HASHMAP  =======//
        GTracker01.removeStudent("Shan");
        System.out.println();

        GTracker01.displayAll();
        System.out.println();

    }
}

// Create a GradeTracker
// Add 5 students with different grades
// Display all grades
// Update one student's grade
// Try to update a student that doesn't exist
// Get a specific student's grade
// Display the highest scoring student
// Display the class average
// Remove a student
// Display all grades again