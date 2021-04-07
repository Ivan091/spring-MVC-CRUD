package com.titles.model;

import java.time.LocalDate;
import java.util.Objects;


public class Title {

    private Integer id;

    private String name;

    private Float budget;

    private Float boxOffice;

    private LocalDate premiereDate;

    private Integer runtime;

    private Integer directorId;

    public Title() {
    }

    public Title(String name, Float budget, Float boxOffice, LocalDate premiereDate, Integer runtime, Integer directorId) {
        this(0, name, budget, boxOffice, premiereDate, runtime, directorId);
    }

    public Title(Integer id, String name, Float budget, Float boxOffice, LocalDate premiereDate, Integer runtime, Integer directorId) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.premiereDate = premiereDate;
        this.runtime = runtime;
        this.boxOffice = boxOffice;
        this.directorId = directorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, budget, boxOffice, premiereDate, runtime, directorId);
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
        return Objects.equals(id, title.id) && Objects.equals(name, title.name) && Objects.equals(budget, title.budget) && Objects.equals(boxOffice, title.boxOffice) && Objects.equals(premiereDate, title.premiereDate) && Objects.equals(runtime, title.runtime) && Objects.equals(directorId, title.directorId);
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", boxOffice=" + boxOffice +
                ", premiereDate=" + premiereDate +
                ", runtime=" + runtime +
                ", directorId=" + directorId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Title setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Title setName(String name) {
        this.name = name;
        return this;
    }

    public Float getBudget() {
        return budget;
    }

    public Title setBudget(Float budget) {
        this.budget = budget;
        return this;
    }

    public Float getBoxOffice() {
        return boxOffice;
    }

    public Title setBoxOffice(Float boxOffice) {
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

    public Integer getRuntime() {
        return runtime;
    }

    public Title setRuntime(Integer runtime) {
        this.runtime = runtime;
        return this;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public Title setDirectorId(Integer directorId) {
        this.directorId = directorId;
        return this;
    }
}
