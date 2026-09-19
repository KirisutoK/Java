// Creation Date: June 10, 2026. at 9:07 PM
// Last Modified: September 18, 2026. at  9:04 PM

import java.time.LocalDate;
import java.time.Period;

public class TimeUtils {

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public static String toStringBirthday(LocalDate Birthday) {
        return Birthday.getMonth()+" "+ Birthday.getDayOfMonth()+", "+ Birthday.getYear();
    }
    public static int getAge(LocalDate Birthday) {
        return Period.between(Birthday, LocalDate.now()).getYears();
    }

}
