package com.hmit.banking.service.account;

import com.hmit.banking.models.Account;
import com.hmit.banking.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// @Service is a specialization of the @Component annotation with the additional functionality of declaring the class as a Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public boolean save(Account account) {
        accountRepo.save(account);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        accountRepo.delete(accountRepo.findById(id).get());
        return false;
    }

    @Override
    public Account findById(Long id) {
        return accountRepo.findById(id).orElse(null);
    }
}
