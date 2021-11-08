package edu.titles.api.dto;

import edu.titles.model.User;
import lombok.*;


@EqualsAndHashCode
@ToString
public final class UserDto {

    @Value
    public static class Base {

        String login;

        String password;

        public static Base of(User user) {
            return new Base(
                    user.getLogin(),
                    user.getPassword()
            );
        }

        public User to() {
            return new User(null, login, password);
        }
    }
}
