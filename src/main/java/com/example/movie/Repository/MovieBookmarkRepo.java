package com.example.movie.Repository;

import com.example.movie.Model.JunctionTable.MovieBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieBookmarkRepo extends JpaRepository<MovieBookmark, Long> {

    @Query("SELECT mb.movie FROM MovieBookmark mb WHERE mb.bookmark.id = :bookmarkId")
    List<MovieBookmark> findMoviesByBookmarkId(@Param("bookmarkId") Long bookmarkId);

    @Query("SELECT mb.bookmark FROM MovieBookmark mb WHERE mb.movie.id = :movieId")
    List<MovieBookmark> findBookmarksByMovieId(@Param("movieId") Long movieId);
}
