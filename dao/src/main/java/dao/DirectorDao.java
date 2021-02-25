package dao;

import dao.factories.DaoFactory;
import dao.factories.DirectorFactory;
import model.Director;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.*;


public class DirectorDao implements Dao<Director> {

    private static final String SQL_FIND_ALL = "SELECT * FROM director";

    private static final String SQL_FIND_BY_ID = "SELECT * FROM director WHERE director_id = :director_id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Map<String, Object>> rowMapper = new ColumnMapRowMapper();

    private final DaoFactory<Director> directorDaoFactory = new DirectorFactory();

    public DirectorDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Director> findAll() {
        var listOfMaps = jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
        var instances = new ArrayList<Director>(listOfMaps.size());
        for (var item : listOfMaps) {
            instances.add(directorDaoFactory.create(item));
        }
        return instances;
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
