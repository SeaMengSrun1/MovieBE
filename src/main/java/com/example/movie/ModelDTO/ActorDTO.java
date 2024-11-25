package com.example.movie.ModelDTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ActorDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String ProfileUrl;
    private String biography;

    public ActorDTO(Long id, String name, LocalDate birthDate, String ProfileUrl, String biography) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.ProfileUrl = ProfileUrl;
        this.biography = biography;
    }
}
