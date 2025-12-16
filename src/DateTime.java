import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public static void main(String[] args) {

        LocalDate todaysDate = LocalDate.now();
        LocalTime todaysTime = LocalTime.now();

        LocalDate prevDate = todaysDate.minusDays(100);
        LocalDate someOtherDate = LocalDate.of(2020, 5, 15);
        LocalDate tomorrowDate = todaysDate.plusDays(1);
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Today's Date: " + todaysDate);
        System.out.println("Today's Time: " + todaysTime);
        System.out.println("Tomorrow's Day: "+ tomorrowDate);
        System.out.println(zone
        System.out.println("Date after subtracting 100 days: " + prevDate);
        System.out.println("Some Other date: " + someOtherDate);
        System.out.println("Current Date and Time: " + now.format(formatter));
    }
}
