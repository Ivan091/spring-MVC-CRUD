package dao.factories;

import model.Director;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;


public class DirectorDaoFactory implements DaoFactory<Director> {

    @Override
    public Optional<Director> create(Map<String, Object> sqlMap) {
        try {
            var director = new Director(
                    (int) sqlMap.get("director_id"),
                    (String) sqlMap.get("name"),
                    (String) sqlMap.get("surname"),
                    (Date) sqlMap.get("birth_date")
            );
            return Optional.of(director);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}
