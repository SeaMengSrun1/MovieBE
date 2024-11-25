package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.JunctionTable.DirectorMovie;
import com.example.movie.Service.DirectorMovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/directormovie")
public class DirectorMovieController {
    private final DirectorMovieService directorMovieService;

    public DirectorMovieController(DirectorMovieService directorMovieService) {
        this.directorMovieService = directorMovieService;
    }

    @GetMapping
    public ResponseDTO<List<DirectorMovie>> getAllDirectorMovie(){
        return new ResponseDTO<>("200", "Success", directorMovieService.getAllDirectorMovies());
    }

    @PutMapping("/{id}")
    public ResponseDTO<DirectorMovie> saveDirectorMovie(@PathVariable DirectorMovie directorMovie){
        return new ResponseDTO<>("200", "Success", directorMovieService.saveDirectorMovie(directorMovie));
    }

    @PostMapping
    public ResponseDTO<DirectorMovie> updateDirectorMovie(@RequestBody DirectorMovie directorMovie){
        return new ResponseDTO<>("200", "Success", directorMovieService.updateDirectorMovie(directorMovie));
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteDirectorMovie(@PathVariable Long id){
        directorMovieService.deleteDirectorMovie(id);
        return new ResponseDTO<>("200", "Success", "Director Movie Deleted");
    }
}