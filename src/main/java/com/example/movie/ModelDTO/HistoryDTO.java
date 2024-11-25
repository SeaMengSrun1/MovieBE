package com.example.movie.ModelDTO;

import lombok.Data;

@Data
public class HistoryDTO {
    private Long id;
    private String progress;
    private String last_watched;
    private String date;
    private String time;
    private String duration;

    public HistoryDTO(Long id, String progress, String last_watched, String date, String time, String duration) {
        this.id = id;
        this.progress = progress;
        this.last_watched = last_watched;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }
}
