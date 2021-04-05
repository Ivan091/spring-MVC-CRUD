package com.titles.dao;

import com.titles.model.DirectorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public class DirectorDaoAggregator implements DirectorDtoDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectorDaoAggregator.class);

    private final RowMapper<DirectorDto> rowMapper;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Value("classpath:director/director_profit.sql")
    private Resource FIND_ALL_CALCULATING_PROFIT;

    @Autowired
    public DirectorDaoAggregator(RowMapper<DirectorDto> rowMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.rowMapper = rowMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<DirectorDto> findByIdCalculatingProfit(int id) {
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        var directorsDto = jdbcTemplate.query(ResourceReader.asString(FIND_ALL_CALCULATING_PROFIT), sqlParameterSource, rowMapper);
        var directorDto = DataAccessUtils.uniqueResult(directorsDto);
        if (directorDto != null) {
            LOGGER.debug("DirectorDto was found by id: {}", directorDto);
            return Optional.of(directorDto);
        } else {
            LOGGER.debug("Director was not found by id: {}", id);
            return Optional.empty();
        }
    }
}
