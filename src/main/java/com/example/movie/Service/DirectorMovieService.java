package com.example.movie.Service;

import com.example.movie.Model.JunctionTable.DirectorMovie;
import com.example.movie.Repository.DirectorMovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorMovieService {
    private final DirectorMovieRepo directorMovieRepo;

    public DirectorMovieService(DirectorMovieRepo directorMovieRepo) {
        this.directorMovieRepo = directorMovieRepo;
    }

    public List<DirectorMovie> getDirectorsByMovieId(Long movieId) {
        return directorMovieRepo.findDirectorsByMovieId(movieId);
    }

    public List<DirectorMovie> getMoviesByDirectorId(Long id){
        return directorMovieRepo.findMoviesByDirectorId(id);
    }

    public DirectorMovie saveDirectorMovie(DirectorMovie directorMovie) {
        return directorMovieRepo.save(directorMovie);
    }

    public void deleteDirectorMovie(Long id) {
        directorMovieRepo.deleteById(id);
    }

    public DirectorMovie updateDirectorMovie(DirectorMovie directorMovie) {
        return directorMovieRepo.save(directorMovie);
    }

    public DirectorMovie getDirectorMovieById(Long id) {
        return directorMovieRepo.findById(id).orElse(null);
    }

    public List<DirectorMovie> getAllDirectorMovies() {
        return directorMovieRepo.findAll();
    }

    public List<DirectorMovie> getDirectorMoviesByDirectorId(Long directorId) {
        return directorMovieRepo.findMoviesByDirectorId(directorId);
    }

    public List<DirectorMovie> getDirectorMoviesByMovieId(Long movieId) {
        return directorMovieRepo.findDirectorsByMovieId(movieId);
    }

    public void deleteDirectorMovieByDirectorId(Long directorId) {
        List<DirectorMovie> directorMovies = directorMovieRepo.findMoviesByDirectorId(directorId);
        for (DirectorMovie directorMovie : directorMovies) {
            directorMovieRepo.deleteById(directorMovie.getId());
        }
    }
}
