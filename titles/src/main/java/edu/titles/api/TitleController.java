package edu.titles.api;

import edu.titles.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
public final class TitleController {

    @Autowired
    private TitleService service;

    @GetMapping("/titles")
    public List<TitleDto.WithDirectorFullName> findAll() {
        return service.findAllWithDirectorFullName();
    }

    @GetMapping("/titles/{id}")
    public ResponseEntity<TitleDto.Base> findById(@PathVariable Integer id) {
        var title = service.findById(id);
        return title
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/titles/between")
    public List<TitleDto.WithDirectorFullName> findAllBetween(@RequestParam(name = "firstDate")
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                      LocalDate start,
                                                              @RequestParam(name = "secondDate")
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                      LocalDate end) {
        return service.findAllWithDirectorFullNameBetween(start, end);
    }

    @PostMapping(value = "/titles")
    public ResponseEntity<Void> create(@RequestBody TitleDto.Base title) {
        service.create(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/titles")
    public ResponseEntity<Void> update(@RequestBody TitleDto.Base title) {
        if (service.update(title)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/titles/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
