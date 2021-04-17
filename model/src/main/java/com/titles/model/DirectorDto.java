package com.titles.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.Objects;


public class DirectorDto {

    @JsonUnwrapped
    private Director director;

    private Float profitMultiplier;

    private Float profitAverage;

    private DirectorDto() {
    }

    public DirectorDto(Director director, Float profitMultiplier, Float profitAverage) {
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

    public Director getDirector() {
        return director;
    }

    public DirectorDto setDirector(Director director) {
        this.director = director;
        return this;
    }

    public Float getProfitMultiplier() {
        return profitMultiplier;
    }

    public DirectorDto setProfitMultiplier(float profitMultiplier) {
        this.profitMultiplier = profitMultiplier;
        return this;
    }

    public Float getProfitAverage() {
        return profitAverage;
    }

    public DirectorDto setProfitAverage(float profitAverage) {
        this.profitAverage = profitAverage;
        return this;
    }
}
