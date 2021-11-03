package edu.titles.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;


@Value
public class TitleWithDirectorFullName {

    @JsonUnwrapped
    Title title;

    String directorFullName;
}
