package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.Episode;
import com.example.movie.Service.EpisodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseDTO<List<Episode>> getEpisodes(){
        return new ResponseDTO<>("200", "Success", episodeService.getEpisodes());
    }

    @GetMapping("/{id}")
    public ResponseDTO<Episode> getEpisodeById(@PathVariable Long id){
        return new ResponseDTO<>("200", "Success", episodeService.getEpisodeById(id));
    }

    @GetMapping("/{title}")
    public ResponseDTO<Episode> getEpisodeByTitle(@PathVariable String title){
        return new ResponseDTO<>("200", "Success", episodeService.getEpisodeByTitle(title));
    }

    @GetMapping("/{season}")
    public ResponseDTO<Episode> getEpisodeBySeason(@PathVariable String season){
        return new ResponseDTO<>("200", "Success", episodeService.getEpisodeBySeason(season));
    }

    @PutMapping("/{id}")
    public ResponseDTO<String> updateEpisode(Long id, Episode episode){
        episodeService.updateEpisode(id, episode);
        return new ResponseDTO<>("200", "Success", "Episode updated");
    }

    @PostMapping
    public ResponseDTO<String> createEpisode( Episode episode){
        episodeService.createEpisode(episode);
        return new ResponseDTO<>("200", "Success", "Episode created");
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteEpisode(@PathVariable Long id){
        episodeService.deleteEpisode(id);
        return new ResponseDTO<>("200", "Success", "Episode deleted");
    }
}
