package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movieType")
@Data
public class MovieType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
