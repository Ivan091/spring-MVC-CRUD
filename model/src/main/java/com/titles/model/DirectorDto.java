package com.titles.model;

import java.sql.Date;
import java.util.Objects;


public class DirectorDto extends Director {

    private float profitMultiplier;

    private float profitAverage;

    public DirectorDto(int id, String name, String surname, Date birthDate, float profitMultiplier, float profitAverage) {
        super(id, name, surname, birthDate);
        this.profitMultiplier = profitMultiplier;
        this.profitAverage = profitAverage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), profitMultiplier, profitAverage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        DirectorDto that = (DirectorDto) o;
        return Float.compare(that.profitMultiplier, profitMultiplier) == 0 && Float.compare(that.profitAverage, profitAverage) == 0;
    }

    @Override
    public String toString() {
        return "DirectorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", profitMultiplier=" + profitMultiplier +
                ", profitAverage=" + profitAverage +
                '}';
    }

    public float getProfitMultiplier() {
        return profitMultiplier;
    }

    public DirectorDto setProfitMultiplier(float profitMultiplier) {
        this.profitMultiplier = profitMultiplier;
        return this;
    }

    public float getProfitAverage() {
        return profitAverage;
    }

    public DirectorDto setProfitAverage(float profitAverage) {
        this.profitAverage = profitAverage;
        return this;
    }
}
