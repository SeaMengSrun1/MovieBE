package com.example.movie.Repository;

import com.example.movie.Model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlideRepo extends JpaRepository<Slide, Long> {
    Optional<Slide> findSlideBySlideUrl(String slideUrl);

}
