package edu.titles.api.dto;

import edu.titles.model.Title;
import edu.titles.model.TitleWithDirectorFullName;
import lombok.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import java.time.LocalDate;


@EqualsAndHashCode
@ToString
public final class TitleDto {

    @Value
    public static class Base {

        Integer titleId;

        String name;

        Double budget;

        Integer runtime;

        Double boxOffice;

        LocalDate premiereDate;

        Integer directorId;

        public static Base of(Title title) {
            return new Base(
                    title.getTitleId(),
                    title.getName(),
                    title.getBudget(),
                    title.getRuntime(),
                    title.getBoxOffice(),
                    title.getPremiereDate(),
                    title.getDirectorId().getId()
            );
        }

        public Title to() {
            return new Title(
                    titleId,
                    name,
                    budget,
                    runtime,
                    boxOffice,
                    premiereDate,
                    new AggregateReference.IdOnlyAggregateReference<>(directorId)
            );
        }
    }

    @Value
    public static class WithDirectorFullName {

        Integer titleId;

        String name;

        Double budget;

        Integer runtime;

        Double boxOffice;

        LocalDate premiereDate;

        String directorFullName;

        public static WithDirectorFullName of(TitleWithDirectorFullName titleWithDirectorFullName) {
            return new WithDirectorFullName(
                    titleWithDirectorFullName.getTitleId(),
                    titleWithDirectorFullName.getName(),
                    titleWithDirectorFullName.getBudget(),
                    titleWithDirectorFullName.getRuntime(),
                    titleWithDirectorFullName.getBoxOffice(),
                    titleWithDirectorFullName.getPremiereDate(),
                    titleWithDirectorFullName.getDirectorFullName()
            );
        }
    }
}
