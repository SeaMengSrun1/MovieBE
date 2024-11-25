package com.example.movie.Repository;

import com.example.movie.Model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookmarkRepo extends JpaRepository<Bookmark, Long> {
    Optional<Bookmark> findBookmarkByDate (String date);
}
