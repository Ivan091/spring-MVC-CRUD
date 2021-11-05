package edu.titles.service;

import edu.titles.model.User;
import edu.titles.repo.UserRepo;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public final class UserService {

    @Autowired
    private UserRepo userRepo;

    public Boolean isRegistered(User user){
        return userRepo.existsById(user.getLogin());
    }

    public Boolean register(User user){
        if (isRegistered(user)){
            return false;
        } else {
            userRepo.save(user);
            return true;
        }
    }
}
