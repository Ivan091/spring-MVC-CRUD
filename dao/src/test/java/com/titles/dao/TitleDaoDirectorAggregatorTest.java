package com.titles.dao;

import com.titles.model.TitleWithDirectorFullNameDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ContextConfiguration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJdbcTest
@ContextConfiguration(classes = {DbTestConfig.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TitleDaoDirectorAggregatorTest {

    @Autowired
    private TitleDaoDirectorAggregator dao;

    @Test
    void findsDirectorForEachTitle() {
        List<TitleWithDirectorFullNameDto> titlesAggregated = dao.findAllTitlesWithDirectorFullName();
        assertEquals(4, titlesAggregated.size());
        titlesAggregated.forEach(x -> {
            assertNotNull(x.getDirectorFullName());
        });
    }
}
