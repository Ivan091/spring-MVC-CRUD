package edu.titles.service;

import edu.titles.model.Director;
import edu.titles.model.Title;
import edu.titles.repo.TitleRepo;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public final class TitleService {

    @Autowired
    TitleRepo titleRepo;

    public List<Title> findAll(){
        return StreamSupport.stream(titleRepo.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }
}
