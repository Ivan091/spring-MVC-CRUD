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
    private DirectorDao dao;

    @Test
    void findsAll() {
        var result = dao.findAll();
        assertTrue(result.stream().noneMatch(Objects::isNull));
        assertEquals(3, result.size());
    }

    @Test
    void findsById() {
        var item = dao.findById(1);
        assertTrue(item.isPresent());
        assertEquals(1, item.get().getId());
    }

    @Test
    void findByWrongIdFails() {
        assertTrue(dao.findById(-1).isEmpty());
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
        dao.create(newEntity);
        existCheck(newEntity);
    }

    void existCheck(Director entity) {
        var newId = entity.getId();
        assertNotEquals(0, newId);
        assertEquals(entity, dao.findById(newId).orElseThrow());
    }

    @Test
    void updates() {
        dao.create(newEntity);
        existCheck(newEntity);
    }
}