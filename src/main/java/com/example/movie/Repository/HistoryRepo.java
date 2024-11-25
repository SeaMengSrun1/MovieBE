package com.example.movie.Repository;

import com.example.movie.Model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface HistoryRepo extends JpaRepository<History, Long> {
    Optional<History> findByProgress(String progress);
    Optional<History> findByDate(String date);
}