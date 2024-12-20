package com.example.movie.Repository;

import com.example.movie.Model.Movie;
import com.example.movie.Model.MovieTypeGroup;
import com.example.movie.ModelDTO.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByTitle(String title);

    @Query("SELECT m.movieType.name AS type, m AS movies FROM Movie m ORDER BY m.movieType.name")
    List<MovieTypeGroup> findMoviesByType();

    @Query("SELECT new com.example.movie.ModelDTO.MovieDTO(m.id, m.title, m.description, m.releaseDate, m.posterUrl, m.rating, m.movieType.name) FROM Movie m")
    List<MovieDTO> findAllMoviesWithMovieType();
}
