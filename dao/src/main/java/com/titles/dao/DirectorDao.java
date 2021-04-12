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
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
@PropertySource("classpath:director.properties")
public class DirectorDao implements Dao<Director> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(DirectorDao.class);

    protected final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Director> rowMapper;

    @Value("${director.findAll}")
    private String FIND_ALL;

    @Value("${director.findById}")
    private String FIND_BY_ID;

    @Value("${director.create}")
    private String CREATE;

    @Value("${director.delete}")
    private String DELETE;

    @Value("${director.update}")
    private String UPDATE;

    @Value("${director.count}")
    private String COUNT;

    @Autowired
    public DirectorDao(NamedParameterJdbcTemplate jdbcTemplate, RowMapper<Director> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Director> findAll() {
        var directors = jdbcTemplate.query(FIND_ALL, rowMapper);
        LOGGER.debug("Finding all directors ({} found)", directors.size());
        return directors;
    }

    @Override
    public Optional<Director> findById(Integer id) {
        LOGGER.debug("Finding director by id: {}", id);
        var sqlParameterSource = generateIdMapSqlParameterSource(id);
        var director = DataAccessUtils.uniqueResult((jdbcTemplate.query(FIND_BY_ID, sqlParameterSource, rowMapper)));
        if (director != null) {
            LOGGER.debug("Director was found by id: {}", director);
            return Optional.of(director);
        } else {
            LOGGER.debug("Director was not found by id: {}", id);
            return Optional.empty();
        }
    }

    @Override
    public Integer update(Director entity) {
        LOGGER.debug("Updating director: {}", entity);
        var sqlParameterSource = generateMapSqlParameterSource(entity);
        return jdbcTemplate.update(UPDATE, sqlParameterSource);
    }

    @Override
    public Integer create(Director entity) {
        LOGGER.debug("Creating director: {}", entity);
        var keyHolder = new GeneratedKeyHolder();
        var sqlParameterSource = generateMapSqlParameterSource(entity);
        jdbcTemplate.update(CREATE, sqlParameterSource, keyHolder);
        var newId = Objects.requireNonNull(keyHolder.getKey()).intValue();
        entity.setDirectorId(newId);
        return newId;
    }

    @Override
    public Integer delete(Integer id) {
        LOGGER.debug("Deleting director by id: {}", id);
        var sqlParameterSource = generateIdMapSqlParameterSource(id);
        var affectedRowsCount = jdbcTemplate.update(DELETE, sqlParameterSource);
        if (affectedRowsCount == 0) {
            LOGGER.debug("Director was not found by id: {}, so was not deleted", id);
        }
        return affectedRowsCount;
    }

    @Override
    public Integer count() {
        var count = jdbcTemplate.queryForObject(COUNT, new HashMap<>(), Integer.class);
        LOGGER.debug("Counting rows in director table ({} rows found)", count);
        return count == null ? 0 : count;
    }

    private MapSqlParameterSource generateMapSqlParameterSource(Director entity) {
        return new MapSqlParameterSource()
                .addValue("director_id", entity.getDirectorId())
                .addValue("name", entity.getName())
                .addValue("surname", entity.getSurname())
                .addValue("birth_date", entity.getBirthDate());
    }

    private MapSqlParameterSource generateIdMapSqlParameterSource(Integer id) {
        return new MapSqlParameterSource("director_id", id);
    }
}
