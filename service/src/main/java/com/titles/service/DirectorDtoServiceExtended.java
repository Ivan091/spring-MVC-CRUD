package com.titles.service;

import com.titles.dao.DirectorDtoDao;
import com.titles.model.Director;
import com.titles.model.DirectorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Service
@Transactional
public class DirectorDtoServiceExtended extends EntityServiceAbstract<Director> implements DirectorDtoService {

    private final DirectorDtoDao directorDtoDao;

    @Autowired
    public DirectorDtoServiceExtended(DirectorDtoDao dao) {
        super(dao);
        this.directorDtoDao = dao;
    }

    @Override
    public Optional<DirectorDto> findByIdCalculatingProfit(int id) {
        return directorDtoDao.findByIdCalculatingProfit(id);
    }
}
