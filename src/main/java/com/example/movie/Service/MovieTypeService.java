package com.example.movie.Service;

import com.example.movie.Model.MovieType;
import com.example.movie.Repository.MovieTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieTypeService {

    final MovieTypeRepo movieTypeRepo;

    @Autowired
    public MovieTypeService(MovieTypeRepo movieTypeRepo) {
        this.movieTypeRepo = movieTypeRepo;
    }

    public List<MovieType> getMovieTypes(){
        return movieTypeRepo.findAll();
    }

    public MovieType getMovieTypeById(Long id){
        return movieTypeRepo.findById(id).
                orElseThrow(()-> new IllegalArgumentException("MovieType with id " + id + " not found"));
    }

    public void deleteMovieType(Long id){
        boolean exists = movieTypeRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("MovieType with id " + id + " does not exist");
        }
        movieTypeRepo.deleteById(id);
    }

    public void createMovieType(MovieType movieType){
        Optional<MovieType> movieTypeExists = movieTypeRepo.findMovieTypeByName(movieType.getName());
        if(movieTypeExists.isPresent()){
            throw new IllegalStateException("MovieType with name " + movieType.getName() + " already exists");
        }
        movieTypeRepo.save(movieType);
    }

}
