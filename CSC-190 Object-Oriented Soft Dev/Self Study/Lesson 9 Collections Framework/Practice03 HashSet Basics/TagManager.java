// Creation Date: June 27, 2026. at 12:27 AM
// Last Modified: June 27, 2026. at  1:05 AM

import java.util.HashSet;

public class TagManager {
    //=======VARIABLES=======//
    private HashSet<String> Tags;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public TagManager() {
        Tags = new HashSet<>();
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public boolean hasTag(String tag) {
        return Tags.contains(tag);
    }
    public int getTagCount() {
        return Tags.size();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void addTag(String tag) {
        System.out.println( (Tags.add(tag)) ? (tag+" has been added into the HashSet Tags!") : (tag+" already exists!")); //... I HAVE GOT THIS SHORTER LINE OF CODE FROM MY AmazingShorcuts.md
        //... THIS IS A STYLE OF CODING CALLED TERNARIES WHICH IS A SHORTER IF CONDITION FOR BOOLEANS;

        /* THIS IS THE USUAL REGULAR CODE
        if (Tags.add(tag)) { //... THIS LINE OF CODE RUNS AND CHECKS AT THE SAME TIME (IF THIS RUNS)
            System.out.println(tag+" has been added into the HashSet Tags!");
        } else { //... IF THE CODE DID NOT RUN
            System.out.println(tag+" already exists!");
        }

         */
    }
    public void removeTag(String tag) {
        System.out.println( (Tags.remove(tag)) ? (tag+" has been removed into the HashSet Tags!") : (tag+" does not exists!")); //... I HAVE GOT THIS SHORTER LINE OF CODE FROM MY AmazingShorcuts.md
        //... THIS IS A STYLE OF CODING CALLED TERNARIES WHICH IS A SHORTER IF CONDITION FOR BOOLEANS;
        

        /* THIS IS THE USUAL REGULAR CODE
        if (Tags.remove(tag)) { //... THIS LINE OF CODE RUNS AND CHECKS AT THE SAME TIME (IF THIS RUNS)
            System.out.println(tag+" has been removed into the HashSet Tags!");
        } else { //... IF THE CODE DID NOT RUN
            System.out.println(tag+" does not exist!");
        }
         */
    }
    public void mergeTag(TagManager tm) {
        for (String i:tm.Tags) { //... USUALLY IT WOULD BE tm.getTags but somehow this also works? why? lmao (IS IT BECAUSE IT IS THE SAME CLASS? I AM ABLE TO USE THE PRIVATE CLASS VARIABLE BECAUSE THE CLASS THAT USED THE PRIVATE IS ACTUALLY THE CLASS ITSELF?)
            Tags.add(i);
        }
    }
    public void clearTags() {
        Tags.clear();
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayTags() {
        System.out.println(Tags);
    }


    // ================================================== OTHER CLASSES ================================================== \\
}

// Private attribute: tags (HashSet<String>)
// Constructor initializes the empty HashSet
// Public method: addTag(String tag) — adds tag, prints confirmation. If tag already exists, print "[tag] already exists!"
// Public method: removeTag(String tag) — removes tag if exists, prints confirmation. If not, print "[tag] does not exist!"
// Public method: hasTag(String tag) — returns boolean
// Public method: displayTags() — prints all tags
// Public method: getTagCount() — returns how many tags exist
// Public method: mergeTags(TagManager other) — adds ALL tags from another TagManager into this one, skipping duplicates automatically
// Public method: clearTags() — removes all tags