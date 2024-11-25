package com.example.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.movie.Model.JunctionTable.DirectorMovie;

import java.util.List;

@Repository
public interface DirectorMovieRepo extends JpaRepository<DirectorMovie, Long> {

    @Query("SELECT dm.director FROM DirectorMovie dm WHERE dm.movie.id = :movieId")
    List<DirectorMovie> findDirectorsByMovieId(@Param("movieId") Long movieId);

    @Query("SELECT dm.movie FROM DirectorMovie dm WHERE dm.director.id = :directorId")
    List<DirectorMovie> findMoviesByDirectorId(@Param("directorId") Long directorId);
}
