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

    public void createSlide(Slide slide) {
        slideRepo.save(slide);
    }

    public void deleteSlide(Long id) {
        boolean exists = slideRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Slide with id " + id + " does not exist");
        }
        slideRepo.deleteById(id);
    }

    public void updateSlide(Long id, Slide slide) {
        Slide slideToUpdate = slideRepo.findById(id).orElseThrow(() -> new IllegalStateException("Slide with id " + id + " not found"));
        slideToUpdate.setSlideTitle(slide.getSlideTitle());
        slideToUpdate.setSlideUrl(slide.getSlideUrl());
        slideRepo.save(slideToUpdate);
    }

    public void createSlides(List<Slide> slides) {
        slideRepo.saveAll(slides);
    }

}
