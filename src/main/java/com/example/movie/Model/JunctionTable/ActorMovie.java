package com.example.movie.Model.JunctionTable;

import com.example.movie.Model.Actor;
import com.example.movie.Model.Movie;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class ActorMovie {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}