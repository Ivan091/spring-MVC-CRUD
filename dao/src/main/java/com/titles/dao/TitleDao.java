package com.titles.dao;

import com.titles.model.Title;
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
@PropertySource("classpath:title.properties")
public class TitleDao implements Dao<Title> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TitleDao.class);

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final RowMapper<Title> rowMapper;

    @Value("${title.findAll}")
    private String FIND_ALL;

    @Value("${title.findById}")
    private String FIND_BY_ID;

    @Value("${title.create}")
    private String CREATE;

    @Value("${title.delete}")
    private String DELETE;

    @Value("${title.update}")
    private String UPDATE;

    @Value("${title.count}")
    private String COUNT;

    @Autowired
    public TitleDao(NamedParameterJdbcTemplate jdbcTemplate, RowMapper<Title> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public List<Title> findAll() {
        var titles = jdbcTemplate.query(FIND_ALL, rowMapper);
        LOGGER.debug("Finding all titles ({} found)", titles.size());
        return titles;
    }

    @Override
    public Optional<Title> findById(Integer id) {
        LOGGER.debug("Finding title by id: {}", id);
        var sqlParameterSource = generateIdMapSqlParameterSource(id);
        var title = DataAccessUtils.uniqueResult((jdbcTemplate.query(FIND_BY_ID, sqlParameterSource, rowMapper)));
        if (title != null) {
            LOGGER.debug("Title was found by id: {}", title);
            return Optional.of(title);
        } else {
            LOGGER.debug("Title was not found by id: {}", id);
            return Optional.empty();
        }
    }

    @Override
    public Integer update(Title entity) {
        LOGGER.debug("Updating title: {}", entity);
        var sqlParameterSource = generateMapSqlParameterSource(entity);
        return jdbcTemplate.update(UPDATE, sqlParameterSource);
    }

    @Override
    public Integer create(Title entity) {
        var sqlParameterSource = generateMapSqlParameterSource(entity);
        var keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(CREATE, sqlParameterSource, keyHolder);
        var newId = Objects.requireNonNull(keyHolder.getKey()).intValue();
        entity.setId(newId);
        LOGGER.debug("Creating title: {}", entity);
        return newId;
    }

    @Override
    public Integer delete(Integer id) {
        LOGGER.debug("Deleting title by id: {}", id);
        var sqlParameterSource = generateIdMapSqlParameterSource(id);
        var affectedRowsCount = jdbcTemplate.update(DELETE, sqlParameterSource);
        if (affectedRowsCount == 0) {
            LOGGER.debug("Title was not found by id: {}, so was not deleted", id);
        }
        return affectedRowsCount;
    }

    @Override
    public Integer count() {
        var count = jdbcTemplate.queryForObject(COUNT, new HashMap<>(), Integer.class);
        LOGGER.debug("Counting rows in title table ({} rows found)", count);
        return count == null ? 0 : count;
    }

    private MapSqlParameterSource generateMapSqlParameterSource(Title entity) {
        return new MapSqlParameterSource()
                .addValue("title_id", entity.getId())
                .addValue("name", entity.getName())
                .addValue("budget", entity.getBudget())
                .addValue("premiere_date", entity.getPremiereDate())
                .addValue("runtime", entity.getRuntime())
                .addValue("box_office", entity.getBoxOffice())
                .addValue("director_id", entity.getDirectorId());
    }

    private MapSqlParameterSource generateIdMapSqlParameterSource(Integer id) {
        return new MapSqlParameterSource("title_id", id);
    }
}
