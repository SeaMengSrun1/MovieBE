package com.example.movie.Repository;


import com.example.movie.Model.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieTypeRepo extends JpaRepository<MovieType, Long> {
    Optional<MovieType> findMovieTypeByName(String name);
}
