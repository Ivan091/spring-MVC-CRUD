package com.titles.dao;

import com.titles.model.DirectorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class DirectorDtoDaoAggregator implements DirectorDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectorDtoDaoAggregator.class);

    private final RowMapper<DirectorDto> rowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String FIND_ALL_CALCULATING_PROFIT = ClasspathResourceReader.readFileToString("director-profit.sql");

    @Autowired
    public DirectorDtoDaoAggregator(NamedParameterJdbcTemplate jdbcTemplate, RowMapper<DirectorDto> rowMapper) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DirectorDto> findAllCalculatingProfit() {
        var directorsDto = jdbcTemplate.query(FIND_ALL_CALCULATING_PROFIT, rowMapper);
        LOGGER.debug("Finding directors calculating average profit ({} found)", directorsDto.size());
        return directorsDto;
    }
}
