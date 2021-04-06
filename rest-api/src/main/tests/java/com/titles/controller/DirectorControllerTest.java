package com.titles.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.titles.model.Director;
import com.titles.model.DirectorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class DirectorControllerTest {

    private final String mainEndpoint = "/api";

    private final Director director = new Director("Christopher", "Nolan", Date.valueOf("1970-07-30"));

    private Integer rowCountBefore;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUpTestCase() throws Exception {
        rowCountBefore = count();
    }

    @Test
    Integer count() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/directors/count")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        return objectMapper.readValue(response.getContentAsString(), Integer.class);
    }

    @Test
    void findsAllCalculatingAverageProfit() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/directors")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        var result = objectMapper.readValue(response.getContentAsString(), new TypeReference<List<DirectorDto>>() {
        });
        assertTrue(result.stream().noneMatch(Objects::isNull));
        assertEquals(rowCountBefore, result.size());
    }

    @Test
    void returnsNotFoundIfFoundDirectorDoesNotExist() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/director/0")
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
        assertEquals(rowCountBefore, count());
    }

    @Test
    void findsById() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/director/1")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var result = objectMapper.readValue(response.getContentAsString(), Director.class);
        assertEquals(1, result.getId());
        assertEquals(rowCountBefore, count());
    }

    @Test
    void creates() throws Exception {
        var json = objectMapper.writeValueAsString(director);
        var response = mockMvc.perform(
                post(mainEndpoint + "/directors")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        assertDoesNotThrow(() -> objectMapper.readValue(response.getContentAsString(), Integer.class));
        assertEquals(rowCountBefore + 1, count());
    }

    @Test
    void updates() throws Exception {
        var json = objectMapper.writeValueAsString(director.setId(1));
        var response = mockMvc.perform(
                put(mainEndpoint + "/directors")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var rowsAffected = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertEquals(1, rowsAffected);
        assertEquals(rowCountBefore, count());
    }

    @Test
    void updatingNotExistingReturnsNotFound() throws Exception {
        var json = objectMapper.writeValueAsString(director.setId(0));
        var response = mockMvc.perform(
                put(mainEndpoint + "/directors")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
        assertEquals(rowCountBefore, count());
    }

    @Test
    void deletes() throws Exception {
        var response = mockMvc.perform(
                delete(mainEndpoint + "/directors/1")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var rowsAffected = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertEquals(1, rowsAffected);
        assertEquals(rowCountBefore - 1, count());
    }

    @Test
    void deletingNotExistingReturnsNotFound() throws Exception {
        var response = mockMvc.perform(
                delete(mainEndpoint + "/directors/0")
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
    }
}