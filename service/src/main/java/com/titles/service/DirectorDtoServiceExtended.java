package com.titles.service;

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
public class DirectorDtoServiceExtended implements DirectorDtoService {

    private final DirectorDtoDao directorDtoDao;

    @Autowired
    public DirectorDtoServiceExtended(DirectorDtoDao directorDtoDao) {
        this.directorDtoDao = directorDtoDao;
    }

    @Override
    public Optional<DirectorDto> findByIdCalculatingProfit(int id) {
        return directorDtoDao.findByIdCalculatingProfit(id);
    }

    @Override
    public List<Director> findAll() {
        return directorDtoDao.findAll();
    }

    @Override
    public Optional<Director> findById(int id) {
        return directorDtoDao.findById(id);
    }

    @Override
    public int update(Director entity) {
        return 0;
    }

    @Override
    public int create(Director entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }
}
