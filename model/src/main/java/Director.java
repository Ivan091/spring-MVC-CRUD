import java.time.LocalDate;


public record Director(Integer directorId,
                       String name,
                       String surname,
                       LocalDate birthDate) {

}
