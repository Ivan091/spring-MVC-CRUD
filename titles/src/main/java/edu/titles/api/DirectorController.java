package edu.titles.api;

import edu.titles.api.dto.DirectorDto;
import edu.titles.service.DirectorService;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@EqualsAndHashCode
@ToString
@RestController
public final class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/directors")
    public List<DirectorDto.WithAverageParams> findAllCalculatingAverageProfit() {
        return directorService.findAllCalculatingProfit();
    }

    @GetMapping("/directors/{id}")
    public ResponseEntity<DirectorDto.WithId> findById(@PathVariable Integer id) {
        var director = directorService.findById(id);
        return director
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/directors")
    public ResponseEntity<Void> create(@RequestBody DirectorDto.Base directorDtoBase) {
        directorService.create(directorDtoBase);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/directors")
    public ResponseEntity<Void> update(@RequestBody DirectorDto.WithId directorDtoBase) {
        if (directorService.update(directorDtoBase)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/directors/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        directorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
