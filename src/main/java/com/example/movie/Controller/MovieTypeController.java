package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.MovieType;
import com.example.movie.Service.MovieTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "movieType")
public class MovieTypeController {

    final MovieTypeService movieTypeService;

    @Autowired
    public MovieTypeController(MovieTypeService movieTypeService) {
        this.movieTypeService = movieTypeService;
    }

    @GetMapping
    public ResponseDTO<List<MovieType>> getMovieTypes() {
        return new ResponseDTO<>("200", "Success", movieTypeService.getMovieTypes());
    }

    @GetMapping(path = "/{id}")
    public MovieType getMovieTypeById(@PathVariable("id") Long id) {
        return movieTypeService.getMovieTypeById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMovieType(@PathVariable("id") Long id) {
        movieTypeService.deleteMovieType(id);
    }

    @PostMapping
    public void createMovieType(@RequestBody MovieType movieType) {
        movieTypeService.createMovieType(movieType);
    }
}
