package com.example.movie.ModelDTO;

import lombok.Data;

@Data
public class BookmarkDTO {
    private Long id;
    private String date;

    public BookmarkDTO(Long id, String date) {
        this.id = id;
        this.date = date;
    }
}
