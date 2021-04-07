package com.titles.dao;

import com.titles.model.Director;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@DataJdbcTest
@ContextConfiguration(classes = {DbTestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DirectorDaoTest {

    Integer countBefore;

    @Autowired
    private Director newEntity;

    @Autowired
    private DirectorDao dao;

    @BeforeEach
    void setUp() {
        countBefore = dao.count();
    }

    @Test
    void findsAll() {
        var result = dao.findAll();
        assertTrue(result.stream().noneMatch(Objects::isNull));
        assertEquals(countBefore, result.size());
    }

    @Test
    void findsById() {
        var item = dao.findById(1);
        assertTrue(item.isPresent());
        assertEquals(1, item.get().getId());
        assertEquals(countBefore, dao.count());
    }

    @Test
    void findByWrongIdFails() {
        assertTrue(dao.findById(-1).isEmpty());
        assertEquals(countBefore, dao.count());
    }

    @Test
    void deletes() {
        var id = 1;
        assertEquals(1, dao.delete(id));
        assertTrue(dao.findById(1).isEmpty());
        assertTrue(dao.findAll().stream().noneMatch(x -> x.getId() == 1));
        assertEquals(countBefore - 1, dao.count());
    }

    @Test
    void deletesNotExistingSuccess() {
        var rowsAffectedCount = dao.delete(0);
        assertEquals(0, rowsAffectedCount);
    }

    @Test
    void creates() {
        dao.create(newEntity);
        existCheck(newEntity);
        assertEquals(countBefore + 1, dao.count());
    }

    void existCheck(Director entity) {
        var newId = entity.getId();
        assertNotEquals(0, newId);
        assertEquals(entity, dao.findById(newId).orElseThrow());
    }

    @Test
    void updates() {
        dao.update(newEntity.setId(1));
        existCheck(newEntity);
        assertEquals(countBefore, dao.count());
    }
}