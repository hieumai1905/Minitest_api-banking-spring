package com.hmit.banking.service.history;

import com.hmit.banking.models.History;
import com.hmit.banking.repositories.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService implements IHistoryService {

    @Autowired
    private HistoryRepo historyRepo;

    @Override
    public List<History> findAll() {
        return historyRepo.findAll();
    }

    @Override
    public boolean save(History history) {
        historyRepo.save(history);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        historyRepo.delete(historyRepo.findById(id).get());
        return true;
    }

    @Override
    public History findById(Long id) {
        return historyRepo.findById(id).orElse(null);
    }
}
