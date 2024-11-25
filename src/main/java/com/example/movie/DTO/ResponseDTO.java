package com.example.movie.DTO;

import com.example.movie.Model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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


    public static ResponseDTO<Map<String, String>> success(Map<String, String> tokenMap, String tokenGeneratedSuccessfully) {
        return new ResponseDTO<>("200", "Success", tokenMap);
    }
}