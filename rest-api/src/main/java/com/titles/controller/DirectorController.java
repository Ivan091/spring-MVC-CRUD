package com.titles.controller;

import com.titles.model.Director;
import com.titles.service.ServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class DirectorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private final ServiceDao<Director> directorServiceDao;

    @Autowired
    public DirectorController(ServiceDao<Director> directorServiceDao) {
        this.directorServiceDao = directorServiceDao;
    }

    @GetMapping("/directors")
    public final List<Director> directors() {
        return directorServiceDao.findAll();
    }

    @GetMapping("/director/{id}")
    public final ResponseEntity<Director> findById(@PathVariable int id) {
        var director = directorServiceDao.findById(id);
        return director
                .map(x -> new ResponseEntity<>(director.get(), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
