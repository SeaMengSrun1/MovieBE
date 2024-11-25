package com.example.movie.Service;

import com.example.movie.Model.JunctionTable.ActorMovie;
import com.example.movie.Repository.ActorMovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorMovieService {
    private final ActorMovieRepo actorMovieRepo;

    public ActorMovieService(ActorMovieRepo actorMovieRepo) {
        this.actorMovieRepo = actorMovieRepo;
    }

    public List<ActorMovie> getActorsByMovieId(Long movieId) {
        return actorMovieRepo.findActorsByMovieId(movieId);
    }

    public List<ActorMovie> getMoviesByActorId(Long id){
        return actorMovieRepo.findActorsByMovieId(id);
    }

    public ActorMovie saveActorMovie(ActorMovie actorMovie) {
        return actorMovieRepo.save(actorMovie);
    }

    public void deleteActorMovie(Long id) {
        actorMovieRepo.deleteById(id);
    }

    public ActorMovie updateActorMovie(ActorMovie actorMovie) {
        return actorMovieRepo.save(actorMovie);
    }

    public ActorMovie getActorMovieById(Long id) {
        return actorMovieRepo.findById(id).orElse(null);
    }

    public List<ActorMovie> getAllActorMovies() {
        return actorMovieRepo.findAll();
    }
}
