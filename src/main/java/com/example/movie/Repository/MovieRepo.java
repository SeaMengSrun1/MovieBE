package com.example.movie.Repository;

import com.example.movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByTitle(String title);

}
