package com.example.movie.Model;

import com.example.movie.Model.JunctionTable.Director_Movie;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthDate;
    private String ProfileUrl;
    private String biography;

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Director_Movie> movies;
}
