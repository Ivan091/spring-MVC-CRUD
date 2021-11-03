package edu.titles.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;


@Value
public class Title {

    @Id
    @With
    Integer titleId;

    String name;

    Double budget;

    Integer runtime;

    Double boxOffice;

    LocalDate premiereDate;

    public static Title of(String name, Double budget, Integer runtime, Double boxOffice, LocalDate premiereDate){
        return new Title(null, name, budget, runtime, boxOffice, premiereDate);
    }
}
