// Creation Date: June 27, 2026. at 1:11 AM
// Last Modified: June 28, 2026. at  3:59 AM

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS/INSTANCES =======//
        Club Club01 = new Club("Club01");
        Club Club02 = new Club("Club02");

        //======= ADDING MEMBERS =======//
        // [Club01]
        Club01.addMember("M01", "Family Member");
        Club01.addMember("M02", "Special Member");
        Club01.addMember("M03", "Black Member");
        Club01.addMember("M04", "Regular Member");
        System.out.println();

        // [Club02]
        Club02.addMember("M01", "Family Member");
        Club02.addMember("M01", "Family Member");
        Club02.addMember("M02", "Black Member");
        Club02.addMember("M03", "Regular Member");
        System.out.println();

        //======= ADDING SKILLS =======//
        // [Club01]
        Club01.addSkill("Idiot");
        Club01.addSkill("Moron");
        Club01.addSkill("Stupid");
        Club01.addSkill("Retard");
        Club01.addSkill("Idiot"); // This won't be added into the HashSet since it is already added in
        System.out.println();
        
        // [Club02]
        Club02.addSkill("Smart");
        Club02.addSkill("Handsome");
        Club02.addSkill("Charismatic");
        Club02.addSkill("Funny");
        System.out.println();

        //======= DISPLAY CLUBS =======//
        Club01.displayClub();
        System.out.println();

        Club02.displayClub();
        System.out.println();

        //======= GET SPECIFC MEMBER ROLE =======//
        System.out.println(Club01.getMemberRole("M01"));
        System.out.println(Club02.getMemberRole("M03"));
        System.out.println();

        //======= REMOVING A MEMBER FROM EACH CLUB =======//
        Club01.removeMember("M04");
        Club02.removeMember("M03");

        //======= DISPLAY CLUBS =======//
        Club01.displayClub();
        System.out.println();

        Club02.displayClub();
        System.out.println();
    }
}

// Create 2 clubs
// Add 4 members to each with different roles
// Try adding a duplicate member to show the rejection
// Add skills to each club
// Display both clubs
// Get a specific member's role from each club
// Remove a member from each club
// Display both clubs again