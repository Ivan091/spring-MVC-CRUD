package com.titles.dao;

import com.titles.model.Title;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;


@DataJdbcTest
@ContextConfiguration(classes = {DbTestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DirectorDaoProfitAggregatorTest {

    @Autowired
    private DirectorDaoProfitAggregator dao;

    @Autowired
    private TitleDao titleDao;

    @Autowired
    private Title title;

    @Test
    void findsAllCalculatingProfit() {
        var dtos = dao.findAllCalculatingProfit();
        var tarantino = dtos.stream().filter(x -> x.getDirector().getId().equals(3)).findFirst().orElseThrow();
        assertEquals(4.25f, tarantino.getProfitMultiplier(), 0.001);
        assertEquals(450f, tarantino.getProfitAverage(), 0.001);
        var spielberg = dtos.stream().filter(x -> x.getDirector().getId().equals(2)).findFirst().orElseThrow();
        assertEquals(3.5f, spielberg.getProfitMultiplier(), 0.001);
        assertEquals(500f, spielberg.getProfitAverage(), 0.001);
        var smith = dtos.stream().filter(x -> x.getDirector().getId().equals(1)).findFirst().orElseThrow();
        assertEquals(2f, smith.getProfitMultiplier(), 0.001);
        assertEquals(50f, smith.getProfitAverage(), 0.001);
    }

    @Test
    void handlesNullDivisionIfBudgetIsZero() {
        titleDao.update(title.setId(1).setBudget(0f).setDirectorId(1));
        assertThrows(DataIntegrityViolationException.class, () -> dao.findAllCalculatingProfit());
    }
}