// Creation Date: June 27, 2026. at 12:27 AM
// Last Modified: June 27, 2026. at  1:03 AM

public class Main {
    public static void main(String[] args) {
        //======= CREATING OBJECTS/INSTANCES =======//
        TagManager TManager01 = new TagManager();
        TagManager TManager02 = new TagManager();

        //======= ADDING ITEMS  =======//
        // [TManager01]
        TManager01.addTag("Anime");
        TManager01.addTag("Movie");
        TManager01.addTag("Game");
        TManager01.addTag("Anime");
        System.out.println();

        // [TManager02]
        TManager02.addTag("Anime");
        TManager02.addTag("Hiking");
        TManager02.addTag("Sports");
        System.out.println();

        TManager01.displayTags();
        TManager02.displayTags();
        System.out.println();

        //======= MERGING ITEMS  =======//
        TManager01.mergeTag(TManager02);
        System.out.println();

        TManager01.displayTags();
        TManager02.displayTags();
        System.out.println();

        //======= REMOVING ITEMS  =======//
        TManager01.removeTag("Movie");
        System.out.println();

        TManager01.displayTags();
        System.out.println();

        //======= CLEARING ITEMS  =======//
        TManager01.clearTags();
        TManager02.clearTags();
        System.out.println();

        TManager01.displayTags();
        TManager02.displayTags();
        System.out.println();
        
    }
}

// Create 2 TagManager objects
// Add 4 tags to the first one (try adding a duplicate to show it gets rejected)
// Add 3 tags to the second one (at least 1 should overlap with the first)
// Display both tag managers
// Merge the second into the first
// Display the first after merging — notice duplicates were automatically skipped!
// Check if a specific tag exists
// Remove a tag
// Display final tag count
