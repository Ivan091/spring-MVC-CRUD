package edu.titles.service;

import edu.titles.model.*;
import edu.titles.repo.DirectorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public final class DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    public List<DirectorWithoutTitles> findAll(){
        return StreamSupport.stream(directorRepo.findAll().spliterator(), true)
                .map(Director::withoutTitles)
                .collect(Collectors.toList());
    }


    public List<DirectorWithAverageParams> findAllCalculatingProfit() {
        return StreamSupport.stream(directorRepo.findAll().spliterator(), true)
                .map(Director::calculateAverageParams)
                .collect(Collectors.toList());
    }

    public Optional<DirectorWithoutTitles> findById(Integer id){
        return directorRepo.findById(id).map(Director::withoutTitles);
    }

    public void update(DirectorWithoutTitles directorWithoutTitles){
        directorRepo.findById(directorWithoutTitles.getDirectorId())
                .map(x -> x.update(directorWithoutTitles))
                .map(directorRepo::save);
    }

    public void create(DirectorWithoutTitles directorWithoutTitles){
        var director = directorWithoutTitles.toDirector().withDirectorId(null);
        directorRepo.save(director);
    }

    public void delete(Integer directorId){
        directorRepo.deleteById(directorId);
    }
}
