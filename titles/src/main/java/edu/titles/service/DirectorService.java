package edu.titles.service;

import edu.titles.model.Director;
import edu.titles.model.DirectorWithAverageParams;
import edu.titles.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public final class DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    public List<DirectorWithAverageParams> findAllCalculatingProfit() {
        return directorRepo.findDirectorCalculatingAverageParams();
    }

    public Optional<Director> findById(Integer id) {
        return directorRepo.findById(id);
    }

    public Boolean update(Director director) {
        if (directorRepo.existsById(director.getDirectorId())) {
            directorRepo.save(director);
            return true;
        }
        return false;
    }

    public void create(Director director) {
        directorRepo.save(director.withDirectorId(null));
    }

    public void delete(Integer directorId) {
        directorRepo.deleteById(directorId);
    }
}
