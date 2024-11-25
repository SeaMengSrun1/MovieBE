package com.example.movie.Service;

import com.example.movie.Model.Episode;
import com.example.movie.Repository.EpisodeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {
    private final EpisodeRepo episodeRepo;

    public EpisodeService(EpisodeRepo episodeRepo) {
        this.episodeRepo = episodeRepo;
    }

    public List<Episode> getEpisodes() {
        return episodeRepo.findAll();
    }

    public Episode getEpisodeById(Long id) {
        return episodeRepo.findEpisodeById(id).orElse(null);
    }

    public Episode getEpisodeByTitle(String title) {
        return episodeRepo.findEpisodeByTitle(title).orElse(null);
    }

    public Episode getEpisodeBySeason(String season) {
        return episodeRepo.findEpisodeBySeason(season).orElse(null);
    }

    public void updateEpisode(Long id, Episode episode) {
        Episode episodeToUpdate = episodeRepo.findEpisodeById(id).orElse(null);
        if (episodeToUpdate != null) {
            episodeToUpdate.setTitle(episode.getTitle());
            episodeToUpdate.setSeason(episode.getSeason());
            episodeToUpdate.setEpisode(episode.getEpisode());
            episodeToUpdate.setReleaseDate(episode.getReleaseDate());
            episodeToUpdate.setEpisodeUrl(episode.getEpisodeUrl());
            episodeRepo.save(episodeToUpdate);
        }
    }

    public void createEpisode(Episode episode) {
        episodeRepo.save(episode);
    }

    public void deleteEpisode(Long id) {
        episodeRepo.deleteById(id);
    }

    public void deleteAllEpisodes() {
        episodeRepo.deleteAll();
    }

}
