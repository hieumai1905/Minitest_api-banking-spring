package com.hmit.banking.controllers;

import com.hmit.banking.models.Bank;
import com.hmit.banking.service.bank.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private IBankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getAll() {
        return ResponseEntity.ok().body(bankService.findAll());
    }
}
