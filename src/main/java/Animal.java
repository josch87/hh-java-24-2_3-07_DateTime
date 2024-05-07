import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Animal(LocalDate birthday, String name) {

    public long daysUntilNextBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthday.withYear(today.getYear());

        if (today.equals(nextBirthday)) {
            return 0;
        }

        if (!today.isBefore(nextBirthday)) {
            nextBirthday = birthday.withYear(today.getYear() + 1);
        }
        return ChronoUnit.DAYS.between(today, nextBirthday);
    }

}
