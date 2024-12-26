package com.example.movie.Controller;

import com.example.movie.Model.Movie;
import com.example.movie.ModelDTO.MovieDTO;
import com.example.movie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.movie.DTO.ResponseDTO;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping
    public ResponseDTO<List<MovieDTO>> getMovies() {
        return new ResponseDTO<>("200", "Success", movieService.getAllMoviesWithMovieType());
    }

    @GetMapping(path = "/latest")
    public ResponseDTO<List<Movie>> getLatestMovies() {
        return new ResponseDTO<>("200", "Success", movieService.getLatestMovies());
    }

    // src/main/java/com/example/movie/Controller/MovieController.java
    @GetMapping(path = "/random")
    public ResponseDTO<List<Movie>> getRandomMovies() {
        return new ResponseDTO<>("200", "Success", movieService.getRandomMovies());
    }
    @GetMapping(path = "/type/{type}")
    public ResponseDTO<List<Movie>> getMoviesByType(@PathVariable String type) {
        return new ResponseDTO<>("200", "Success", movieService.getMoviesByType(type));
    }


    @GetMapping(path = "/{id}")
    public ResponseDTO<Movie> getMovieById(@PathVariable Long id) {
        return new ResponseDTO<>("200", "Success", movieService.getMovieById(id));
    }

    @GetMapping(path = "/group")
    public ResponseDTO<Map<String, List<Movie>>> getMoviesByGroup() {
        return new ResponseDTO<>("200", "Success fully for getting data.", movieService.getMoviesByGroup());
    }
//    public ResponseEntity<Map<String, List<Movie>>> getMoviesByGroup() {
//        Map<String, List<Movie>> groupedMovies = movieService.getMoviesByGroup();
//        return ResponseEntity.ok(groupedMovies);
//    }

    @GetMapping(path = "/movieType")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMoviesWithMovieType());
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
