package com.example.movie.Repository;

import com.example.movie.Model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EpisodeRepo extends JpaRepository<Episode, Long> {
    Optional<Episode> findEpisodeByTitle(String title);
    Optional<Episode> findEpisodeBySeason(String season);
    Optional<Episode> findEpisodeById(Long id);

}
