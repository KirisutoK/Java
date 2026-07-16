// Creation Date: March 14, 2026. at 9:57 PM
// Last Modified: March 14, 2026. at 10:00 PM

import java.util.ArrayList;

public class Remove {
    public static void main(String[] args) {
        ArrayList<String> TestNames = new ArrayList<>();

        TestNames.add("Christ");
        TestNames.add("Bella");
        TestNames.add("Shan");
        TestNames.add("Kevin");
        TestNames.add("Avalyn");

        System.out.println(TestNames.toString());

        TestNames.remove("Christ");
        // or
        TestNames.remove(TestNames.indexOf("Shan"));
        // or
        TestNames.remove(0);

        System.out.println(TestNames.toString());
    }
}
