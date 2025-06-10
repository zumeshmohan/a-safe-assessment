package com.asafe.jokehub.service;

import com.asafe.jokehub.constant.ErrorMessage;
import com.asafe.jokehub.entity.Joke;
import com.asafe.jokehub.exception.JokeNotFoundException;
import com.asafe.jokehub.repository.JokesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokesService {


    private final JokesRepository jokesRepository;

    public JokesService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public List<Joke> getAllJokes(){

        return jokesRepository.findAll();

    }

    public Joke getJokeById(Long id){

         return jokesRepository.findById(id)
                 .orElseThrow(() -> new JokeNotFoundException(ErrorMessage.SORRY_JOKE_NOT_FOUND));

    }
}
