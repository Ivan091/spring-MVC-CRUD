package com.titles.service;

import com.titles.dao.Dao;
import com.titles.dao.TitleDtoDao;
import com.titles.model.Title;
import com.titles.model.TitleWithDirectorFullNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class TitleDtoService implements TitleService {

    private final Dao<Title> dao;

    private final TitleDtoDao dtoDao;

    @Autowired
    public TitleDtoService(Dao<Title> dao, TitleDtoDao dtoDao) {
        this.dao = dao;
        this.dtoDao = dtoDao;
    }

    @Override
    public List<Title> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Title> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Integer update(Title entity) {
        return dao.update(entity);
    }

    @Override
    public Integer create(Title entity) {
        return dao.create(entity);
    }

    @Override
    public Integer delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Integer count() {
        return dao.count();
    }

    @Override
    public List<TitleWithDirectorFullNameDto> findAllTitlesWithDirectorFullName() {
        return dtoDao.findAllTitlesWithDirectorFullName();
    }

    @Override
    public List<TitleWithDirectorFullNameDto> findAllTitlesBetween(LocalDate first, LocalDate second) {
        return dtoDao.findAllTitlesBetween(first, second);
    }
}
