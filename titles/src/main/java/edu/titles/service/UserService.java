package edu.titles.service;

import edu.titles.api.dto.UserDto;
import edu.titles.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class UserService {

    @Autowired
    private UserRepo userRepo;

    public Boolean isRegistered(UserDto.Base user) {
        var userOpt = userRepo.findByLogin(user.getLogin());
        return userOpt.filter(value -> user.getPassword().equals(value.getPassword())).isPresent();
    }

    public Boolean register(UserDto.Base user) {
        if (isRegistered(user) || userRepo.existsByLogin(user.getLogin())) {
            return false;
        } else {
            userRepo.save(user.to());
            return true;
        }
    }
}
