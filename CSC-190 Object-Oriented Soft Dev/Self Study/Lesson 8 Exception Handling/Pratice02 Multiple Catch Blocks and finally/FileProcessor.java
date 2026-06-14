// Creation Date: June 14, 2026. at 1:42 AM
// Last Modified: June 14, 2026. at  2:29 AM

public class FileProcessor {
    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void processFile(String filename, int[] data, int index) {
        try {
            System.out.println("Processing file: " + filename.length()); // throws NPE if filename is null
            System.out.println("Accessing data at index: " + data[index]); // throws AIOOBE if index invalid
        } catch (NullPointerException e) {
            System.out.println("filename cannot be null");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index "+index+" is out of bounds");
        } catch (Exception e) {
            System.out.println("Unexpected error: "+e);
        } finally {
            System.out.println("Finished processing attempt for: "+((filename == null) ? "UNKNOWN" : filename));    //... <============================ THANKS TO CLAUDE FOR TEACHING ME THIS AMAZING SHORTCUTE
            //... Condition ? IfTrue : IfFalse;
        }
    }
    public String validateAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }

        return "Valid age: "+age; 
    }

    // ================================================== OTHER CLASSES ================================================== \\
}


// Public method: processFile(String filename, int[] data, int index)
//  • Use multiple catch blocks to handle different exceptions:
//      → If filename is null → catch NullPointerException (you can trigger this by calling filename.length()), print "Filename cannot be null!"
//      → If index is out of bounds for data → catch ArrayIndexOutOfBoundsException, print "Index [index] is out of bounds!"
//      → If any other exception occurs → catch generic Exception, print "Unexpected error: [exception message]"
//  • Use a finally block that always prints "Finished processing attempt for: [filename]" (handle the case where filename might be null in this message too — print "UNKNOWN" instead if null)
//
// Public method: validateAge(int age) — returns String
//  • If age < 0 or age > 150, throw a new IllegalArgumentException("Age must be between 0 and 150")
//  • Otherwise return "Valid age: [age]"
//  • This method should use throws in its signature (declare it can throw IllegalArgumentException)