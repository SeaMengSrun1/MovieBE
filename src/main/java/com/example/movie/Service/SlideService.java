package com.example.movie.Service;

import com.example.movie.Model.Slider;
import com.example.movie.Repository.SlideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlideService {
    final SlideRepo slideRepo;

    @Autowired
    public SlideService(SlideRepo slideRepo) {
        this.slideRepo = slideRepo;
    }
    public List<Slider> getSlides() {
        return slideRepo.findAll();
    }

    public Slider getSlideById(Long id) {
        return slideRepo.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Slide with id " + id + " not found"));
    }

    public void createSlide(Slider slide) {
        slideRepo.save(slide);
    }

    public void deleteSlide(Long id) {
        boolean exists = slideRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Slide with id " + id + " does not exist");
        }
        slideRepo.deleteById(id);
    }
}
