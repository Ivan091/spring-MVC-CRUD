package com.titles.dao.rowmappers;

import com.titles.model.Director;
import com.titles.model.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class DirectorDtoRowMapper implements RowMapper<DirectorDto> {

    private final RowMapper<Director> directorRowMapper;

    @Autowired
    public DirectorDtoRowMapper(RowMapper<Director> directorRowMapper) {
        this.directorRowMapper = directorRowMapper;
    }

    @Override
    public DirectorDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DirectorDto(
                directorRowMapper.mapRow(rs, -1),
                rs.getFloat("profit_multiplier"),
                rs.getFloat("profit_average")
        );
    }
}
