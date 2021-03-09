package com.titles.dao;

import com.titles.model.Director;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DirectorDaoJdbcMockTest {

    @InjectMocks
    private DirectorDao directorDao;

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    void test() {
        verify(namedParameterJdbcTemplate, times(1)).query(any(), (RowMapper<Director>) any());
    }
}
