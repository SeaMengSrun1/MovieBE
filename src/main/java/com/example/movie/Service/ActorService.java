package com.example.movie.Service;

import com.example.movie.Model.Actor;
import com.example.movie.Repository.ActorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    private final ActorRepo actorRepo;

    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public List<Actor> getActors() {
        return actorRepo.findAll();
    }

    public Actor getActorById(Long id){
        return actorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Actor with id " + id + " not found"));
    }

    public Actor getActorByName(String name){
        return actorRepo.findActorByName(name).orElseThrow(() -> new IllegalArgumentException("Actor with name " + name + " not found"));
    }

    public void createActor(Actor actor) {
        if (actorRepo.findActorByName(actor.getName()).isPresent()) {
            throw new IllegalStateException("Actor with name " + actor.getName() + " already exists");
        }
        actorRepo.save(actor);
    }

    public void deleteActor(Long id) {
        boolean exists = actorRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Actor with id " + id + " does not exist");
        }
        actorRepo.deleteById(id);
    }

    public void updateActor(Long id, Actor actor) {
        Actor actorToUpdate = actorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Actor with id " + id + " not found"));
        actorToUpdate.setName(actor.getName());
        actorRepo.save(actorToUpdate);
    }

}
