import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime inTwoWeeks = now.plusWeeks(2);
        System.out.println(inTwoWeeks.toLocalDate());

        LocalDate berlinaleStart2025 = LocalDate.of(2025, 2, 13);

        if (berlinaleStart2025.isAfter(now.toLocalDate())) {
            long daysUntilBerlinale25 = ChronoUnit.DAYS.between(now.toLocalDate(), berlinaleStart2025);
            if (daysUntilBerlinale25 == 1) {
                System.out.println("Berlinale 2025 is yet to come in " + daysUntilBerlinale25 + " day.");
            } else {
                System.out.println("Berlinale 2025 is yet to come in " + daysUntilBerlinale25 + " days.");
            }
        } else if (berlinaleStart2025.isBefore(now.toLocalDate())) {
            long daysSinceBerlinale25 = ChronoUnit.DAYS.between(berlinaleStart2025, now.toLocalDate());
            if (daysSinceBerlinale25 == 1) {
                System.out.println("Berlinale 2025 already started " + daysSinceBerlinale25 + " day ago.");
            } else {
                System.out.println("Berlinale 2025 already started " + daysSinceBerlinale25 + " days ago.");
            }
        } else {
            System.out.println("Berlinale 2025 is starting today");
        }
    }
}
