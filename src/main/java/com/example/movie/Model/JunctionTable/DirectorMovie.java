package com.example.movie.Model.JunctionTable;

import com.example.movie.Model.Movie;
import jakarta.persistence.*;
import lombok.Data;
import com.example.movie.Model.Director;

@Entity
@Data
public class DirectorMovie {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

}
