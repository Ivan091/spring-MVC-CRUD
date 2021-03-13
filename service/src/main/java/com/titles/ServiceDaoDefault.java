package com.titles;

import com.titles.dao.Dao;
import com.titles.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ServiceDaoDefault<T> implements ServiceDao<T> {

    private final Dao<T> dao;

    @Autowired
    public ServiceDaoDefault(Dao<T> dao) {
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
}
