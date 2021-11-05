package edu.titles.model;

import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;


@Value
@Table("DIRECTOR")
public class Director {

    @Id
    @With
    Integer directorId;

    String name;

    String surname;

    LocalDate birthDate;

    public static Director of(String name, String surname, LocalDate birthDate) {
        return new Director(null, name, surname, birthDate);
    }
}
