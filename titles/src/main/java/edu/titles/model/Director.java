package edu.titles.model;

import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import java.time.LocalDate;
import java.util.Set;


@Value
public class Director {

    @Id
    @With
    Integer directorId;

    String name;

    String surname;

    LocalDate birthDate;

    @MappedCollection(idColumn = "TITLE_ID")
    Set<Title> titles;

    public static Director of(String name, String surname, LocalDate birthDate, Set<Title> directors) {
        return new Director(null, name, surname, birthDate, directors);
    }

    public DirectorWithAverageParams calculateAverageParams() {
        var averageBudget =
                titles.stream().mapToDouble(Title::getBudget).average().orElse(0);
        var averageBoxOffice =
                titles.stream().mapToDouble(Title::getBoxOffice).average().orElse(0);
        var profitMultiplier = averageBoxOffice / averageBudget;
        var profitAverage = (averageBoxOffice - averageBudget) / titles.size();
        return new DirectorWithAverageParams(withoutTitles(), profitMultiplier, profitAverage);
    }

    public DirectorWithoutTitles withoutTitles() {
        return new DirectorWithoutTitles(directorId, name, surname, birthDate);
    }

    public Director update(DirectorWithoutTitles directorWithoutTitles){
        return new Director(directorId, directorWithoutTitles.getName(), directorWithoutTitles.getSurname(), directorWithoutTitles.getBirthDate(),
                titles);
    }
}
