package com.example.herokudemo.service.impl;

import com.example.herokudemo.exception.EntityNotFoundException;
import com.example.herokudemo.model.Account;
import com.example.herokudemo.repository.AccountRepository;
import com.example.herokudemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account add(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public void delete(long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getById(long id) throws EntityNotFoundException {
        return accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Account edit(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public double getAccountsSum() {
        return accountRepository.getAccountsSum();
    }
}
