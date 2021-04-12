package com.titles.dao;

import com.titles.dao.util.ResourceReader;
import com.titles.model.TitleWithDirectorFullNameDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class TitleDaoDirectorAggregator implements TitleDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectorDaoProfitAggregator.class);

    private final RowMapper<TitleWithDirectorFullNameDto> rowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String FIND_ALL_CALCULATING_PROFIT;

    public TitleDaoDirectorAggregator(RowMapper<TitleWithDirectorFullNameDto> rowMapper, NamedParameterJdbcTemplate jdbcTemplate, ResourceReader resourceReader) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.FIND_ALL_CALCULATING_PROFIT = resourceReader.readFileToString("title-with-director-full-name.sql");
    }

    public List<TitleWithDirectorFullNameDto> findAllTitlesWithDirectorFullName() {
        var titles = jdbcTemplate.query(FIND_ALL_CALCULATING_PROFIT, rowMapper);
        LOGGER.debug("Finding titles with directors' full names ({} found)", titles.size());
        return titles;
    }
}
