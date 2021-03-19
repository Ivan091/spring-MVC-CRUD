package com.titles.dao;

import com.titles.model.Director;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import java.util.*;


@Component
@PropertySource("classpath:director/director.properties")
public class DirectorDao implements Dao<Director> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DirectorDao.class);

    protected final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Director> rowMapper =
            (rs, i) -> new Director(
                    rs.getInt("director_id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getDate("birth_date")
            );

    @Value("${director.selectAll}")
    private String SQL_FIND_ALL;

    @Value("${director.findById}")
    private String SQL_FIND_BY_ID;

    @Value("${director.create}")
    private String SQL_CREATE;

    @Value("${director.delete}")
    private String SQL_DELETE;

    @Value("${director.update}")
    private String SQL_UPDATE;

    @Value("${director.count}")
    private String SQL_COUNT;

    @Autowired
    public DirectorDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Director> findAll() {
        var directors = jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
        LOGGER.debug("Finding all directors ({} found)", directors.size());
        return directors;
    }

    @Override
    public Optional<Director> findById(int id) {
        LOGGER.debug("Finding director by id: {}", id);
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        var director = DataAccessUtils.uniqueResult((jdbcTemplate.query(SQL_FIND_BY_ID, sqlParameterSource, rowMapper)));

        if (director != null) {
            LOGGER.debug("Director was found by id: {}", director);
            return Optional.of(director);
        } else {
            LOGGER.debug("Director was not found by id: {}", id);
            return Optional.empty();
        }
    }

    @Override
    public int update(Director entity) {
        LOGGER.debug("Updating director: {}", entity);
        var sqlParameterSource = new MapSqlParameterSource()
                .addValue("director_id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("surname", entity.getSurname())
                .addValue("birth_date", entity.getBirthDate());
        return jdbcTemplate.update(SQL_UPDATE, sqlParameterSource);
    }

    @Override
    public int create(Director entity) {
        LOGGER.debug("Creating director: {}", entity);
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
        LOGGER.debug("Deleting director by id: {}", id);
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        var affectedRowsCount = jdbcTemplate.update(SQL_DELETE, sqlParameterSource);
        if (affectedRowsCount == 0) {
            LOGGER.debug("Director was not found by id: {}, so was not deleted", id);
        }
        return affectedRowsCount;
    }

    @Override
    public int count() {
        var count = jdbcTemplate.queryForObject(SQL_COUNT, new HashMap<>(), Integer.class);
        LOGGER.debug("Counting rows in director table ({} rows found)", count);
        return count == null ? 0 : count;
    }
}
