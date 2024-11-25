package com.example.movie.Model.JunctionTable;
import com.example.movie.Model.Bookmark;
import com.example.movie.Model.Movie;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "movie_bookmark")
public class MovieBookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "bookmark_id", nullable = false)
    private Bookmark bookmark;
}