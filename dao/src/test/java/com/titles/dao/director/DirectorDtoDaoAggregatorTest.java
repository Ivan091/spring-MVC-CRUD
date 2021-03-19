package com.titles.dao.director;

import com.titles.dao.DirectorDtoDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:test-db.xml"})
class DirectorDtoDaoAggregatorTest {

    @Autowired
    private DirectorDtoDao directorDtoDao;

    @Test
    void findAllCalculatingProfit() {
        var directorDto = directorDtoDao.findByIdCalculatingProfit(3).orElseThrow();
        Assertions.assertEquals(4.25, directorDto.getProfitMultiplier());
        Assertions.assertEquals(450, directorDto.getProfitAverage());
    }
}