package com.example.movie.Service;

import com.example.movie.Model.JunctionTable.UserBookmark;
import com.example.movie.Repository.UserBookmarkRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookmarkService {
    private final UserBookmarkRepo userBookmarkRepo;

    public UserBookmarkService(UserBookmarkRepo userBookmarkRepo) {
        this.userBookmarkRepo = userBookmarkRepo;
    }


    public UserBookmark saveUserBookmark(UserBookmark userBookmark) {
        return userBookmarkRepo.save(userBookmark);
    }

    public List<UserBookmark> getAllUserBookmarks() {
        return userBookmarkRepo.findAll();
    }

    public List<UserBookmark> getBookmarksByUserId(Long userId) {
        return userBookmarkRepo.findBookmarksByUserId(userId);
    }

    public List<UserBookmark> getUsersByBookmarkId(Long bookmarkId) {
        return userBookmarkRepo.findUsersByBookmarkId(bookmarkId);
    }

    public void deleteUserBookmark(Long id) {
        userBookmarkRepo.deleteById(id);
    }

}
