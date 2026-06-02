// Creation Date: June 02, 2026. at 2:13 PM
// Last Modified: June 02, 2026. at  3:41 PM

import Family.FamilyMember;
import Rules.*;

public class Main {
    public static void main(String[] args) {
        //=======CREATING CLASSES=======//
        FamilyMember FMember01 = new FamilyMember("Christ", "Son", 19);

        //=======FAMILY STUFF=======//
        FMember01.displayInformation();

        // [ADDING RULES]
        Rule Rule01 = new Rule(FMember01, "WASH THE DISHES PLEASE!", "UNTIL THERE IS NO MORE DISHES IN THE SINK!");
        Rule01.displayInformation();
    }
}

// TODO: Requirements:
// TODO:
// TODO: Must have a minimum of 3 packages each with a clear and logical purpose
// TODO: Must demonstrate all 4 access modifiers (public, protected, package-private, private) — each used meaningfully, not just randomly placed
// TODO: Must have at least one package-private class that is hidden from outside packages but used internally by a public class in the same package (the gateway pattern)
// TODO: Must have at least one protected attribute or method that is accessed by a subclass in a different package through inheritance
// TODO: Must have proper import statements wherever classes cross package boundaries
// TODO: Must have a fully working Main.java that demonstrates the system end-to-end
// TODO: Must have at least 6 classes total across all packages
// TODO: The system must make real-world logical sense — classes and their relationships should feel natural


// TODO: YOU LEFT ON RELATIVES (TRYING TO THINK WHAT SHOULD BE DIFFERENT TO A FAMILY MEMBER AND A RELATIVE
