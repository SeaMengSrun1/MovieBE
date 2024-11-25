package com.example.movie.Service;

import com.example.movie.Model.JunctionTable.MovieBookmark;
import com.example.movie.Repository.MovieBookmarkRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieBookmarkService {
    private final MovieBookmarkRepo movieBookmarkRepo;

    public MovieBookmarkService(MovieBookmarkRepo movieBookmarkRepo) {
        this.movieBookmarkRepo = movieBookmarkRepo;
    }

    public List<MovieBookmark> getMoviesByBookmarkId(Long bookmarkId) {
        return movieBookmarkRepo.findMoviesByBookmarkId(bookmarkId);
    }

    public List<MovieBookmark> getBookmarksByMovieId(Long movieId) {
        return movieBookmarkRepo.findBookmarksByMovieId(movieId);
    }

    public MovieBookmark saveMovieBookmark(MovieBookmark movieBookmark) {
        return movieBookmarkRepo.save(movieBookmark);
    }

    public void deleteMovieBookmark(Long id) {
        movieBookmarkRepo.deleteById(id);
    }

    public List<MovieBookmark> getAllMovieBookmarks() {
        return movieBookmarkRepo.findAll();
    }

}
