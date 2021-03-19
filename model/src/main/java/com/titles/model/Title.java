package com.titles.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Title {

    private final int titleId;

    private final float budget;

    private final float boxOffice;

    private final LocalDate premiereDate;

    private final LocalTime runtime;

    public Title(int titleId, float budget, float boxOffice, LocalDate premiereDate, LocalTime runtime) {
        this.titleId = titleId;
        this.budget = budget;
        this.premiereDate = premiereDate;
        this.runtime = runtime;
        this.boxOffice = boxOffice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleId, budget, premiereDate, runtime, boxOffice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Title title = (Title) o;
        return titleId == title.titleId && budget == title.budget && boxOffice == title.boxOffice && Objects.equals(premiereDate, title.premiereDate) && Objects.equals(runtime, title.runtime);
    }

    @Override
    public String
    toString() {
        return "model.Title{" +
                "titleId=" + titleId +
                ", budget=" + budget +
                ", premiereDate=" + premiereDate +
                ", runtime=" + runtime +
                ", boxOffice=" + boxOffice +
                '}';
    }

    public int getTitleId() {
        return titleId;
    }

    public float getBudget() {
        return budget;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public LocalTime getRuntime() {
        return runtime;
    }

    public float getBoxOffice() {
        return boxOffice;
    }
}
