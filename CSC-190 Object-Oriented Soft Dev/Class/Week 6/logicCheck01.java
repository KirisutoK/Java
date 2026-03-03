// Creation Date: March 03, 2026. at 10:05 AM
// Last Modified: March 03, 2026. at 10:09 AM

public class logicCheck01 {
    public static void main(String[] args) {
        int totalCents = 387;

        int itemA = totalCents / 100;
        int remaining = totalCents % 100;

        int itemB = remaining / 25;
        remaining = remaining % 25;

        int itemC = remaining / 10;
        int itemD = remaining % 10;

        System.out.println(itemA + ", " + itemB + ", " + itemC + ", " + itemD);
    }
}

