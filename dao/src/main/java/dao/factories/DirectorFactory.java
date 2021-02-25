package dao.factories;

import model.Director;

import java.util.Map;


public class DirectorFactory implements DaoFactory<Director> {

    @Override
    public Director create(Map<String, Object> sqlMap) {
        return new Director(
                (int) sqlMap.get("director_id"),
                (String) sqlMap.get("name"),
                (String) sqlMap.get("surname"),
                (java.sql.Date) sqlMap.get("birth_date")
        );
    }
}
