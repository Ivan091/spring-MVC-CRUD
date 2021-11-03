package edu.titles.model;

import lombok.Value;
import java.time.LocalDate;
import java.util.HashSet;


@Value
public class DirectorWithoutTitles {

    Integer directorId;

    String name;

    String surname;

    LocalDate birthDate;

    public Director toDirector(){
        return new Director(directorId, name, surname, birthDate, new HashSet<>());
    }
}
