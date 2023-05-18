package com.hmit.banking.service.bank;

import com.hmit.banking.models.Bank;
import com.hmit.banking.repositories.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BankSerivce implements IBankService {

    @Autowired
    private BankRepo bankRepo;

    @Override
    public List<Bank> findAll() {
        return bankRepo.findAll();
    }

    @Override
    public boolean save(Bank bank) {
        bankRepo.save(bank);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        bankRepo.delete(bankRepo.findById(id).get());
        return true;
    }

    @Override
    public Bank findById(Long id) {
        Optional<Bank> bank = bankRepo.findById(id);
        return bank.orElse(null);
    }
}
