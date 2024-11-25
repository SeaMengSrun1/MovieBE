package com.example.movie.Service;

import com.example.movie.Model.Bookmark;
import com.example.movie.Repository.BookmarkRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {
    private final BookmarkRepo bookmarkRepo;

    public BookmarkService(BookmarkRepo bookmarkRepo) {
        this.bookmarkRepo = bookmarkRepo;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarkRepo.findAll();
    }

    public Bookmark getBookmarkById(Long id) {
        return bookmarkRepo.findById(id).orElseThrow(() -> new IllegalStateException("Bookmark with id " + id + " not found"));
    }
    public Bookmark getBookmarkByDate(String date){
        return bookmarkRepo.findBookmarkByDate(date).orElseThrow(() -> new IllegalStateException("Bookmark with date " + date + " not found"));
    }

    public void createBookmark(Bookmark bookmark) {
        bookmarkRepo.save(bookmark);
    }

    public void deleteBookmark(Long id) {
        boolean exists = bookmarkRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Bookmark with id " + id + " does not exist");
        }
        bookmarkRepo.deleteById(id);
    }

    public void updateBookmark(Long id, Bookmark bookmark) {
        Bookmark bookmarkToUpdate = bookmarkRepo.findById(id).orElseThrow(() -> new IllegalStateException("Bookmark with id " + id + " not found"));
        bookmarkToUpdate.setDate(bookmark.getDate());
        bookmarkRepo.save(bookmarkToUpdate);
    }

}

