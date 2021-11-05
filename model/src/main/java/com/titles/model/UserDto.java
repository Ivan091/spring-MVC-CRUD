package com.titles.model;

import java.util.Objects;


public final class UserDto {

    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public UserDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserDto() {
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(login, userDto.login) && Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
