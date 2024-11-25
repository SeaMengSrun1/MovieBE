package com.example.movie.ModelDTO;
import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String role;
    private String profileUrl;

    public UserDTO(Long userId, String username, String email, String password, String role, String profileUrl) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profileUrl = profileUrl;
    }
}
