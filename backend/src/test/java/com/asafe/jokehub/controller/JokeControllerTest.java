package com.asafe.jokehub.controller;

import com.asafe.jokehub.entity.Joke;
import com.asafe.jokehub.service.JokesService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(JokesController.class)
public class JokeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private JokesService jokesService;

    @Test
    public void testJokeCount_ReturnsValidCount() throws Exception {
        when(jokesService.getJokesCount()).thenReturn(1);

        mockMvc.perform(get("/api/v1/jokes/count"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));

    }

    @Test
    public void testGetJokeById_Valid() throws Exception {

        Joke joke = new Joke(1L,"General","This is a Joke!","This is a punchline.");
        when(jokesService.getJokeById(1L)).thenReturn(joke);

        mockMvc.perform(get("/api/v1/jokes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.type").value("General"));

    }

}
