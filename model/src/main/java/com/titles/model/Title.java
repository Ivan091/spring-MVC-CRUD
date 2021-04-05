package com.titles.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Title {

    private int titleId;

    private float budget;

    private float boxOffice;

    private LocalDate premiereDate;

    private LocalTime runtime;

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

    public Title setTitleId(int titleId) {
        this.titleId = titleId;
        return this;
    }

    public float getBudget() {
        return budget;
    }

    public Title setBudget(float budget) {
        this.budget = budget;
        return this;
    }

    public float getBoxOffice() {
        return boxOffice;
    }

    public Title setBoxOffice(float boxOffice) {
        this.boxOffice = boxOffice;
        return this;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public Title setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
        return this;
    }

    public LocalTime getRuntime() {
        return runtime;
    }

    public Title setRuntime(LocalTime runtime) {
        this.runtime = runtime;
        return this;
    }
}
