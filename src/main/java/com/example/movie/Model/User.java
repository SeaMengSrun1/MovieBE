package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String status;
    private String created_at;

//   @OneToMany
//    @JoinColumn(name = "user_id")
//    private List<Review> reviews;

}
