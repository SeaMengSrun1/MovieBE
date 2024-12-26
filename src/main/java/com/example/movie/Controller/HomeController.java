package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Service.MovieService;
import com.example.movie.Service.SlideService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final SlideService slideService;
    private final MovieService movieService;

    public HomeController(SlideService slideService, MovieService movieService) {
        this.slideService = slideService;
        this.movieService = movieService;
    }

    // src/main/java/com/example/movie/Controller/HomeController.java
    @GetMapping
    public ResponseDTO<Map<String, Object>> getHomeData() {
        Map<String, Object> homeData = new HashMap<>();
        homeData.put("slides", slideService.getSlides());
        homeData.put("latestMovies", movieService.getLatestMovies());
        homeData.put("randomMovies", movieService.getRandomMovies());
        return new ResponseDTO<>("200", "Success", homeData);
    }
}
