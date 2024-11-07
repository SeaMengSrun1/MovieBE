package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String releaseDate;
    private String posterUrl;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "movie_type_id")
    private MovieType movieType;
}