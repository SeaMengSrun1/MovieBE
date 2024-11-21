package com.example.movie.Service;

import com.example.movie.Model.Review;
import com.example.movie.Repository.ReviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepo.findById(id);
    }

    public void createReview(Review review) {
        reviewRepo.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

    public void updateReview(Long id, Review review) {
        Optional<Review> reviewOptional = reviewRepo.findById(id);
        if(reviewOptional.isPresent()) {
            Review reviewToUpdate = reviewOptional.get();
            reviewToUpdate.setRating(review.getRating());
            reviewToUpdate.setComment(review.getComment());
            reviewRepo.save(reviewToUpdate);
        }
    }
}
