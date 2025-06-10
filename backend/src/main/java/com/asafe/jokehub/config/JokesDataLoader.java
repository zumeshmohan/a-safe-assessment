package com.asafe.jokehub.config;

import com.asafe.jokehub.entity.Joke;
import com.asafe.jokehub.repository.JokesRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class JokesDataLoader implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(JokesDataLoader.class);

    private final JokesRepository jokesRepository;
    private final ObjectMapper objectMapper;

    public JokesDataLoader(JokesRepository jokesRepository, ObjectMapper objectMapper) {
        this.jokesRepository = jokesRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Method used for loading the json content to DB. This executed each time when
     * the application starts.Make sure the file jokes.json present
     * in resources folder and DB properties can be referred in application.properties file.
     * @param args
     * @throws Exception
     */

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Start loading the data from jokes.json file to DB.");
        InputStream is = getClass().getResourceAsStream("/jokes.json");
        List<Joke> jokes = objectMapper.readValue(is, new TypeReference<List<Joke>>() {});
        jokesRepository.saveAll(jokes);
        logger.info("Jokes loaded to DB successfully.");
    }
}
