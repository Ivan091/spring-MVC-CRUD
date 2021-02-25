package dao;

import model.Director;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.*;


public class DirectorDao implements Dao<Director> {

    private final static String SQL_FIND_ALL = "SELECT * FROM director";

    private final static String SQL_FIND_BY_ID = "SELECT * FROM director WHERE director_id = :director_id";

    private final static String SQL_CREATE =
            "INSERT INTO director (name, surname, birth_date) VALUES (:name, :surname, :birth_date)";

    private final static String SQL_DELETE =
            "DELETE FROM director WHERE director_id = :director_id";

    private final static String SQL_UPDATE =
            "UPDATE director SET name = :name, surname = :surname, birth_date = :birth_date WHERE director_id = :director_id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Director> rowMapper =
            (rs, i) -> new Director(
                    rs.getInt("director_id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getDate("birth_date")
            );

    public DirectorDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Director> findAll() {
        return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
    }

    @Override
    public Optional<Director> findById(int id) {
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, sqlParameterSource, rowMapper));
        } catch (IncorrectResultSizeDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public int update(Director entity) {
        var keyHolder = new GeneratedKeyHolder();
        var sqlParameterSource = new MapSqlParameterSource(Map.of(
                "director_id", entity.getDirectorId(),
                "name", entity.getName(),
                "surname", entity.getSurname(),
                "birth_date", entity.getBirthDate()
        ));
        jdbcTemplate.update(SQL_CREATE, sqlParameterSource, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public int create(Director entity) {
        var keyHolder = new GeneratedKeyHolder();
        var sqlParameterSource = new MapSqlParameterSource(Map.of(
                "name", entity.getName(),
                "surname", entity.getSurname(),
                "birth_date", entity.getBirthDate()
        ));
        jdbcTemplate.update(SQL_UPDATE, sqlParameterSource, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public int delete(int id) {
        var keyHolder = new GeneratedKeyHolder();
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        jdbcTemplate.update(SQL_DELETE, sqlParameterSource, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey() == null ? 0 : keyHolder.getKey()).intValue();
    }
}
