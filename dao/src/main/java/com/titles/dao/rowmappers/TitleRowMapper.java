package com.titles.dao.rowmappers;

import com.titles.model.Title;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class TitleRowMapper implements RowMapper<Title> {

    @Override
    public Title mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Title(
                rs.getInt("title_id"),
                rs.getString("name"),
                rs.getFloat("budget"),
                rs.getFloat("box_office"),
                rs.getDate("premiere_date"),
                rs.getInt("runtime"),
                rs.getInt("director_id")
        );
    }
}
