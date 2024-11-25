package com.example.movie.Model.JunctionTable;

import com.example.movie.Model.Bookmark;
import com.example.movie.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_bookmark")
public class UserBookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookmark_id", nullable = false)
    private Bookmark bookmark;

    @Column(nullable = false)
    private String savedDate;
}

