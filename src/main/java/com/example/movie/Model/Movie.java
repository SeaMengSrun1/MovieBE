// src/main/java/com/example/movie/Model/Movie.java
package com.example.movie.Model;

import com.example.movie.Model.JunctionTable.Actor_Movie;
import com.example.movie.Model.JunctionTable.Director_Movie;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


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
    @Column(length = 1000)
    private String posterUrl;
    private String rating;
    private String movieUrl;
    private String actorName;


    @ManyToOne
    @JoinColumn(name = "movie_type_id")
    private MovieType movieType;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Bookmark> bookmarks;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Actor_Movie> actorMovies;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Director_Movie> directorMovies;

//    one to many reviews
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;
}
