package com.example.movie.Controller;

import com.example.movie.Model.Movie;
import com.example.movie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.movie.DTO.ResponseDTO;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping()
    public ResponseDTO<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getMovies();
        return new ResponseDTO<>("success", "Movies retrieved successfully", movies);
    }

    @GetMapping(path = "/{id}")
    public Movie getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping
    public void createMovie(@RequestBody Movie movie) {
        movieService.createMovie(movie);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
    }


}
