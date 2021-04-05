package com.titles.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.Objects;


public class DirectorDto {

    @JsonUnwrapped
    private final Director director;

    private final float profitMultiplier;

    private final float profitAverage;

    public DirectorDto(Director director, float profitMultiplier, float profitAverage) {
        this.director = director;
        this.profitMultiplier = profitMultiplier;
        this.profitAverage = profitAverage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, profitMultiplier, profitAverage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DirectorDto that = (DirectorDto) o;
        return Float.compare(that.profitMultiplier, profitMultiplier) == 0 && Float.compare(that.profitAverage, profitAverage) == 0 && Objects.equals(director, that.director);
    }

    @Override
    public String toString() {
        return "DirectorDto{" +
                "director=" + director +
                ", profitMultiplier=" + profitMultiplier +
                ", profitAverage=" + profitAverage +
                '}';
    }
}
