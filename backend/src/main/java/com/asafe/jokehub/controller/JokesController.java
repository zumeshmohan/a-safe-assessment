package com.asafe.jokehub.controller;

import com.asafe.jokehub.entity.Joke;
import com.asafe.jokehub.service.JokesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jokes")
public class JokesController {

    private static final Logger logger = LoggerFactory.getLogger(JokesController.class);

    private final JokesService jokesService;

    public JokesController(JokesService jokesService) {
        this.jokesService = jokesService;
    }

    /**
     * Method used for getting the count of records from the DB
     * @return List of Joke objects
     */
    @GetMapping("/count")
    public ResponseEntity<Integer> getJokeCount(){
        int count = jokesService.getJokesCount();
        logger.info("Jokes count is {}",count);
        return ResponseEntity.ok(count);
    }

    /**
     * Method to fetch record based on the ID passed from client side.
     * @param id - Long type
     * @return Joke Object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Joke> getJokeById(@PathVariable Long id){
        Joke joke = jokesService.getJokeById(id);
        logger.debug("Joke received : {}",joke.toString() );
        return ResponseEntity.ok(joke);
    }
}
