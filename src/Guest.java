import java.time.LocalDate;

public class Guest {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return (int) java.time.temporal.ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

}
