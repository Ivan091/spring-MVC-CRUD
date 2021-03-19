package com.titles.model;

import java.sql.Date;
import java.util.Objects;


public class Director {

    protected int id;

    protected String name;

    protected String surname;

    protected Date birthDate;

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

    public int getId() {
        return id;
    }

    public Director setId(int id) {
        this.id = id;
        return this;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public Director setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}
