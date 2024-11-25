package com.example.movie.Repository;

import com.example.movie.Model.JunctionTable.UserBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface UserBookmarkRepo extends JpaRepository<UserBookmark, Long> {
    @Query("SELECT ub.bookmark FROM UserBookmark ub WHERE ub.user.userId = :userId")
    List<UserBookmark> findBookmarksByUserId(@Param("userId") Long userId);

    @Query("SELECT ub.user FROM UserBookmark ub WHERE ub.bookmark.id = :bookmarkId")
    List<UserBookmark> findUsersByBookmarkId(@Param("bookmarkId") Long bookmarkId);
}
