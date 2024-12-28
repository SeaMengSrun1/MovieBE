package com.example.movie.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    @JsonIgnore
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;


}
