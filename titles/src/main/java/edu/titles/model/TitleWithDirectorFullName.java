package edu.titles.model;

import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import java.time.LocalDate;


@Value
@With
public class TitleWithDirectorFullName {

    @Id
    @With
    Integer titleId;

    String name;

    Double budget;

    Integer runtime;

    Double boxOffice;

    LocalDate premiereDate;

    String directorFullName;
}
