package com.titles.service;

import com.titles.dao.Dao;
import com.titles.model.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class TitleService implements ServiceDao<Title> {

    private final Dao<Title> dao;

    @Autowired
    public TitleService(Dao<Title> dao) {
        this.dao = dao;
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
}
