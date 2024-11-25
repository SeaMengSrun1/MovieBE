package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.Director;
import com.example.movie.Service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public ResponseDTO<List<Director>> getDirectors(){
        return new ResponseDTO<>("200", "Success", directorService.getDirectors());
    }

    @GetMapping("/{id}")
    public ResponseDTO<Director> getDirectorById(@PathVariable Long id){
        return new ResponseDTO<>("200", "Success", directorService.getDirectorById(id));
    }

    @GetMapping("/{name}")
    public ResponseDTO<Director> getDirectorByName(@PathVariable String name){
        return new ResponseDTO<>("200", "Success", directorService.getDirectorByName(name));
    }

    @PutMapping("/{id}")
    public ResponseDTO<String> updateDirector(@PathVariable Long id, Director director){
        directorService.updateDirector(id, director);
        return new ResponseDTO<>("200", "Success", "Director updated");
    }

    @PostMapping
    public ResponseDTO<String> createDirector(Director director){
        directorService.createDirector(director);
        return new ResponseDTO<>("200", "Success", "Director created");
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteDirector(@PathVariable Long id){
        directorService.deleteDirector(id);
        return new ResponseDTO<>("200", "Success", "Director deleted");
    }

}
