package com.titles.model;

import java.time.LocalDate;
import java.util.Objects;


public class Director {

    private String name;

    private String surname;

    private LocalDate birthDate;

    private Integer directorId;

    private Director() {
    }

    public Director(String name, String surname, LocalDate birthDate) {
        this(0, name, surname, birthDate);
    }

    public Director(Integer directorId, String name, String surname, LocalDate birthDate) {
        this.directorId = directorId;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorId, name, surname, birthDate);
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
        return directorId.equals(director.directorId) && Objects.equals(name, director.name) && Objects.equals(surname, director.surname) && Objects.equals(birthDate, director.birthDate);
    }

    @Override
    public String toString() {
        return "model.Director{" +
                "id=" + directorId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public Director setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Director setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Director setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public Director setDirectorId(int directorId) {
        this.directorId = directorId;
        return this;
    }
}
