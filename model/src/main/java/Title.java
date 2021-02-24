import java.time.LocalDate;
import java.time.LocalTime;


public record Title(int titleId,
                    int directorId,
                    long budget,
                    LocalDate premiereDate,
                    LocalTime runtime,
                    long boxOffice) {

}
