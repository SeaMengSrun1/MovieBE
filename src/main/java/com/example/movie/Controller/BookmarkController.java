package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.Bookmark;
import com.example.movie.Repository.BookmarkRepo;
import com.example.movie.Service.BookmarkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping
    public ResponseDTO<List<Bookmark>> getBookmarks(){
        return new ResponseDTO<>("200", "Success", bookmarkService.getBookmarks());
    }

    @GetMapping("/{id}")
    public ResponseDTO<Bookmark> getBookmarkById(@PathVariable Long id){
        return new ResponseDTO<>("200", "Success", bookmarkService.getBookmarkById(id));
    }

    @GetMapping("/{date}")
    public ResponseDTO<Bookmark> getBookmarkByDate(@PathVariable String date){
        return new ResponseDTO<>("200", "Success", bookmarkService.getBookmarkByDate(date));
    }

    @PutMapping("/{id}")
    public ResponseDTO<String> updateBookmark(Long id, Bookmark bookmark){
        bookmarkService.updateBookmark(id, bookmark);
        return new ResponseDTO<>("200", "Success", "Bookmark updated");
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteBookmark(@PathVariable Long id){
        bookmarkService.deleteBookmark(id);
        return new ResponseDTO<>("200", "Success", "Bookmark deleted");
    }

    @PostMapping
    public ResponseDTO<String> createBookmark(Bookmark bookmark){
        bookmarkService.createBookmark(bookmark);
        return new ResponseDTO<>("200", "Success", "Bookmark created");
    }

}
