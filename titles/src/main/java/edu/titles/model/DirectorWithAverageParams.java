package edu.titles.model;

import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;


@Value
public class DirectorWithAverageParams {

    @Id
    @With
    Integer directorId;

    String name;

    String surname;

    LocalDate birthDate;

    Double profitAverage;

    Double profitMultiplier;

    public Director toDirector(){
        return new Director(directorId, name, surname, birthDate);
    }
}
