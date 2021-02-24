import java.time.LocalDate;


public record Director(int directorId,
                       String name,
                       String surname,
                       LocalDate birthDate) {

}
