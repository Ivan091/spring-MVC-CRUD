package com.titles.service;

import com.titles.dao.Dao;
import com.titles.dao.DirectorDtoDao;
import com.titles.model.Director;
import com.titles.model.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class DirectorDtoService implements DirectorService {

    private final DirectorDtoDao dtoDao;

    private final Dao<Director> dao;

    @Autowired
    public DirectorDtoService(DirectorDtoDao dtoDao, Dao<Director> dao) {
        this.dtoDao = dtoDao;
        this.dao = dao;
    }

    @Override
    public List<DirectorDto> findAllCalculatingProfit() {
        return dtoDao.findAllCalculatingProfit();
    }

    @Override
    public List<Director> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Director> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Integer update(Director entity) {
        return dao.update(entity);
    }

    @Override
    public Integer create(Director entity) {
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
