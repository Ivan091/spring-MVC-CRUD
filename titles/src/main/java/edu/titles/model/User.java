package edu.titles.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@Value
public class User {

    @Id
    @With
    String login;

    String password;
}
