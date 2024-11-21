package com.example.movie.Repository;
import com.example.movie.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
