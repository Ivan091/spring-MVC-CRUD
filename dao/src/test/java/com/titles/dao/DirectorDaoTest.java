package com.titles.dao;

import com.titles.model.Director;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import java.sql.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@DataJdbcTest
@ContextConfiguration(classes = {TestDbConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DirectorDaoTest {

    private final Director newEntity = new Director(1, "Ivan", "Karnasevich", Date.valueOf("2002-07-19"));

    @Autowired
    private Dao<Director> dao;

    @Test
    void findsAll() {
        var result = dao.findAll();
        assertTrue(result.stream().noneMatch(Objects::isNull));
        assertEquals(3, result.size());
    }

    @Test
    void findsById() {
        var newId = dao.create(newEntity);
        assertEquals(newId, newEntity.getId());
        assertEquals(newEntity, dao.findById(newId).orElseThrow());
    }

    @Test
    void findByWrongIdFails() {
        assertTrue(dao.findById(-1000).isEmpty());
    }

    @Test
    void deletes() {
        var id = 1;
        assertEquals(1, dao.delete(id));
        assertTrue(dao.findById(1).isEmpty());
        assertTrue(dao.findAll().stream().noneMatch(x -> x.getId() == 1));
    }

    @Test
    void creates() {
        var newId = dao.create(newEntity);
        assertEquals(newEntity.getId(), newId);
        assertEquals(newEntity, dao.findById(newId).orElseThrow());
    }

    @Test
    void updates() {
        dao.create(newEntity);
        var secondNew = new Director(newEntity.getId(), "Name", "Surname", Date.valueOf("1971-01-01"));
        dao.update(secondNew);
        assertEquals(secondNew, dao.findById(secondNew.getId()).orElseThrow());
    }
}