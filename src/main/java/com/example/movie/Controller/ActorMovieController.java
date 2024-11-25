package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.JunctionTable.ActorMovie;
import com.example.movie.Service.ActorMovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actormovie")
public class ActorMovieController {
    private final ActorMovieService actorMovieService;

    public ActorMovieController(ActorMovieService actorMovieService) {
        this.actorMovieService = actorMovieService;
    }

    @GetMapping
    public ResponseDTO<List<ActorMovie>> getActorMovies() {
        return new ResponseDTO<>("200", "Success", actorMovieService.getAllActorMovies());
    }

    @GetMapping("/{id}")
    public ResponseDTO<ActorMovie> getMoviesByActorId(@PathVariable Long id) {
        return new ResponseDTO<>("200", "Success", actorMovieService.getActorMovieById(id));
    }

    @PutMapping("/{id}")
    public ResponseDTO<ActorMovie> updateActorMovie(@RequestBody ActorMovie actorMovie) {
        return new ResponseDTO<>("200", "Success", actorMovieService.updateActorMovie(actorMovie));
    }

    @PostMapping
    public ResponseDTO<ActorMovie> saveActorMovie(@RequestBody ActorMovie actorMovie) {
        return new ResponseDTO<>("200", "Success", actorMovieService.saveActorMovie(actorMovie));
    }

    @DeleteMapping
    public ResponseDTO<String> deleteActorMovie(@PathVariable Long id) {
        actorMovieService.deleteActorMovie(id);
        return new ResponseDTO<>("200", "Success", "Actor Movie Deleted");
    }

}
