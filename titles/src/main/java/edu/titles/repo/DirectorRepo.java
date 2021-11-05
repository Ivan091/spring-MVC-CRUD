package edu.titles.repo;

import edu.titles.model.Director;
import edu.titles.model.DirectorWithAverageParams;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface DirectorRepo extends CrudRepository<Director, Integer> {

    @Query("""
            SELECT d.director_id,
                   d.name,
                   d.surname,
                   d.birth_date,
                   AVG(box_office / budget) as profit_multiplier,
                   AVG(box_office - budget) as profit_average
            FROM director d
                     LEFT JOIN title t on d.director_id = t.director_id
            GROUP BY d.director_id
            """)
    List<DirectorWithAverageParams> findDirectorCalculatingAverageParams();
}
