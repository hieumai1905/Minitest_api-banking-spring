package com.hmit.banking.controllers;

import com.hmit.banking.models.History;
import com.hmit.banking.service.history.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/histories")
public class HistoryController {

    @Autowired
    private IHistoryService historyService;

    @GetMapping
    public ResponseEntity<List<History>> getAll() {
        return ResponseEntity.ok().body(historyService.findAll());
    }
}
