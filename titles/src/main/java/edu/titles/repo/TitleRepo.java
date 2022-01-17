package edu.titles.repo;

import edu.titles.model.Title;
import edu.titles.model.TitleWithDirectorFullName;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;


public interface TitleRepo extends CrudRepository<Title, Integer> {

    @Query("""
            SELECT t.name,
                   t.box_office,
                   t.budget,
                   t.premiere_date,
                   t.runtime,
                   t.title_id,
                   d.director_id,
                   CONCAT(d.name, ' ', d.surname) as director_full_name
            FROM title t
                    LEFT JOIN director d on d.director_id = t.director_id
            GROUP BY t.title_id, t.name
            ORDER BY t.name
            """)
    List<TitleWithDirectorFullName> findWithAverageParams();

    @Query("""
            SELECT t.name,
                   t.box_office,
                   t.budget,
                   t.premiere_date,
                   t.runtime,
                   t.title_id,
                   d.director_id,
                   CONCAT(d.name, ' ', d.surname) as director_full_name
            FROM title t
                     LEFT JOIN director d
                               ON d.director_id = t.director_id
            WHERE t.premiere_date BETWEEN :start_date AND :end_date
            ORDER BY t.name
            """)
    List<TitleWithDirectorFullName> findWithAverageParamsBetween(@Param("start_date") LocalDate startDate, @Param("end_date") LocalDate endDate);
}
