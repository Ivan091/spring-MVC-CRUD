package com.titles.dao;

import com.titles.model.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@DataJdbcTest
@ContextConfiguration(classes = {DbTestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TitleDaoTest {

    Integer countBefore;

    @Autowired
    private Title newTitleHasNoDirector;

    @Autowired
    private Title newTitle;

    @Autowired
    private TitleDao dao;

    @BeforeEach
    void setUp() {
        newTitle.setDirectorId(1);
        countBefore = dao.count();
    }

    @Test
    void findsAll() {
        var titles = dao.findAll();
        assertEquals(countBefore, titles.size());
        assertTrue(titles.stream().noneMatch(Objects::isNull));
    }

    @Test
    void findsById() {
        var title = dao.findById(1);
        assertTrue(title.isPresent());
        assertEquals(1, title.get().getTitleId());
    }

    @Test
    void findsByWrongIdFails() {
        assertTrue(dao.findById(0).isEmpty());
    }

    @Test
    void updates() {
        var rowsAffectedCount = dao.update(newTitle.setTitleId(1));
        assertEquals(1, rowsAffectedCount);
        existCheck(newTitle);
    }

    void existCheck(Title entity) {
        var newId = entity.getTitleId();
        assertNotEquals(0, newId);
        assertEquals(entity, dao.findById(newId).orElseThrow());
    }

    @Test
    void creates() {
        var generatedId = dao.create(newTitle);
        assertEquals(generatedId, newTitle.getTitleId());
        existCheck(newTitle);
    }

    @Test
    void creatingTitleWithNoDirectorFails() {
        assertThrows(DataIntegrityViolationException.class, () -> dao.create(newTitleHasNoDirector));
    }

    @Test
    void updatingTitleWithNoDirectorFails() {
        assertThrows(DataIntegrityViolationException.class, () -> dao.update(newTitleHasNoDirector.setTitleId(1)));
    }

    @Test
    void deletes() {
        var rowsAffectedCount = dao.delete(1);
        assertEquals(1, rowsAffectedCount);
        assertTrue(dao.findById(1).isEmpty());
    }

    @Test
    void deletesNotExistingSuccess() {
        var rowsAffectedCount = dao.delete(0);
        assertEquals(0, rowsAffectedCount);
    }

    @Test
    void count() {
        assertEquals(4, dao.count());
    }
}