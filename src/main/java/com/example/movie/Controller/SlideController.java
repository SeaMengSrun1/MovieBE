package com.example.movie.Controller;

import com.example.movie.Model.Slide;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.movie.Service.SlideService;
import com.example.movie.DTO.ResponseDTO;

import java.util.List;

@RestController
@RequestMapping(path = "/slide")

public class SlideController {
    private final SlideService slideService;

    public SlideController(SlideService slideService) {
        this.slideService = slideService;
    }

//    get all slides and return as dto
    @GetMapping
    public ResponseDTO<List<Slide>> getSlides() {
        return new ResponseDTO<>("200", "Success", slideService.getSlides());
    }


    @GetMapping(path = "/{id}")
    public ResponseDTO<Slide> getSlideById(@PathVariable("id") Long id) {
        return new ResponseDTO<>("200", "Success", slideService.getSlideById(id));
    }
}
