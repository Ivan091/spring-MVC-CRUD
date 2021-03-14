package com.titles.controller;

import com.titles.dao.Dao;
import com.titles.model.Director;
import com.titles.service.DirectorServiceExtended;
import com.titles.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;


@Configuration
@ImportResource(locations = {"classpath:db.xml"})
public class ControllerConfig {

    @Bean
    @Autowired
    public ServiceDao<Director> serviceDirectorDefault(Dao<Director> dao) {
        return new DirectorServiceExtended(dao);
    }
}
