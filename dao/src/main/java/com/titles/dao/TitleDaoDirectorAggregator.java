package com.titles.dao;

import com.titles.dao.util.InjectFileData;
import com.titles.model.TitleWithDirectorFullNameDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;


@Repository
public class TitleDaoDirectorAggregator implements TitleDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectorDaoProfitAggregator.class);

    private final RowMapper<TitleWithDirectorFullNameDto> rowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @InjectFileData("find-add-titles-with-director-full-name.sql")
    private String FIND_ALL_WITH_DIRECTOR_FULL_NAME;

    @InjectFileData("find-all-titles-with-director-full-name-between-two-dates.sql")
    private String FIND_ALL_WITH_DIRECTOR_BETWEEN;

    public TitleDaoDirectorAggregator(RowMapper<TitleWithDirectorFullNameDto> rowMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TitleWithDirectorFullNameDto> findAllTitlesWithDirectorFullName() {
        var titles = jdbcTemplate.query(FIND_ALL_WITH_DIRECTOR_FULL_NAME, rowMapper);
        LOGGER.debug("Finding titles with directors' full names ({} found)", titles.size());
        return titles;
    }

    @Override
    public List<TitleWithDirectorFullNameDto> findAllTitlesBetween(LocalDate start, LocalDate end) {
        var mapSqlParameterSource =
                new MapSqlParameterSource("first_date", start)
                        .addValue("last_date", end);
        var titles = jdbcTemplate.query(FIND_ALL_WITH_DIRECTOR_BETWEEN, mapSqlParameterSource, rowMapper);
        LOGGER.debug("Finding titles with directors' full names between {} and {} ({} found)", start, end, titles.size());
        return titles;
    }
}
