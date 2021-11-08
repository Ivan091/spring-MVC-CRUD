package edu.titles.repo;

import edu.titles.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User, String> {

    Boolean existsByLogin(String login);
}
