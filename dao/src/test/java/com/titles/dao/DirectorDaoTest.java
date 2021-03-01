package com.titles.dao;

import com.titles.model.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.stream.IntStream;


@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
class DirectorDaoTest {

    private final Director newEntity = new Director(4, "Ivan", "Karnasevich", Date.valueOf("2002-07-19"));

    @Autowired
    private Dao<Director> directorDao;

    @Test
    void findAll() {
        var result = directorDao.findAll();
        Assertions.assertEquals(3, result.size());
    }

    @Test
    void delete() {
        IntStream.range(1, 4).forEach(i -> {
            Assertions.assertTrue(directorDao.findById(i).isPresent());
            directorDao.delete(i);
            Assertions.assertTrue(directorDao.findById(i).isEmpty());
        });
    }

    @Test
    void create() {
        var oltEntities = directorDao.findAll();
        Assertions.assertEquals(newEntity.getId(), directorDao.create(newEntity));
        Assertions.assertEquals(newEntity, directorDao.findById(newEntity.getId()).orElseThrow());
        Assertions.assertEquals(oltEntities.size() + 1, directorDao.findAll().size());
    }

    @Test
    void update() {
        directorDao.create(newEntity);
        var secondNew = new Director(newEntity.getId(), "Name", "Surname", Date.valueOf("1971-01-01"));
        directorDao.update(secondNew);
        Assertions.assertEquals(secondNew, directorDao.findById(secondNew.getId()).orElseThrow());
    }
}