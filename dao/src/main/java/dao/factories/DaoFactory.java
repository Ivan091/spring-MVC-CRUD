package dao.factories;

import java.util.Map;


public interface DaoFactory<T> {

    T create(Map<String, Object> sqlMap);
}
