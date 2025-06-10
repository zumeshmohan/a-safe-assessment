package com.asafe.jokehub.service;

import com.asafe.jokehub.constant.ErrorMessage;
import com.asafe.jokehub.entity.Joke;
import com.asafe.jokehub.exception.JokeNotFoundException;
import com.asafe.jokehub.repository.JokesRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JokeServiceTest {

    @InjectMocks
    private JokesService jokesService;

    @Mock
    private JokesRepository jokesRepository;

    @Test
    public void testGetJokesCountValid(){
        List<Joke> jokes = new ArrayList<>();
        Joke joke = new Joke(1L,"General","This is a Joke!","This is a punchline.");
        jokes.add(joke);

        when(jokesRepository.findAll()).thenReturn(jokes);

        int count = jokesService.getJokesCount();

        assertEquals(1,count);
    }

    @Test
    public void testGetJokesCountEmpty(){

        when(jokesRepository.findAll()).thenReturn(null);

        int count = jokesService.getJokesCount();

        assertEquals(0,count);
    }

    @Test
    public void testGetJokeById(){
        Joke joke = new Joke(1L,"General","This is a Joke!","This is a punchline.");

        when(jokesRepository.findById(1L)).thenReturn(Optional.of(joke));

        Joke resultedJoke = jokesService.getJokeById(1L);

        assertEquals(joke, resultedJoke);
    }

    @Test
    public void testGetJokeByIdThrowException(){

        when(jokesRepository.findById(1L)).thenThrow(new JokeNotFoundException(ErrorMessage.SORRY_JOKE_NOT_FOUND));

        assertThrows(JokeNotFoundException.class, ()->jokesService.getJokeById(1L));
    }

}
