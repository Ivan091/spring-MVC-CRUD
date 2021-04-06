package com.titles.dao;

import com.titles.model.Title;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import java.sql.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@DataJdbcTest
@ContextConfiguration(classes = {TestDbConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Disabled
class TitleDaoTest {

    private final Title newTitleHasNoDirector = new Title(1, "Avatar", 237f, 2844f, Date.valueOf("2009-12-18"), 162, 0);

    private final Title newTitle = new Title(1, "War Horse", 70f, 177.6f, Date.valueOf("2011-12-25"), 146, 2);

    @Autowired
    private TitleDao dao;

    @Test
    void findsAll() {
        var titles = dao.findAll();
        assertTrue(titles.size() > 0);
        assertTrue(titles.stream().noneMatch(Objects::isNull));
    }

    @Test
    void findsById() {
        var title = dao.findById(1);
        assertTrue(title.isPresent());
        assertEquals(1, title.get().getId());
    }

    @Test
    void findsByIdFails() {
        assertTrue(dao.findById(-1).isEmpty());
    }

    @Test
    void updates() {
        dao.update(newTitle);
        assertEquals(dao.findById(1).orElseThrow(), newTitle);
        existCheck(newTitle);
    }

    void existCheck(Title entity) {
        var newId = entity.getId();
        assertNotEquals(0, newId);
        assertEquals(entity, dao.findById(newId).orElseThrow());
    }

    @Test
    void creates() {
        dao.create(newTitle);
        existCheck(newTitle);
    }

    @Test
    void creatingTitleWithNoDirectorFails() {
        assertThrows(DataIntegrityViolationException.class, () -> dao.create(newTitleHasNoDirector));
    }

    @Test
    void updatingTitleWithNoDirectorFails() {
        assertThrows(DataIntegrityViolationException.class, () -> dao.update(newTitleHasNoDirector));
    }

    @Test
    void deletes() {
        dao.delete(1);
        assertTrue(dao.findById(1).isEmpty());
    }

    @Test
    void count() {
        assertEquals(4, dao.count());
    }
}