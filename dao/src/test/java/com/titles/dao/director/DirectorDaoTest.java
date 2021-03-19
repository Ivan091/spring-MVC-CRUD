package com.titles.dao.director;

import com.titles.dao.Dao;
import com.titles.model.Director;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.sql.Date;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:test-db.xml"})
class DirectorDaoTest {

    private final Director newEntity = new Director(1, "Ivan", "Karnasevich", Date.valueOf("2002-07-19"));

    @Autowired
    private Dao<Director> directorDao;

    @Test
    void findAll() {
        var result = directorDao.findAll();
        assertEquals(3, result.size());
    }

    @Test
    void findById() {
        var newId = directorDao.create(newEntity);
        assertEquals(newId, newEntity.getId());
        assertEquals(newEntity, directorDao.findById(newId).orElseThrow());
    }

    @Test
    void findByWrongIdFails() {
        assertTrue(directorDao.findById(-1000).isEmpty());
    }

    private void assertTrue(boolean empty) {
    }

    @Test
    void delete() {
        IntStream.range(1, 4).forEach(i -> {
            assertTrue(directorDao.findById(i).isPresent());
            assertEquals(1, directorDao.delete(i));
            assertEquals(3 - i, directorDao.findAll().size());
            assertFalse(directorDao.findById(i).isPresent());
        });
    }

    @Test
    void create() {
        var newId = directorDao.create(newEntity);
        assertEquals(newEntity.getId(), newId);
        assertEquals(newEntity, directorDao.findById(newId).orElseThrow());
    }

    @Test
    void update() {
        directorDao.create(newEntity);
        var secondNew = new Director(newEntity.getId(), "Name", "Surname", Date.valueOf("1971-01-01"));
        directorDao.update(secondNew);
        assertEquals(secondNew, directorDao.findById(secondNew.getId()).orElseThrow());
    }
}