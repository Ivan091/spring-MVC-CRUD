package com.titles.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.Objects;


public class TitleWithDirectorFullNameDto {

    @JsonUnwrapped
    Title title;

    String directorFullName;

    private TitleWithDirectorFullNameDto() {
    }

    public TitleWithDirectorFullNameDto(Title title, Integer directorId, String directorFullName) {
        this.title = title;
        this.directorFullName = directorFullName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, directorFullName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TitleWithDirectorFullNameDto that = (TitleWithDirectorFullNameDto) o;
        return Objects.equals(title, that.title) && Objects.equals(directorFullName, that.directorFullName);
    }

    @Override
    public String toString() {
        return "TitleWithDirectorFullNameDto{" +
                "title=" + title +
                ", directorFullName='" + directorFullName + '\'' +
                '}';
    }

    public Title getTitle() {
        return title;
    }

    public TitleWithDirectorFullNameDto setTitle(Title title) {
        this.title = title;
        return this;
    }

    public String getDirectorFullName() {
        return directorFullName;
    }

    public TitleWithDirectorFullNameDto setDirectorFullName(String directorFullName) {
        this.directorFullName = directorFullName;
        return this;
    }
}
