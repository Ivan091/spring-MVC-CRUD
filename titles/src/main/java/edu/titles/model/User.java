package edu.titles.model;

import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;


@Value
public class User {

    @Id
    @With
    Integer userId;

    String login;

    String password;
}
