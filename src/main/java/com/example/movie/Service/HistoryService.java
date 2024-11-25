package com.example.movie.Service;

import com.example.movie.Model.History;
import com.example.movie.Repository.HistoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    private final HistoryRepo historyRepo;

    public HistoryService(HistoryRepo historyRepo) {
        this.historyRepo = historyRepo;
    }

    public List<History> getHistories() {
        return historyRepo.findAll();
    }

    public History getHistoryById(Long id) {
        return historyRepo.findById(id).orElse(null);
    }

    public void updateHistory(Long id, History history) {
        History historyToUpdate = historyRepo.findById(id).orElse(null);
        if (historyToUpdate != null) {
            historyToUpdate.setDuration(history.getDuration());
            historyToUpdate.setProgress(history.getProgress());
            historyToUpdate.setTime(history.getTime());
            historyToUpdate.setDate(history.getDate());
            historyRepo.save(historyToUpdate);
        }
    }

    public void createHistory(History history) {
        historyRepo.save(history);
    }

    public void deleteHistory(Long id) {
        historyRepo.deleteById(id);
    }

    public History getHistoryByProgress(String progress) {
        return historyRepo.findByProgress(progress).orElse(null);
    }

    public History getHistoryByDate(String date) {
        return historyRepo.findByDate(date).orElse(null);
    }

    public void deleteHistoryByProgress(String progress) {
        History history = historyRepo.findByProgress(progress).orElse(null);
        if (history != null) {
            historyRepo.delete(history);
        }
    }
}
