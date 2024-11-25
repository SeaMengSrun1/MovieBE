package com.example.movie.Repository;

import com.example.movie.Model.JunctionTable.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorMovieRepo extends JpaRepository<ActorMovie, Long> {

    @Query("SELECT am.actor FROM ActorMovie am WHERE am.movie.id = :movieId")
    List<ActorMovie> findActorsByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT am.movie FROM ActorMovie am WHERE am.actor.id = :actorId")
    List<ActorMovie> findMoviesByActorId(@Param("actorId") Long actorId);
}
