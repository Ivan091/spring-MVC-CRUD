package com.titles.dao;

import com.titles.model.UserDto;


public interface UserDtoDao {

    Boolean isRegistered(UserDto userDto);
}
