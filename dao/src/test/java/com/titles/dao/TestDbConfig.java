package com.titles.dao;

import com.titles.model.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
@PropertySource("classpath:director/director.properties")
public class TestDbConfig {

    @Bean
    public NamedParameterJdbcTemplate h2TestDb() {
        var dataSource = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:create-db.sql", "classpath:init-test-db.sql")
                .build();
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    @Autowired
    public Dao<Director> directorDao(NamedParameterJdbcTemplate jdbcTemplate) {
        return new DirectorDao(jdbcTemplate);
    }

    @Bean
    @Autowired
    public DirectorDtoDao directorDtoDao(NamedParameterJdbcTemplate jdbcTemplate) {
        return new DirectorDtoDaoAggregator(jdbcTemplate);
    }
}
