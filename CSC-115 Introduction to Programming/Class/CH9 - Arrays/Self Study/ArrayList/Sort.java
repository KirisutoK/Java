// Creation Date: March 14, 2026. at 10:56 PM
// Last Modified: March 14, 2026. at 10:58 PM

import java.util.ArrayList;

public class Sort {
    public static void main (String[] args) {
        ArrayList<Integer> TestNames = new ArrayList<>();

        TestNames.add(3);
        TestNames.add(4);
        TestNames.add(10);
        TestNames.add(2);
        TestNames.add(8);

        System.out.println(TestNames.toString());

        TestNames.sort(null);

        System.out.println(TestNames.toString());
    }
}
