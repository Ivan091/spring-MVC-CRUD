package edu.titles.repo;

import edu.titles.model.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;


public interface UserRepo extends CrudRepository<User, Integer> {

    Boolean existsByLogin(String login);

    Optional<User> findByLogin(String login);
}
