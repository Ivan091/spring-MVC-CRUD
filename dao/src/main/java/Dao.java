import java.util.List;


public interface Dao<T> {

    List<T> findAll();

    T findById(int id);

    int update(T entity);

    int create(T entity);

    int delete(int id);
}
