package com.titles.dao;

import com.titles.model.Director;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.*;


public class DirectorDao implements Dao<Director> {

    private final static String SQL_FIND_ALL =
            "SELECT * FROM director";

    private final static String SQL_FIND_BY_ID =
            "SELECT * FROM director WHERE director_id = :director_id";

    private final static String SQL_CREATE =
            "INSERT INTO director (name, surname, birth_date) VALUES (:name, :surname, :birth_date)";

    private final static String SQL_DELETE =
            "DELETE FROM director WHERE director_id = :director_id";

    private final static String SQL_UPDATE =
            "UPDATE director SET name = :name, surname = :surname, birth_date = :birth_date WHERE director_id = :director_id";

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectorDao.class);

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
        LOGGER.debug("Find all directors");
        return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
    }

    @Override
    public Optional<Director> findById(int id) {
        LOGGER.debug("Find director by id: {}", id);
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, sqlParameterSource, rowMapper));
        } catch (EmptyResultDataAccessException e) {
            LOGGER.debug("Director was not found by id: {}", id);
            return Optional.empty();
        }
    }

    @Override
    public int update(Director entity) {
        LOGGER.debug("Update director: {}", entity);
        var keyHolder = new GeneratedKeyHolder();
        var sqlParameterSource = new MapSqlParameterSource()
                .addValue("director_id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("surname", entity.getSurname())
                .addValue("birth_date", entity.getBirthDate());
        jdbcTemplate.update(SQL_UPDATE, sqlParameterSource, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public int create(Director entity) {
        LOGGER.debug("Create director: {}", entity);
        var keyHolder = new GeneratedKeyHolder();
        var sqlParameterSource = new MapSqlParameterSource()
                .addValue("name", entity.getName())
                .addValue("surname", entity.getSurname())
                .addValue("birth_date", entity.getBirthDate());
        jdbcTemplate.update(SQL_CREATE, sqlParameterSource, keyHolder);
        var newId = Objects.requireNonNull(keyHolder.getKey()).intValue();
        entity.setId(newId);
        return newId;
    }

    @Override
    public int delete(int id) {
        LOGGER.debug("Delete director by id: {}", id);
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        var affectedRowsCount = jdbcTemplate.update(SQL_DELETE, sqlParameterSource);
        if (affectedRowsCount == 0) {
            LOGGER.debug("Director was not found by id: {}, so was not deleted", id);
        }
        return affectedRowsCount;
    }
}
