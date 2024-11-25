package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.Actor;
import com.example.movie.Repository.ActorRepo;
import com.example.movie.Service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseDTO<List<Actor>> getActors(){
        return new ResponseDTO<>("200", "Success", actorService.getActors());
    }

    @GetMapping("/{id}")
    public ResponseDTO<Actor> getActorById(@PathVariable Long id){
        return new ResponseDTO<>("200", "Success", actorService.getActorById(id));
    }

    @GetMapping("/{name}")
    public ResponseDTO<Actor> getActorByName (@PathVariable String name){
        return new ResponseDTO<>("200", "Success", actorService.getActorByName(name));
    }

    @PutMapping("/{id}")
    public ResponseDTO<String> updateActor(@PathVariable Long id, Actor actor){
        actorService.updateActor(id, actor);
        return new ResponseDTO<>("200", "Success", "Actor updated");
    }

    @PostMapping
    public ResponseDTO<String> createActor(Actor actor){
        actorService.createActor(actor);
        return new ResponseDTO<>("200", "Success", "Actor created");
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteActor(@PathVariable Long id){
        actorService.deleteActor(id);
        return new ResponseDTO<>("200", "Success", "Actor deleted");
    }
}
