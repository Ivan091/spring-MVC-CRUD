package com.titles.dao.rowmappers;

import com.titles.model.Director;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class DirectorRowMapper implements RowMapper<Director> {

    @Override
    public Director mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Director(
                rs.getInt("director_id"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getDate("birth_date").toLocalDate()
        );
    }
}
