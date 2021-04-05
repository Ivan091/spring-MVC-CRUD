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

    private final DirectorDtoDao directorDtoDao;

    private final Dao<Director> directorDao;

    @Autowired
    public DirectorDtoService(DirectorDtoDao directorDtoDao, Dao<Director> directorDao) {
        this.directorDtoDao = directorDtoDao;
        this.directorDao = directorDao;
    }

    @Override
    public Optional<DirectorDto> findByIdCalculatingProfit(int id) {
        return directorDtoDao.findByIdCalculatingProfit(id);
    }

    @Override
    public List<Director> findAll() {
        return directorDao.findAll();
    }

    @Override
    public Optional<Director> findById(int id) {
        return directorDao.findById(id);
    }

    @Override
    public int update(Director entity) {
        return directorDao.update(entity);
    }

    @Override
    public int create(Director entity) {
        return directorDao.create(entity);
    }

    @Override
    public int delete(int id) {
        return directorDao.delete(id);
    }

    @Override
    public int count() {
        return directorDao.count();
    }
}
