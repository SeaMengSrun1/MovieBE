package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String review;
    private String rating;
    private String comment;
    private String review_date;
    private Long movie_id;
    private Long user_id;
//    @ManyToOne
//    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
//    private Movie movie;

}
