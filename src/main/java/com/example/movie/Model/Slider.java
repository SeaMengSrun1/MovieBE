package com.example.movie.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "slider")
public class Slider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sliderUrl;
}
