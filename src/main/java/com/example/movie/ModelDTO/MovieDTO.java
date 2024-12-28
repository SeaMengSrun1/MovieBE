package com.example.movie.ModelDTO;

import lombok.Data;

@Data
public class MovieDTO {

    private Long id;
    private String title;
    private String description;
    private String releaseDate;
    private String posterUrl;
    private String rating;
    private String movieTypeName;
    private String movieUrl;

    public MovieDTO(Long id, String title, String description, String releaseDate, String posterUrl, String rating, String movieTypeName, String movieUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.movieTypeName = movieTypeName;
        this.movieUrl = movieUrl;
    }

}

