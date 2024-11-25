package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.JunctionTable.UserBookmark;
import com.example.movie.Service.UserBookmarkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userbookmark")
public class UserBookmarkController {
    private final UserBookmarkService userBookmarkService;

    public UserBookmarkController(UserBookmarkService userBookmarkService) {
        this.userBookmarkService = userBookmarkService;
    }

    @GetMapping
    public ResponseDTO<List<UserBookmark>> getUserBookmarks() {
        return new ResponseDTO<>("200", "Success", userBookmarkService.getAllUserBookmarks());
    }


}
