package com.example.movie.Repository;

import com.example.movie.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DirectorRepo extends JpaRepository<Director, Long> {
    Optional<Director> findDirectorByName(String name);
    Optional<Director> findDirectorById (Long id);
}
