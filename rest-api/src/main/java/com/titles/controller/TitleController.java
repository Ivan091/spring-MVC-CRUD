package com.titles.controller;

import com.titles.model.Title;
import com.titles.model.TitleWithDirectorFullNameDto;
import com.titles.service.DirectorService;
import com.titles.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
public class TitleController {

    private final TitleService service;

    private final DirectorService directorService;

    @Autowired
    public TitleController(TitleService titleService, DirectorService directorService) {
        this.service = titleService;
        this.directorService = directorService;
    }

    @GetMapping("/titles")
    public List<TitleWithDirectorFullNameDto> findAll() {
        return service.findAllTitlesWithDirectorFullName();
    }

    @GetMapping("/titles/{id}")
    public ResponseEntity<Title> findById(@PathVariable Integer id) {
        var title = service.findById(id);
        return title
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/titles/between")
    public List<TitleWithDirectorFullNameDto> findAllBetween(@RequestParam(name = "firstDate")
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                     LocalDate start,
                                                             @RequestParam(name = "secondDate")
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                     LocalDate end) {
        return service.findAllTitlesBetween(start, end);
    }

    @PostMapping(value = "/titles")
    public ResponseEntity<Integer> create(@RequestBody Title title) {
        var foreignDirector = directorService.findById(title.getDirectorId());
        return foreignDirector
                .map(x -> {
                    var idOfCreatedTitle = service.create(title);
                    return new ResponseEntity<>(idOfCreatedTitle, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/titles")
    public ResponseEntity<Integer> update(@RequestBody Title title) {
        var foreignDirector = directorService.findById(title.getDirectorId());
        return foreignDirector
                .map(x -> {
                    var rowsAffectedCount = service.update(title);
                    return new ResponseEntity<>(rowsAffectedCount, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
    public Integer count() {
        return service.count();
    }
}
