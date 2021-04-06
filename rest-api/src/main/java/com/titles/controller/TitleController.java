package com.titles.controller;

import com.titles.model.Title;
import com.titles.service.ServiceDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class TitleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RootController.class);

    private final ServiceDao<Title> service;

    @Autowired
    public TitleController(ServiceDao<Title> service) {
        this.service = service;
    }

    @GetMapping("/titles")
    public List<Title> findAll() {
        return service.findAll();
    }

    @GetMapping("/title/{id}")
    public ResponseEntity<Title> findById(@PathVariable Integer id) {
        var title = service.findById(id);
        return title
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/titles")
    public ResponseEntity<Integer> create(@RequestBody Title title) {
        var createdId = service.create(title);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/titles")
    public ResponseEntity<Integer> update(@RequestBody Title title) {
        var updatedRowsCount = service.update(title);
        if (updatedRowsCount == 1) {
            return new ResponseEntity<>(updatedRowsCount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/titles/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        var rowsAffectedCount = service.delete(id);
        if (rowsAffectedCount == 1) {
            return new ResponseEntity<>(rowsAffectedCount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/titles/count")
    public ResponseEntity<Integer> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }
}
