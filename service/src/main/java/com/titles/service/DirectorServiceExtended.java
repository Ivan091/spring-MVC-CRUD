package com.titles.service;

import com.titles.dao.Dao;
import com.titles.model.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DirectorServiceExtended extends EntityServiceAbstract<Director> implements DirectorService {

    @Autowired
    public DirectorServiceExtended(Dao<Director> dao) {
        super(dao);
    }

    @Override
    public double calculateAverageProfit() {
        return 2;
    }
}
