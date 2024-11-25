package com.example.movie.Controller;

import com.example.movie.DTO.ResponseDTO;
import com.example.movie.Model.History;
import com.example.movie.Service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public ResponseDTO<List<History>> getHistories() {
        return new ResponseDTO<>("200", "Success", historyService.getHistories());
    }

    @GetMapping("/{id}")
    public ResponseDTO<History> getHistoryById(@PathVariable Long id) {
        return new ResponseDTO<>("200", "Success", historyService.getHistoryById(id));
    }

    @GetMapping("/progress/{progress}")
    public ResponseDTO<History> getHistoryByProgress(@PathVariable String progress) {
        return new ResponseDTO<>("200", "Success", historyService.getHistoryByProgress(progress));
    }
    

    @GetMapping("/date/{date}")
    public ResponseDTO<History> getHistoryByDate(@PathVariable String date) {
        return new ResponseDTO<>("200", "Success", historyService.getHistoryByDate(date));
    }

    @DeleteMapping("/{id}")
    public ResponseDTO<String> deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
        return new ResponseDTO<>("200", "Success", "History deleted");
    }

    @DeleteMapping("/progress/{progress}")
    public ResponseDTO<String> deleteHistoryByProgress(@PathVariable String progress) {
        historyService.deleteHistoryByProgress(progress);
        return new ResponseDTO<>("200", "Success", "History deleted");
    }

    @PutMapping("/{id}")
    public ResponseDTO<String> updateHistory(@PathVariable Long id, History history) {
        historyService.updateHistory(id, history);
        return new ResponseDTO<>("200", "Success", "History updated");
    }

    @PostMapping
    public ResponseDTO<String> createHistory(History history) {
        historyService.createHistory(history);
        return new ResponseDTO<>("200", "Success", "History created");
    }

}
