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
class DirectorDaoAggregatorTest {

    @Autowired
    private DirectorDtoDao dtoDao;

    @Test
    void findAllCalculatingProfit() {
        var dtos = dtoDao.findAllCalculatingProfit();
        var tarantino = dtos.stream().filter(x -> x.getDirector().getId().equals(3)).findFirst().orElseThrow();
        Assertions.assertEquals(4.25f, tarantino.getProfitMultiplier());
        Assertions.assertEquals(450f, tarantino.getProfitAverage());
    }
}