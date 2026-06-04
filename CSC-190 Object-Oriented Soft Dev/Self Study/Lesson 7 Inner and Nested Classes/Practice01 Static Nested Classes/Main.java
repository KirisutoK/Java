// Creation Date: June 03, 2026. at 10:16 PM
// Last Modified: June 03, 2026. at 10:51 PM

public class Main {
    public static void main(String[] args) {
        // ============= CREATING OBJECT ============= \\
        Computer KirisutosPC = new Computer("ASUS", 500);
        Computer.Specs KirisutosPC_Specs = new Computer.Specs("AMD Ryzen 7", 16, 447);
        Computer.Warranty KirisutosPC_Warranty = new Computer.Warranty(1, "ASUS");

        // ============= DISPLAY ============= \\
        KirisutosPC.displayInfo();
        System.out.println(); // Space for Readability
        KirisutosPC_Specs.displaySpecs();
        System.out.println(); // Space for Readability
        KirisutosPC_Warranty.displayWarranty();
        
    }
}

// NOTES: SINCE IT'S A STATIC NESTED CLASS, WHEN YOU CREATE THE CLASS, THE DATA WILL ALWAYS BE THE SAME THROUGH EVERY CLASS THAT WAS MADE (RULE FOR STATIC).
// NOTES: IF IT WAS AN INNER CLASS (NO-STATIC), IT WOULD BE DIFFERENT BECAUSE ITS VALUE LOCALLY DIFFERENT.
//
// CLARIFICATION FROM PROFESSOR CLAUDE: Static nested classes don't actually share data between instances the way static variables do. Each Computer.Specs object you create has its own separate CPU, RAM, and Storage values. What makes it static is that it doesn't need an outer object to exist — not that the data is shared.
// You're thinking of static variables (like totalStudents from Lesson 2). Static nested classes are a different use of the static keyword!
