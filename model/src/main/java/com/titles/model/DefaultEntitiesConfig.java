package com.titles.model;

import org.springframework.context.annotation.*;
import java.time.LocalDate;


@Configuration
public class DefaultEntitiesConfig {

    @Bean
    @Scope("prototype")
    Director directorDefault() {
        return new Director("Name", "Surname", LocalDate.of(1980, 1, 1));
    }

    @Bean
    @Scope("prototype")
    Title titleDefault() {
        return new Title("Name", 100f, 200f, LocalDate.of(2016, 1, 1), 150, 0);
    }
}