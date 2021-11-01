package com.titles.dao.rowmappers;

import com.titles.model.Title;
import com.titles.model.UserDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public final class UserDtoRowMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet rs, int i) throws SQLException {
        return new UserDto(
                rs.getString("login"),
                rs.getString("password")
        );
    }
}
