import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Optional;


public class DirectorDao implements Dao<Director> {

    private static final String SQL_FIND_ALL = "SELECT * FROM director";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM director WHERE director_id = :director_id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Director> rowMapper = BeanPropertyRowMapper.newInstance(Director.class);

    public DirectorDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Director> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
    }

    @Override
    public Optional<Director> findById(int id) {
        return Optional.empty();
    }

    @Override
    public int update(Director entity) {
        return 0;
    }

    @Override
    public int create(Director entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
