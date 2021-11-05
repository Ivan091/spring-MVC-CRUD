package edu.titles.api;

import edu.titles.model.Director;
import edu.titles.model.DirectorWithAverageParams;
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
    public List<DirectorWithAverageParams> findAllCalculatingAverageProfit() {
        return directorService.findAllCalculatingProfit();
    }

    @GetMapping("/directors/{id}")
    public ResponseEntity<Director> findById(@PathVariable Integer id) {
        var director = directorService.findById(id);
        return director
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/directors")
    public ResponseEntity<Void> create(@RequestBody Director director) {
        directorService.create(director.withDirectorId(null));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/directors")
    public ResponseEntity<Void> update(@RequestBody Director director) {
        if (directorService.update(director)){
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
