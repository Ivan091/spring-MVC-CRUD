package com.titles.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.titles.model.Director;
import com.titles.model.DirectorDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private Director director;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void count() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/directors/count")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        var count = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertTrue(count >= 0);
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
    }

    @Test
    void returnsNotFoundIfFoundDirectorDoesNotExist() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/director/0")
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
    }

    @Test
    void findsById() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/director/1")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var result = objectMapper.readValue(response.getContentAsString(), Director.class);
        assertEquals(1, result.getDirectorId());
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
    }

    @Test
    void updates() throws Exception {
        var json = objectMapper.writeValueAsString(director.setDirectorId(1));
        var response = mockMvc.perform(
                put(mainEndpoint + "/directors")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var rowsAffected = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertEquals(1, rowsAffected);
    }

    @Test
    void updatingNotExistingReturnsNotFound() throws Exception {
        var json = objectMapper.writeValueAsString(director.setDirectorId(0));
        var response = mockMvc.perform(
                put(mainEndpoint + "/directors")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
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