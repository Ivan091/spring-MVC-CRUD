package com.titles.model;

import java.sql.Date;
import java.util.Objects;


public class Director {

    private final String name;

    private final String surname;

    private final Date birthDate;

    private final int id;

    public Director(int id, String name, String surname, Date birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Director director = (Director) o;
        return id == director.id && Objects.equals(name, director.name) && Objects.equals(surname, director.surname) && Objects.equals(birthDate, director.birthDate);
    }

    @Override
    public String toString() {
        return "model.Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
