package dao.factories;

import java.util.Map;
import java.util.Optional;


public interface DaoFactory<T> {

    Optional<T> create(Map<String, Object> sqlMap);
}
