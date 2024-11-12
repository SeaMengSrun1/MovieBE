package com.example.movie.Controller;

import com.example.movie.Model.Slider;
import com.example.movie.Service.SlideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "slide")
public class SlideController {

    final SlideService slideService;

    public SlideController(SlideService slideService) {
        this.slideService = slideService;
    }

    @GetMapping
    public List<Slider> getSlides() {
        return slideService.getSlides();
    }

    @GetMapping(path = "/{id}")
    public Slider getSlideById(@PathVariable("id") Long id) {
        return slideService.getSlideById(id);
    }

    @PostMapping
    public void createSlide(@RequestBody Slider slide) {
        slideService.createSlide(slide);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSlide(@PathVariable("id") Long id) {
        slideService.deleteSlide(id);
    }
}
