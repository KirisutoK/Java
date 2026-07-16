// Creation Date: March 14, 2026. at 9:43 PM
// Last Modified: March 14, 2026. at  9:46 PM

import java.util.ArrayList;

public class Set {
    public static void main(String[] args) {
        ArrayList<String> TestNames = new ArrayList<>();

        TestNames.add("Christ");
        TestNames.add("Bella");
        TestNames.add("Shan");
        TestNames.add("Kevin");
        TestNames.add("Avalyn");

        System.out.println(TestNames.toString());
        
        TestNames.set(2, "Bella");

        System.out.println(TestNames.toString());
    }
}
