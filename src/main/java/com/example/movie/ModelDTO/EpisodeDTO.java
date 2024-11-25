package com.example.movie.ModelDTO;

import lombok.Data;

@Data
public class EpisodeDTO {
    private Long id;
    private String title;
    private String season;
    private String episode;
    private String releaseDate;
    private String episodeUrl;

    public EpisodeDTO(Long id, String title, String season, String episode, String releaseDate, String episodeUrl) {
        this.id = id;
        this.title = title;
        this.season = season;
        this.episode = episode;
        this.releaseDate = releaseDate;
        this.episodeUrl = episodeUrl;
    }
}
