package com.example.movie.Service;

import com.example.movie.Model.Movie;
import com.example.movie.ModelDTO.MovieDTO;
import com.example.movie.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    final private MovieRepo movieRepository;

    @Autowired
    public MovieService(MovieRepo movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Movie with id " + id + " not found"));
    }

    public void createMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());
        if(movieOptional.isPresent()){
            throw new IllegalStateException("Movie with title " + movie.getTitle() + " already exists");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long id){
        boolean exists = movieRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Movie with id " + id + " does not exist");
        }
        movieRepository.deleteById(id);
    }

    public Map<String, List<Movie>> getMoviesByGroup(){
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().collect(Collectors.groupingBy(movie -> movie.getMovieType().getName()));
    }

    public List<MovieDTO> getAllMoviesWithMovieType(){
        return movieRepository.findAllMoviesWithMovieType();
    }

}
