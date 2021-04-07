package com.titles.dao;

import com.titles.dao.util.ResourceReader;
import com.titles.model.DirectorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class DirectorDaoProfitAggregator implements DirectorDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectorDaoProfitAggregator.class);

    private final RowMapper<DirectorDto> rowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private final String FIND_ALL_CALCULATING_PROFIT;

    @Autowired
    public DirectorDaoProfitAggregator(NamedParameterJdbcTemplate jdbcTemplate, RowMapper<DirectorDto> rowMapper, ResourceReader resourceReader) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
        FIND_ALL_CALCULATING_PROFIT = resourceReader.readFileToString("director-profit.sql");
    }

    @Override
    public List<DirectorDto> findAllCalculatingProfit() {
        var directorsDto = jdbcTemplate.query(FIND_ALL_CALCULATING_PROFIT, rowMapper);
        LOGGER.debug("Finding directors calculating average profit ({} found)", directorsDto.size());
        return directorsDto;
    }
}
