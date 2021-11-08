package edu.titles.model;

import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
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

    AggregateReference<Director, Integer> directorId;
}
