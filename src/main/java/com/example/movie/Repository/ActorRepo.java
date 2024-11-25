package com.example.movie.Repository;

import com.example.movie.Model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ActorRepo extends JpaRepository<Actor, Long> {
    Optional<Actor> findActorByName(String name);
    Optional<Actor> findActorById (Long id);
}
