import java.util.List;
import java.util.Optional;


public interface Dao<T> {

    List<T> findAll();

    Optional<T> findById(int id);

    int update(T entity);

    int create(T entity);

    int delete(int id);
}
