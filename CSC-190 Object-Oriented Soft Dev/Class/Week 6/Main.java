// Creation Date: March 03, 2026. at 10:47 AM
// Last Modified: March 03, 2026. at 11:05 AM

public class Main {
    public static void main(String[] args) {
        // =============== CONSTRUCTOR 1 ===============
        Time test01 = new Time(); // no args

        System.out.println("Display 01");
        System.out.println("Seconds: "+test01.getSecond());
        System.out.println("Minutes: "+test01.getMinute());
        System.out.println("Hours: "+test01.getHour());
        System.out.println(" "); // Space for Readability

        // =============== CONSTRUCTOR 2 ===============
        Time test02 = new Time(938348383);

        System.out.println("Display 02");
        System.out.println("Seconds: "+test02.getSecond());
        System.out.println("Minutes: "+test02.getMinute());
        System.out.println("Hours: "+test02.getHour());
        System.out.println(" "); // Space for Readability

        // =============== CONSTRUCTOR 3 ===============
        Time test03 = new Time(5, 23, 55);

        System.out.println("Display 03");
        System.out.println("Seconds: "+test02.getSecond());
        System.out.println("Minutes: "+test02.getMinute());
        System.out.println("Hours: "+test02.getHour());
        System.out.println(" "); // Space for Readability
    }
}
