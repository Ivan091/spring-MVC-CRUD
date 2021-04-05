package com.titles.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;


public class Title {

    private Integer id;

    private String name;

    private Float budget;

    private Float boxOffice;

    private Date premiereDate;

    @JsonFormat(pattern = "HH:MM:SS")
    private Time runtime;

    private Integer directorId;

    public Title() {
    }

    public Title(Integer id, String name, Float budget, Float boxOffice, Date premiereDate, Time runtime, Integer directorId) {
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
        return Objects.hash(id, budget, premiereDate, runtime, boxOffice);
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
        return id.equals(title.id) && budget.equals(title.budget) && boxOffice.equals(title.boxOffice) && Objects.equals(premiereDate, title.premiereDate) && Objects.equals(runtime, title.runtime);
    }

    @Override
    public String
    toString() {
        return "model.Title{" +
                "titleId=" + id +
                ", budget=" + budget +
                ", premiereDate=" + premiereDate +
                ", runtime=" + runtime +
                ", boxOffice=" + boxOffice +
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

    public Date getPremiereDate() {
        return premiereDate;
    }

    public Title setPremiereDate(Date premiereDate) {
        this.premiereDate = premiereDate;
        return this;
    }

    public Time getRuntime() {
        return runtime;
    }

    public Title setRuntime(Time runtime) {
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
