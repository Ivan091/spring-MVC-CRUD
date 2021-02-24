import java.time.LocalDate;
import java.time.LocalTime;


public record Title(Integer titleId, Integer directorId, Long budget, LocalDate premiereDate, LocalTime runtime,
                    Long boxOffice) {

}
