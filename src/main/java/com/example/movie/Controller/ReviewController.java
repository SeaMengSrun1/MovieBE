package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.Review;
import com.example.movie.ModelDTO.MovieDTO;
import com.example.movie.Service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseDTO<List<Review>> getReviews() {
        return new ResponseDTO<>("200", "Success", reviewService.getAllReviews());
    }

    @GetMapping(path = "/{id}")
    public ResponseDTO<Review> getReviewById(Long id) {
        return new ResponseDTO<>("200", "Success", reviewService.getReviewById(id).get());
    }

    @PostMapping
    public void createReview(@RequestBody Review review) {
        reviewService.createReview(review);
    }

    @PutMapping(path = "/{id}")
    public void updateReview(@PathVariable("id") Long id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    }
}
