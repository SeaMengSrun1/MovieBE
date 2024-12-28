package com.example.movie.Model.JunctionTable;

import com.example.movie.Model.Director;
import com.example.movie.Model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "director_movie")
@Data
public class Director_Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    @JsonIgnore
    private Director director;  // Changed from `actor` to `director`

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}