package com.titles.service;

import dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class EntityServiceAbstract<T> implements ServiceDao<T> {

    protected final Dao<T> dao;

    @Autowired
    public EntityServiceAbstract(Dao<T> dao) {
        this.dao = dao;
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<T> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public int update(T entity) {
        return dao.update(entity);
    }

    @Override
    public int create(T entity) {
        return dao.create(entity);
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public int count() {
        return dao.count();
    }
}
