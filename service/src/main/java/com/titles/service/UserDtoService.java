package com.titles.service;

import com.titles.dao.UserDao;
import com.titles.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class UserDtoService {
    @Autowired
    private UserDao userDao;

    public Boolean isRegistered(UserDto userDto){
        return userDao.isRegistered(userDto);
    }
}
