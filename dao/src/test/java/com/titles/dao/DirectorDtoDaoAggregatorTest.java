package com.titles.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;


@DataJdbcTest
@ContextConfiguration(classes = {TestDbConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DirectorDtoDaoAggregatorTest {

    @Autowired
    private DirectorDtoDaoAggregator dtoDao;

    @Test
    void findsAllCalculatingProfit() {
        var dtos = dtoDao.findAllCalculatingProfit();
        var tarantino = dtos.stream().filter(x -> x.getDirector().getId().equals(3)).findFirst().orElseThrow();
        Assertions.assertEquals(4.25f, tarantino.getProfitMultiplier(), 0.001);
        Assertions.assertEquals(450f, tarantino.getProfitAverage(), 0.001);
        var spielberg = dtos.stream().filter(x -> x.getDirector().getId().equals(2)).findFirst().orElseThrow();
        Assertions.assertEquals(3.5f, spielberg.getProfitMultiplier(), 0.001);
        Assertions.assertEquals(500f, spielberg.getProfitAverage(), 0.001);
    }
}