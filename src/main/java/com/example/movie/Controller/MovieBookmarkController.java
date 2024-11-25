package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.JunctionTable.MovieBookmark;
import com.example.movie.Service.MovieBookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moviebookmark")
public class MovieBookmarkController {
    private final MovieBookmarkService movieBookmarkService;

    public MovieBookmarkController(MovieBookmarkService movieBookmarkService) {
        this.movieBookmarkService = movieBookmarkService;
    }
    @GetMapping
    public ResponseDTO<List<MovieBookmark>> getMovieBookmarks() {
        return new ResponseDTO<>("200", "Success", movieBookmarkService.getAllMovieBookmarks());
    }
    @GetMapping("/{id}")
    public ResponseDTO<List<MovieBookmark>> getMoviesByBookmarkId(@PathVariable Long id) {
        return new ResponseDTO<>("200", "Success", movieBookmarkService.getMoviesByBookmarkId(id));
    }

    @PostMapping
    public ResponseDTO<MovieBookmark> saveMovieBookmark(@RequestBody MovieBookmark movieBookmark) {
        return new ResponseDTO<>("200", "Success", movieBookmarkService.saveMovieBookmark(movieBookmark));
    }

    @PutMapping("/{id}")
    public ResponseDTO<MovieBookmark> updateMovieBookmark(@RequestBody MovieBookmark movieBookmark) {
        return new ResponseDTO<>("200", "Success", movieBookmarkService.saveMovieBookmark(movieBookmark));
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteMovieBookmark(@PathVariable Long id) {
        movieBookmarkService.deleteMovieBookmark(id);
        return new ResponseDTO<>("200", "Success", "Movie Bookmark Deleted");
    }
}
