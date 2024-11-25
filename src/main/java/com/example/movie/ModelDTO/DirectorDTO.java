package com.example.movie.ModelDTO;

import lombok.Data;

@Data
public class DirectorDTO {
    private Long id;
    private String name;
    private String birthDate;
    private String ProfileUrl;
    private String biography;

    public DirectorDTO(Long id, String name, String birthDate, String ProfileUrl, String biography) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.ProfileUrl = ProfileUrl;
        this.biography = biography;
    }
}
