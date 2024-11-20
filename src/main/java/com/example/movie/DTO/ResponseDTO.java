package com.example.movie.DTO;

import com.example.movie.Model.Slide;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseDTO<T> {
    private String status;
    private String message;
    private T data;

    public ResponseDTO(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


}