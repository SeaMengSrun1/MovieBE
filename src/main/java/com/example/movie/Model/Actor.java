package com.example.movie.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "actor")
@Data
public class Actor {

    @Id
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String ProfileUrl;
    private String biography;
}
