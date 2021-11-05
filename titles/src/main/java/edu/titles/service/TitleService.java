package edu.titles.service;

import edu.titles.model.*;
import edu.titles.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public final class TitleService {

    @Autowired
    TitleRepo titleRepo;

    public List<TitleWithDirectorFullName> findAllWithDirectorFullName(){
        return titleRepo.findWithAverageParams().parallelStream().collect(Collectors.toList());
    }

    public List<TitleWithDirectorFullName> findAllWithDirectorFullNameBetween(LocalDate startDate, LocalDate endDate){
        return titleRepo.findWithAverageParamsBetween(startDate, endDate);
    }

    public Boolean update(Title title){
        if (titleRepo.existsById(title.getTitleId())){
            titleRepo.save(title);
            return true;
        }
        return false;
    }

    public void create(Title title){
        titleRepo.save(title.withTitleId(null));
    }

    public Optional<Title> findById(Integer titleId){
        return titleRepo.findById(titleId);
    }

    public void delete(Integer titleId){
        titleRepo.deleteById(titleId);
    }
}
