package com.example.movie.Service;

import com.example.movie.Model.Slide;
import com.example.movie.Repository.SlideRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideService {
    private final SlideRepo slideRepo;

    public SlideService(SlideRepo slideRepo) {
        this.slideRepo = slideRepo;
    }

//    all slides
    public List<Slide> getSlides() {
        return slideRepo.findAll();
    }

    public Slide getSlideById(Long id) {
        return slideRepo.findById(id).orElseThrow(() -> new IllegalStateException("Slide with id " + id + " not found"));
    }

}
