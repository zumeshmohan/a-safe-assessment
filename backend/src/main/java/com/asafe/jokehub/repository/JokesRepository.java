package com.asafe.jokehub.repository;

import com.asafe.jokehub.entity.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokesRepository extends JpaRepository<Joke,Long> {
}
