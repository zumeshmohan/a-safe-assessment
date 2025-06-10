package com.asafe.jokehub.service;

import com.asafe.jokehub.constant.ErrorMessage;
import com.asafe.jokehub.entity.Joke;
import com.asafe.jokehub.exception.JokeNotFoundException;
import com.asafe.jokehub.repository.JokesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokesService {


    private final JokesRepository jokesRepository;

    public JokesService(JokesRepository jokesRepository) {
        this.jokesRepository = jokesRepository;
    }

    public int getJokesCount(){
        List<Joke> jokes = jokesRepository.findAll();
        int size = 0;
        if(jokes !=null && !jokes.isEmpty()) {
            size = jokes.size();
        }

        return size;

    }

    public Joke getJokeById(Long id){

         return jokesRepository.findById(id)
                 .orElseThrow(() -> new JokeNotFoundException(ErrorMessage.SORRY_JOKE_NOT_FOUND));

    }
}
