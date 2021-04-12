package com.titles.dao.rowmappers;

import com.titles.model.Title;
import com.titles.model.TitleWithDirectorFullNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class TitleWithDirectorDtoRowMapper implements RowMapper<TitleWithDirectorFullNameDto> {

    private final RowMapper<Title> titleRowMapper;

    @Autowired
    public TitleWithDirectorDtoRowMapper(RowMapper<Title> titleRowMapper) {
        this.titleRowMapper = titleRowMapper;
    }

    @Override
    public TitleWithDirectorFullNameDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TitleWithDirectorFullNameDto(
                titleRowMapper.mapRow(rs, -1),
                rs.getInt("director_id"),
                rs.getString("director_full_name")
        );
    }
}
