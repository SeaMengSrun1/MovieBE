package com.example.movie.Service;

import com.example.movie.Model.Director;
import com.example.movie.Repository.DirectorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private final DirectorRepo directorRepo;

    public DirectorService(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    public List<Director> getDirectors() {
        return directorRepo.findAll();
    }

    public Director getDirectorById(Long id) {
        return directorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Director with id " + id + " not found"));
    }

    public Director getDirectorByName(String name) {
        return directorRepo.findDirectorByName(name).orElseThrow(() -> new IllegalArgumentException("Director with name " + name + " not found"));
    }

    public void createDirector(Director director) {
        if (directorRepo.findDirectorByName(director.getName()).isPresent()) {
            throw new IllegalStateException("Director with name " + director.getName() + " already exists");
        }
        directorRepo.save(director);
    }

    public void deleteDirector(Long id) {
        boolean exists = directorRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Director with id " + id + " does not exist");
        }
        directorRepo.deleteById(id);
    }

    public void updateDirector(Long id, Director director) {
        Director directorToUpdate = directorRepo.findById(id).orElseThrow(() -> new IllegalStateException("Director with id " + id + " not found"));
        directorToUpdate.setName(director.getName());
        directorRepo.save(directorToUpdate);
    }
}
