package edu.titles.api;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import edu.titles.model.Director;
import edu.titles.model.DirectorWithAverageParams;
import lombok.*;
import java.time.LocalDate;


@EqualsAndHashCode
@ToString
public final class DirectorDto {

    @Value
    public static class WithAverageParams {

        Integer directorId;

        String name;

        String surname;

        LocalDate birthDate;

        Double profitAverage;

        Double profitMultiplier;

        public static WithAverageParams of(DirectorWithAverageParams director) {
            return new WithAverageParams(
                    director.getDirectorId(),
                    director.getName(),
                    director.getSurname(),
                    director.getBirthDate(),
                    director.getProfitAverage(),
                    director.getProfitMultiplier()
            );
        }

        public DirectorWithAverageParams to() {
            return new DirectorWithAverageParams(
                    directorId,
                    name,
                    surname,
                    birthDate,
                    profitAverage,
                    profitMultiplier
            );
        }
    }

    @Value
    public static class WithId {

        @JsonUnwrapped
        Base base;

        Integer directorId;

        public static WithId of(Director director) {
            return new WithId(
                    Base.of(director),
                    director.getDirectorId()
            );
        }

        public Director to() {
            return base.to().withDirectorId(directorId);
        }
    }

    @Value
    public static class Base {

        String name;

        String surname;

        LocalDate birthDate;

        public static Base of(Director director) {
            return new Base(
                    director.getName(),
                    director.getSurname(),
                    director.getBirthDate()
            );
        }

        public Director to() {
            return new Director(
                    null,
                    name,
                    surname,
                    birthDate
            );
        }
    }
}
