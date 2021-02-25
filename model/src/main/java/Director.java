import java.time.LocalDate;
import java.util.Objects;


public class Director {

    private final int directorId;

    private final String name;

    private final String surname;

    private final LocalDate birthDate;

    public Director(int directorId, String name, String surname, LocalDate birthDate) {
        this.directorId = directorId;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId, name, surname, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Director director = (Director) o;
        return directorId == director.directorId && Objects.equals(name, director.name) && Objects.equals(surname, director.surname) && Objects.equals(birthDate, director.birthDate);
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorId=" + directorId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public int getDirectorId() {
        return directorId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
