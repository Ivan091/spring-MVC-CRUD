package com.titles.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.titles.model.Director;
import com.titles.model.Title;
import com.titles.service.DirectorService;
import com.titles.service.ServiceDao;
import org.junit.jupiter.api.*;
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
@Disabled
class TitleControllerTest {

    private final String mainEndpoint = "/api";

    @Autowired
    private Director director;

    @Autowired
    private Title title;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private ServiceDao<Title> titleService;

    @BeforeEach
    void setUpTestCase() {
        directorService.create(director);
        title.setDirectorId(director.getId());
    }

    @Test
    void findsAll() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/titles")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        var result = objectMapper.readValue(response.getContentAsString(), new TypeReference<List<Title>>() {
        });
        assertTrue(result.stream().noneMatch(Objects::isNull));
    }

    @Test
    void returnsNotFoundIfDoesNotExist() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/title/0")
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
    }

    @Test
    void count() throws Exception {
        var response = mockMvc.perform(
                get(mainEndpoint + "/titles/count")
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        assertDoesNotThrow(() -> objectMapper.readValue(response.getContentAsString(), Integer.class));
    }

    @Test
    void findsById() throws Exception {
        titleService.create(title);
        var response = mockMvc.perform(
                get(mainEndpoint + "/title/" + title.getId())
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var result = objectMapper.readValue(response.getContentAsString(), Title.class);
        assertEquals(title, result);
    }

    @Test
    void creates() throws Exception {
        var json = objectMapper.writeValueAsString(title);
        var response = mockMvc.perform(
                post(mainEndpoint + "/titles")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        assertNotNull(response);
        var resultId = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertNotEquals(0, resultId);
    }

    @Test
    void updates() throws Exception {
        titleService.create(title);
        var json = objectMapper.writeValueAsString(title.setName("Test2").setBoxOffice(10f));
        var response = mockMvc.perform(
                put(mainEndpoint + "/titles")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var rowsAffected = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertEquals(1, rowsAffected);
        assertEquals(title, titleService.findById(title.getId()).orElseThrow());
    }

    @Test
    void updatingNotExistingReturnsNotFound() throws Exception {
        var json = objectMapper.writeValueAsString(title.setId(0));
        var response = mockMvc.perform(
                put(mainEndpoint + "/titles")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
    }

    @Test
    void deletes() throws Exception {
        titleService.create(title);
        var response = mockMvc.perform(
                delete(mainEndpoint + "/titles/" + title.getId())
        ).andExpect(
                status().isOk()
        ).andReturn().getResponse();
        var rowsAffected = objectMapper.readValue(response.getContentAsString(), Integer.class);
        assertEquals(1, rowsAffected);
    }

    @Test
    void deletingNotExistingReturnsNotFound() throws Exception {
        var response = mockMvc.perform(
                delete(mainEndpoint + "/titles/0")
        ).andExpect(
                status().isNotFound()
        ).andReturn().getResponse();
        assertNotNull(response);
    }
}