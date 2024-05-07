import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Animal {
    private LocalDate birthday;
    private String name;

    public Animal(LocalDate birthday, String name) {
        this.birthday = birthday;
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public long daysUntilNextBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthday.withYear(today.getYear());

        if (today.equals(nextBirthday)) {
            return 0;
        }

        if (today.isBefore(nextBirthday)) {
            return ChronoUnit.DAYS.between(today, nextBirthday);
        } else {
            nextBirthday = birthday.withYear(today.getYear() + 1);
            return ChronoUnit.DAYS.between(today, nextBirthday);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(birthday, animal.birthday) && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday, name);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "birthday=" + birthday +
                ", name='" + name + '\'' +
                '}';
    }
}
