package com.titles.dao;

import com.titles.model.Title;
import com.titles.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import java.util.Objects;
import java.util.Optional;


@Repository
@PropertySource("classpath:login.properties")
public class UserDao implements UserDtoDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<UserDto> userDtoRowMapper;


    @Value("${login.isRegistered}")
    private String IS_REGISTERED;


    @Override
    public Boolean isRegistered(UserDto userDto){
        var sqlParameterSource = generateMapSqlParameterSource(userDto);
        var countNullable = jdbcTemplate.queryForObject(IS_REGISTERED, sqlParameterSource, Integer.class);
        var count = Optional.ofNullable(countNullable);
        return count.isPresent() && count.get() == 1;
    }

    private MapSqlParameterSource generateMapSqlParameterSource(UserDto entity) {
        return new MapSqlParameterSource()
                .addValue("login", entity.getLogin())
                .addValue("password", entity.getPassword());
    }
}
