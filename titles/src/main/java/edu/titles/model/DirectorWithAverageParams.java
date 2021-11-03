package edu.titles.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Value;


@Value
public class DirectorWithAverageParams {

    @JsonUnwrapped
    DirectorWithoutTitles director;

    Double profitMultiplier;

    Double profitAverage;
}
