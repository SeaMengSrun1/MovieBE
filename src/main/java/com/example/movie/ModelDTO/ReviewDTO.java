package com.example.movie.ModelDTO;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long id;
    private String review;
    private String rating;
    private String comment;
    private String review_date;
    private Long movie_id;
    private Long user_id;

    public ReviewDTO(Long id, String review, String rating, String comment, String review_date, Long movie_id, Long user_id) {
        this.id = id;
        this.review = review;
        this.rating = rating;
        this.comment = comment;
        this.review_date = review_date;
        this.movie_id = movie_id;
        this.user_id = user_id;
    }
}
