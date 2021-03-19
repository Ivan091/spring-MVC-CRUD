package com.titles.dao.director;

import com.titles.model.DirectorDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.FileCopyUtils;
import java.io.*;
import java.util.Optional;


public class DirectorDtoDaoAggregator extends DirectorDao implements DirectorDtoDao {

    private final RowMapper<DirectorDto> rowMapper =
            (rs, i) -> new DirectorDto
                    (
                            rs.getInt("director_id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getDate("birth_date"),
                            rs.getFloat("profit_multiplier"),
                            rs.getFloat("profit_average")
                    );

    @Value("classpath:director/director_profit.sql")
    private Resource FIND_ALL_CALCULATING_PROFIT;

    public DirectorDtoDaoAggregator(NamedParameterJdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public Optional<DirectorDto> findByIdCalculatingProfit(int id) {
        var sqlParameterSource = new MapSqlParameterSource("director_id", id);
        var directorsDto = jdbcTemplate.query(asString(FIND_ALL_CALCULATING_PROFIT), sqlParameterSource, rowMapper);
        var directorDto = DataAccessUtils.uniqueResult(directorsDto);

        if (directorDto != null) {
            LOGGER.debug("DirectorDto was found by id: {}", directorDto);
            return Optional.of(directorDto);
        } else {
            LOGGER.debug("Director was not found by id: {}", id);
            return Optional.empty();
        }
    }

    private static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream())) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
